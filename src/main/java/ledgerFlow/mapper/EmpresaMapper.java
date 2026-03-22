package ledgerFlow.mapper;

import ledgerFlow.model.dto.request.EmpresaDTO;
import ledgerFlow.model.entity.Empresa;

public class EmpresaMapper {
    public static EmpresaDTO convertToDto(Empresa empresa){
        return new EmpresaDTO(
                empresa.getId(),
                empresa.getNome()
        );
    }
}
