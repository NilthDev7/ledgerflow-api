package ledgerFlow.mapper;

import ledgerFlow.dto.ClienteCriacaoDTO;
import ledgerFlow.dto.ClienteRetornoDTO;
import ledgerFlow.entity.Cliente;


public class ClienteMapper {

    public static ClienteRetornoDTO convertToDto(Cliente cliente) {
        ClienteRetornoDTO use = new ClienteRetornoDTO();
        use.setId(cliente.getId());
        use.setNome(cliente.getNome());
        return use;
    }

    public static Cliente toEntity(ClienteCriacaoDTO client){
        if(client == null) return null;

        Cliente cliente = new Cliente();
        cliente.setNome(client.getNome());
        cliente.setCpf(client.getCpf());
        return cliente;
    }
}
