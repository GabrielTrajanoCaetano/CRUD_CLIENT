package br.com.gabrieltrajanocaetano.todolist_client.todoClientService;

import br.com.gabrieltrajanocaetano.todolist_client.ClientController.ClientRequest.ClientRequest;
import br.com.gabrieltrajanocaetano.todolist_client.ClientController.clientToResponse.ClientResponse;
import br.com.gabrieltrajanocaetano.todolist_client.entity.TodoClient;
import br.com.gabrieltrajanocaetano.todolist_client.todoClientRepository.TodoClientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public ClientResponse update(Long id, ClientRequest request){
        TodoClient client = clientRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("ID não encontrado"));


            BeanUtils.copyProperties(request, client);

            TodoClient clientUpdateSave = clientRepository.save(client);

            ClientResponse clientResponse = new ClientResponse();
            BeanUtils.copyProperties(clientUpdateSave,clientResponse);

            return clientResponse;
    }

    /*

    public List<TodoClient> delete(){

    }

     */
}
