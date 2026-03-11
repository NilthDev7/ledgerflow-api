package ledgerFlow.dto;

import java.math.BigDecimal;

public class DepositoDTO {
    private Long idUsuario;
    private BigDecimal valor;
    public DepositoDTO() {}

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }
}