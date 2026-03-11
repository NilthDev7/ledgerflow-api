package ledgerFlow.controller;
import ledgerFlow.dto.EmpresaDTO;
import ledgerFlow.service.EmpresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    EmpresaController(EmpresaService empresaService){
        this.empresaService = empresaService;
    }

    @GetMapping({"/id/{id}"})
    public ResponseEntity<EmpresaDTO> getById(@PathVariable Long id){
    return empresaService.getById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping({"/name/{nome}"})
    public ResponseEntity<EmpresaDTO> getByNome(@PathVariable String nome){
        return empresaService.getByName(nome)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
