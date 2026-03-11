package ledgerFlow.controller;

import ledgerFlow.dto.DepositoDTO;
import ledgerFlow.dto.TransactionDTO;
import ledgerFlow.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping("/transacao")
    public ResponseEntity<?> criarTransacao(@RequestBody TransactionDTO transaction){
        try {
            transactionService.transferenciaBancaria(transaction);
            return ResponseEntity.status(201).build();
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/deposito")
    public void depositar(@RequestBody DepositoDTO dto) throws Exception {
        transactionService.deposito(dto);
    }
}