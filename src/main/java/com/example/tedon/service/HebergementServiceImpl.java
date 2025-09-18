package com.example.tedon.service;



import com.example.tedon.dto.hebergement.HebergementResquest;
import com.example.tedon.dto.hebergement.HebergementResponse;
import com.example.tedon.models.Hebergement;
import com.example.tedon.repository.HebergementRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class HebergementServiceImpl implements HebergementService{


    @Autowired
    private HebergementRepository hebergementRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public HebergementResponse create(HebergementResquest hebergementResquest) {
        Hebergement hebergements = modelMapper.map(hebergementResquest,Hebergement.class);
        Hebergement savedHebergement= hebergementRepository.save(hebergements);
        return modelMapper.map(savedHebergement, HebergementResponse.class);
    }


    @Override
    public List<HebergementResponse> getAllHebergement() {
         List< Hebergement > hebergements = hebergementRepository.findAll();
        return   hebergements.stream().map(hebergement -> modelMapper.map(hebergement, HebergementResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<HebergementResponse> getHerbergementById(Long id) {
         return hebergementRepository.findById(id)
                .map(hebergement -> modelMapper.map(hebergement, HebergementResponse.class));
    }

    @Override
    public HebergementResponse updateById(Long id, HebergementResquest hebergementResquest) {
        Hebergement hebergement = hebergementRepository.findById(id).orElseThrow();
        modelMapper.map(hebergementResquest,hebergement);
        hebergement = hebergementRepository.save(hebergement);
        return modelMapper.map(hebergement, HebergementResponse.class);

    }

    @Override
    public void delete(Long id) {
        hebergementRepository.deleteById(id);

    }
}
