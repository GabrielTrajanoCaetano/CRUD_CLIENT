package br.com.gabrieltrajanocaetano.todolist_client.ClientController;

import br.com.gabrieltrajanocaetano.todolist_client.ClientController.ClientRequest.ClientRequest;
import br.com.gabrieltrajanocaetano.todolist_client.todoClientRepository.TodoClientRepository;
import br.com.gabrieltrajanocaetano.todolist_client.todoClientService.TodoClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/shopping-list")
public class ClientController {

    @Autowired
    private TodoClientRepository clientRepository;
    @Autowired
    private TodoClientService todoClientService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody ClientRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(todoClientService.create(request));
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(todoClientService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id")  Long id){
        return ResponseEntity.status(HttpStatus.OK).body(todoClientService.listById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateById(@PathVariable ("id") Long id, @RequestBody ClientRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(todoClientService.update(id, request));
    }



}
