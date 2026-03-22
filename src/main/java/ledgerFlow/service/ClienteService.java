package ledgerFlow.service;
import ledgerFlow.model.dto.request.ClienteCriacaoDTO;
import ledgerFlow.model.dto.response.ClienteRetornoDTO;
import ledgerFlow.mapper.ClienteMapper;
import ledgerFlow.repository.ClienteRepository;
import ledgerFlow.model.entity.Cliente;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public Optional<Cliente> findByNome(String nome){
        return clienteRepository.findByNome(nome);
    }

    public Optional<Cliente> findByCpf(String cpf){
        return clienteRepository.findByCpf(cpf);
    }

    public List<Cliente> showAll(){
        return clienteRepository.findAll();
    }

    public ClienteRetornoDTO create(ClienteCriacaoDTO dto){
        Cliente cliente = ClienteMapper.toEntity(dto);

        Cliente saved = clienteRepository.save(cliente);
        return ClienteMapper.convertToDto(saved);
    }

    public Optional<Cliente> findById(Long id){
        return clienteRepository.findById(id);
    }
}
