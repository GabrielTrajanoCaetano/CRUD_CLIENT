package br.com.gabrieltrajanocaetano.todolist_client.todoClientService;

import br.com.gabrieltrajanocaetano.todolist_client.ClientController.clientToResponse.ClientResponse;
import br.com.gabrieltrajanocaetano.todolist_client.entity.TodoClient;
import br.com.gabrieltrajanocaetano.todolist_client.ClientController.ClientRequest.ClientRequest;
import br.com.gabrieltrajanocaetano.todolist_client.todoClientRepository.TodoClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoClientService {

    @Autowired
    private TodoClientRepository clientRepository;

    @Transactional
    public ClientResponse create(ClientRequest request){

        TodoClient client = new TodoClient();
        BeanUtils.copyProperties(request, client);

        TodoClient savedClient = clientRepository.save(client);

        ClientResponse response = new ClientResponse();
        BeanUtils.copyProperties(savedClient,response);


        return response;
    }

    public ClientResponse listById(Long id){

        TodoClient client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        ClientResponse response = new ClientResponse();
        BeanUtils.copyProperties(client, response);

        return response;
    }

    public List<TodoClient> list(){
       return clientRepository.findAll();
    }

    /*
    public List<TodoClient> update(){

    }

    /*

    public List<TodoClient> delete(){

    }

     */
}
