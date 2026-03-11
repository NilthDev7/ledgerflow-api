package ledgerFlow.controller;
import ledgerFlow.dto.ClienteCriacaoDTO;
import ledgerFlow.dto.ClienteRetornoDTO;
import ledgerFlow.service.ClienteService;
import ledgerFlow.entity.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping({"/id/{id}"})
    public ResponseEntity<Cliente> findClienteById(@PathVariable Long id){
        return clienteService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping({"/showAll"})
    public List<Cliente> getAllClientes(){
        return clienteService.showAll();
    }

    @GetMapping({"/name/{name}"})
    public ResponseEntity<Cliente> findByName(@PathVariable String name){
        return clienteService.findByNome(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cadClient")
    public ResponseEntity<ClienteRetornoDTO> save(@RequestBody ClienteCriacaoDTO client){
        ClienteRetornoDTO clienteDto = clienteService.create(client);
        return ResponseEntity.ok(clienteDto);
    }
}
