package ledgerFlow.mapper;

import ledgerFlow.model.dto.response.InstituicaoRetornoDTO;
import ledgerFlow.model.dto.request.InstituicaoCriacaoDTO;
import ledgerFlow.model.entity.Instituicao;

public class InstituicaoMapper {

    public static InstituicaoRetornoDTO retorno(Instituicao instituicao){
        InstituicaoRetornoDTO ins = new InstituicaoRetornoDTO();
        ins.setId(instituicao.getId());
        ins.setInstituicaoNome(instituicao.getInstituicaoNome());
        return ins;
    }

    public static Instituicao toEntity(InstituicaoCriacaoDTO instituicao){
        Instituicao ins = new Instituicao();
        ins.setInstituicaoNome(instituicao.getInstituicaoNome());
        ins.setCod(instituicao.getCod());
        return ins;
    }
}
