package ledgerFlow.controller;
import ledgerFlow.dto.UsuarioCriacaoDTO;
import ledgerFlow.dto.UsuarioRetornoDTO;
import ledgerFlow.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping({"/id/{id}"})
    public ResponseEntity<UsuarioRetornoDTO> getUserById(@PathVariable Long id){
        return usuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioRetornoDTO>> allUsers(){
        List<UsuarioRetornoDTO> users = usuarioService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<UsuarioRetornoDTO> userByName(@PathVariable String nome) {
        return usuarioService.findByNome(nome)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cadUser")
    public ResponseEntity<UsuarioRetornoDTO> createNewUser(@RequestBody UsuarioCriacaoDTO dto){
        UsuarioRetornoDTO usuarioRetornoDTO = usuarioService.create(dto);
        return ResponseEntity.ok(usuarioRetornoDTO);
    }
}



