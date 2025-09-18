package com.example.tedon.service;
import com.example.tedon.dto.agent.AgentResponse;
import com.example.tedon.dto.agent.AgentResquest;

import com.example.tedon.models.Agent;

import com.example.tedon.repository.AgentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgentServiceImpl implements AgentService{

    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public AgentResponse create(AgentResquest agentResquest) {
        Agent agent = modelMapper.map(agentResquest, Agent.class);
        Agent savedAgent = agentRepository.save(agent);
        return modelMapper.map(savedAgent, AgentResponse.class);
    }



    @Override
    public List<AgentResponse> getAllAgent() {

        List<Agent> agents = agentRepository.findAll();
        return   agents.stream().map(agent -> modelMapper.map(agent, AgentResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AgentResponse> getAgentById(Long id) {
        return  agentRepository.findById(id)
                .map(agent -> modelMapper.map(agent, AgentResponse.class));
    }

    @Override
    public AgentResponse updateById(Long id, AgentResquest agentResquest) {
        Agent agent = agentRepository.findById(id).orElseThrow();
        modelMapper.map(agentResquest,agent);
        agent = agentRepository.save(agent);
        return modelMapper.map(agent,AgentResponse.class);

    }

    @Override
    public void delete(Long id) {

        agentRepository.deleteById(id);

    }

    @Override
    public Long countAgent() {
        return agentRepository.count();
    }




}
