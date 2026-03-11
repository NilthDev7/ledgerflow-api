package ledgerFlow.dto;

import java.math.BigDecimal;

public class TransactionDTO {
    private Long emitente_id;
    private Long remetente_id;
    private BigDecimal valor;


    public Long getEmitente_id() { return emitente_id; }
    public void setEmitente_id(Long emitente_id) { this.emitente_id = emitente_id; }

    public Long getRemetente_id() { return remetente_id; }
    public void setRemetente_id(Long remetente_id) { this.remetente_id = remetente_id; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }
}