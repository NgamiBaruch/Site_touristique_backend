package com.example.tedon.controller;


import com.example.tedon.dto.agent.AgentResponse;
import com.example.tedon.dto.agent.AgentResquest;
import com.example.tedon.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agent")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @PostMapping("/create")
    public AgentResponse create(@RequestBody AgentResquest agentResquest){
        return  agentService.create(agentResquest);
    }

    @GetMapping("/get")
    public List<AgentResponse> getAgent(){
        return agentService.getAllAgent();

    }
    @GetMapping("/{id}")
    public ResponseEntity<AgentResponse> getAgentById(@PathVariable Long id){
        return agentService.getAgentById(id).map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")

    public AgentResponse update(@PathVariable Long id,@RequestBody AgentResquest agentResquest){
        return agentService.updateById(id,agentResquest);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void>deleteAgent(@PathVariable Long id){
        agentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // compter les agent
    @GetMapping("/count/agent")
    public  Long countAgent(){
        return agentService.countAgent();
    }




}
