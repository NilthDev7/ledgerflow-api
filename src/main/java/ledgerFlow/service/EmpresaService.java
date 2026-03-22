package ledgerFlow.service;

import ledgerFlow.model.dto.request.EmpresaDTO;
import ledgerFlow.mapper.EmpresaMapper;
import ledgerFlow.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaService {

    EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    public Optional<EmpresaDTO> getById(Long id){
        return empresaRepository.findById(id).map(EmpresaMapper::convertToDto);
    }

    public Optional<EmpresaDTO> getByName(String nome){
        return empresaRepository.findByNome(nome).map(EmpresaMapper::convertToDto);
    }

}
