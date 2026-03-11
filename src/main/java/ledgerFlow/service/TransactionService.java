package ledgerFlow.service;

import ledgerFlow.dto.DepositoDTO;
import ledgerFlow.dto.TransactionDTO;
import ledgerFlow.entity.Transaction;
import ledgerFlow.entity.Usuario;
import ledgerFlow.enums.StatusTransacao;
import ledgerFlow.enums.TipoTransacao;
import ledgerFlow.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import ledgerFlow.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    private final UsuarioService usuarioService;
    private final TransactionRepository transactionRepository;
    private final UsuarioRepository usuarioRepository;

    TransactionService(TransactionRepository transactionRepository, UsuarioService usuarioService, UsuarioRepository usuarioRepository){
        this.transactionRepository = transactionRepository;
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public void transferenciaBancaria(TransactionDTO transaction) throws Exception{
        Usuario emitente = usuarioService.findUserById(transaction.getEmitente_id());
        Usuario remetente = usuarioService.findUserById(transaction.getRemetente_id());

        usuarioService.validarTransacao(emitente, transaction.getValor());

        Transaction novaTransacao = new Transaction();
        novaTransacao.setValor(transaction.getValor());
        novaTransacao.setEmitente(emitente);
        novaTransacao.setRemetente(remetente);
        novaTransacao.setDataTransacao(LocalDateTime.now());
        novaTransacao.setTipo(TipoTransacao.TRANSFERENCIA);
        novaTransacao.setStatus(StatusTransacao.FINALIZADA);

        emitente.setSaldo(emitente.getSaldo().subtract(transaction.getValor()));
        remetente.setSaldo(remetente.getSaldo().add(transaction.getValor()));

        transactionRepository.save(novaTransacao);
    }

    public void deposito(DepositoDTO deposito) throws Exception{

        Usuario user = usuarioRepository.findUserById(deposito.getIdUsuario());

        if(user == null){
            throw new Exception("Usuário não encontrado");
        }

        BigDecimal saldoAtual = user.getSaldo() == null ? BigDecimal.ZERO : user.getSaldo();
        user.setSaldo(saldoAtual.add(deposito.getValor()));

        usuarioRepository.save(user);
    }
}
