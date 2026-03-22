package ledgerFlow.controller;
import ledgerFlow.model.dto.request.AuthenticationDTO;
import ledgerFlow.model.dto.response.LoginResponseDTO;
import ledgerFlow.model.dto.request.RegisterUserDTO;
import ledgerFlow.model.entity.Usuario;
import ledgerFlow.infra.security.tokenService;
import ledgerFlow.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    tokenService TokenService;

    private final AuthenticationManager authenticationManager;

    private final UsuarioRepository usuarioRepository;
    public AuthController(AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository){
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthenticationDTO data){
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        var token = TokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated RegisterUserDTO data){
        if(this.usuarioRepository.findByLogin(data.getLogin()) != null) return ResponseEntity.badRequest().build();

        var encriptedPassword = new BCryptPasswordEncoder().encode(data.getSenha());
        Usuario user = new Usuario(data.getLogin(), encriptedPassword, data.getRole(), data.getNome());

        this.usuarioRepository.save(user);
        return ResponseEntity.ok().build();
    }
}
