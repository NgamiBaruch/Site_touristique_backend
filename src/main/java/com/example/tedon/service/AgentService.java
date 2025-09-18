package com.example.tedon.service;

import com.example.tedon.dto.agent.AgentResponse;
import com.example.tedon.dto.agent.AgentResquest;


import java.util.List;
import java.util.Optional;

public interface AgentService {

    public AgentResponse create(AgentResquest agentResquest);
    public List<AgentResponse> getAllAgent();
    public Optional<AgentResponse> getAgentById(Long id);
    public AgentResponse updateById(Long id, AgentResquest agentResquest);
    public void delete(Long id);

    // permet de compter le nombre de agent

    Long countAgent();

    // faire la recherche



}
