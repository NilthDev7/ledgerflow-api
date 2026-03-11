package ledgerFlow.mapper;

import ledgerFlow.dto.EmpresaDTO;
import ledgerFlow.entity.Empresa;

public class EmpresaMapper {
    public static EmpresaDTO convertToDto(Empresa empresa){
        return new EmpresaDTO(
                empresa.getId(),
                empresa.getNome()
        );
    }
}
