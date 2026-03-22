package ledgerFlow.service;
import ledgerFlow.model.dto.request.UsuarioCriacaoDTO;
import ledgerFlow.model.dto.response.UsuarioRetornoDTO;
import ledgerFlow.mapper.UsuarioMapper;
import ledgerFlow.repository.UsuarioRepository;
import ledgerFlow.model.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
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
        String senhaCriptografada = passwordEncoder.encode(user.getSenha());
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(username);
    }
}