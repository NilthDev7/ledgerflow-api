package ledgerFlow.controller;
import ledgerFlow.model.dto.request.InstituicaoCriacaoDTO;
import ledgerFlow.model.dto.response.InstituicaoRetornoDTO;
import ledgerFlow.service.InstituicaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("instituicoes")
public class  InstituicaoController {

    private final InstituicaoService instituicaoService;

    public InstituicaoController(InstituicaoService instituicaoService){
        this.instituicaoService = instituicaoService;
    }

    @GetMapping({"/instituicao"})
    public ResponseEntity<InstituicaoRetornoDTO> ide(@PathVariable String nome){
        return instituicaoService.findByNae(nome)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/instituicao")
    public InstituicaoRetornoDTO cad(@RequestBody InstituicaoCriacaoDTO dto){
        return instituicaoService.cadInstituicao(dto);
    }


}
