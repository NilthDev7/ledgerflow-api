package ledgerFlow.service;

import ledgerFlow.model.dto.response.InstituicaoRetornoDTO;
import ledgerFlow.model.dto.request.InstituicaoCriacaoDTO;
import ledgerFlow.model.entity.Instituicao;
import ledgerFlow.mapper.InstituicaoMapper;
import ledgerFlow.repository.InstituicaoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstituicaoService {

    private final InstituicaoRepository instituicaoRepository;

    public InstituicaoService(InstituicaoRepository instituicaoRepository){
        this.instituicaoRepository = instituicaoRepository;
    }

    public Optional<InstituicaoRetornoDTO> findByNae(String instituicaoNome){
        return instituicaoRepository.instituicaoNome(instituicaoNome).map(InstituicaoMapper::retorno);
    }

    public InstituicaoRetornoDTO cadInstituicao(InstituicaoCriacaoDTO i){
        Instituicao ins = InstituicaoMapper.toEntity(i);

        Instituicao saved = instituicaoRepository.save(ins);
        return InstituicaoMapper.retorno(saved);
    }
}
