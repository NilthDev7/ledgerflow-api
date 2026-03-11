package ledgerFlow.service;
import ledgerFlow.dto.UsuarioCriacaoDTO;
import ledgerFlow.dto.UsuarioRetornoDTO;
import ledgerFlow.mapper.UsuarioMapper;
import ledgerFlow.repository.UsuarioRepository;
import ledgerFlow.entity.Usuario;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<UsuarioRetornoDTO> findByNome(String nome){
        return usuarioRepository.findByNome(nome)
                .map(UsuarioMapper::convertToDto);
    }

    public Optional<UsuarioRetornoDTO> findById(Long id){
        return usuarioRepository.findById(id)
                .map(UsuarioMapper::convertToDto);
    }

    public List<UsuarioRetornoDTO> findAll(){
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::convertToDto).toList();
    }

    public UsuarioRetornoDTO create(UsuarioCriacaoDTO user){
        Usuario usuario = UsuarioMapper.toEntity(user);

        Usuario saved = usuarioRepository.save(usuario);
        return UsuarioMapper.convertToDto(saved);
    }

    public Usuario findUserById(Long id){
        return usuarioRepository.findUserById(id);
    }

    public void validarTransacao(Usuario emitente, BigDecimal valor) throws Exception{
        if(emitente.getSaldo().compareTo(valor) < 0){
            throw new Exception("Saldo insuficiente!");
        }
    }
}