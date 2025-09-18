package com.example.tedon.controller;

import com.example.tedon.dtoservice.ServicesRequest;
import com.example.tedon.dtoservice.ServicesResponse;
import com.example.tedon.service.ServicesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agent/services")
@AllArgsConstructor
public class ServicesController {


    @Autowired
    private ServicesService servicesService;


    @PostMapping("/create")
    public ServicesResponse create(@RequestBody ServicesRequest servicesRequest) {
        return servicesService.create(servicesRequest);
    }

    @GetMapping("/get")
    public List<ServicesResponse> getServices() {
        return servicesService.getAllServices();

    }
         @GetMapping("/{id}")
         public ResponseEntity<ServicesResponse> getServicesById(@PathVariable Long id){
         return servicesService.getServiceById(id).map(ResponseEntity::ok)
                 .orElseGet(()-> ResponseEntity.notFound().build());
         }
       @PutMapping("/{id}")

       public ServicesResponse update (@PathVariable Long id, @RequestBody ServicesRequest servicesRequest){
            return servicesService.updateById(id, servicesRequest);
        }

        @DeleteMapping("/{id}")

        public ResponseEntity<Void> deleteServices (@PathVariable Long id){
            servicesService.delete(id);
            return ResponseEntity.noContent().build();
        }

        //recherche



}