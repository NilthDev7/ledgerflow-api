package ledgerFlow.mapper;

import ledgerFlow.model.dto.request.UsuarioCriacaoDTO;
import ledgerFlow.model.dto.response.UsuarioRetornoDTO;
import ledgerFlow.model.entity.Usuario;

public class UsuarioMapper {

    public static UsuarioRetornoDTO convertToDto(Usuario usuario){
        if(usuario == null) return null;

        UsuarioRetornoDTO dto = new UsuarioRetornoDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setSaldo(usuario.getSaldo());
        return dto;
    }

    public static Usuario toEntity(UsuarioCriacaoDTO dto){
        if(dto == null) return null;

        Usuario user = new Usuario();
        user.setNome(dto.getNome());
        user.setLogin(dto.getLogin());
        user.setSenha(dto.getSenha());
        return user;
    }
}