package ledgerFlow.controller;
import ledgerFlow.model.dto.request.ClienteCriacaoDTO;
import ledgerFlow.model.dto.response.ClienteRetornoDTO;
import ledgerFlow.service.ClienteService;
import ledgerFlow.model.entity.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Cliente> findClienteById(@PathVariable Long id){
        return clienteService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping({"/clientes"})
    public ResponseEntity<List<Cliente>> getAllClientes(){
        List<Cliente> clientes = clienteService.showAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping({"/{name}"})
    public ResponseEntity<Cliente> findByName(@PathVariable String name){
        return clienteService.findByNome(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cliente")
    public ResponseEntity<ClienteRetornoDTO> save(@RequestBody ClienteCriacaoDTO client){
        ClienteRetornoDTO clienteDto = clienteService.create(client);
        return ResponseEntity.ok(clienteDto);
    }
}