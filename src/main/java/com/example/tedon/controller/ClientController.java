package com.example.tedon.controller;

import com.example.tedon.dto.client.ClientResponse;
import com.example.tedon.dto.client.ClientResquest;
import com.example.tedon.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@AllArgsConstructor


public class ClientController {

    @Autowired
    private ClientService clientService;
    @PostMapping("/create")
    public ClientResponse create(@RequestBody ClientResquest clientResquest){
        return clientService.create(clientResquest);

    }
    @GetMapping ("/get")
    public List<ClientResponse>getClient(){
        return clientService.getAllClient();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse>getClientById(@PathVariable Long id) {
        return clientService.getClientById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }
    @PutMapping("/{id}")
    public ClientResponse updateClient(@PathVariable Long id,@RequestBody ClientResquest clientResquest){
        return clientService.updateById(id,clientResquest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteClient(@PathVariable Long id){
        clientService.delete(id);
      return ResponseEntity.noContent().build();

    }

    // compte le nombre de client
    @GetMapping("/count/client")
    public  Long countClient(){
        return clientService.CountClient();
    }

}




