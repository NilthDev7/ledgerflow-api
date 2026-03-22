package ledgerFlow.controller;
import ledgerFlow.model.dto.request.UsuarioCriacaoDTO;
import ledgerFlow.model.dto.response.UsuarioRetornoDTO;
import ledgerFlow.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping({"/id/{id}"})
    public ResponseEntity<UsuarioRetornoDTO> getUserById(@PathVariable Long id) {
        return usuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioRetornoDTO>> allUsers() {
        List<UsuarioRetornoDTO> users = usuarioService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<UsuarioRetornoDTO> userByName(@PathVariable String nome) {
        return usuarioService.findByNome(nome)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioRetornoDTO> createNewUser(@RequestBody UsuarioCriacaoDTO dto) {
        UsuarioRetornoDTO usuarioRetornoDTO = usuarioService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRetornoDTO);
    }
}



