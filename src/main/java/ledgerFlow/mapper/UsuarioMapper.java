package ledgerFlow.mapper;

import ledgerFlow.dto.UsuarioCriacaoDTO;
import ledgerFlow.dto.UsuarioRetornoDTO;
import ledgerFlow.entity.Usuario;

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