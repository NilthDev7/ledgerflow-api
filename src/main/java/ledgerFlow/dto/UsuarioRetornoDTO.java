package ledgerFlow.dto;

import java.math.BigDecimal;

public class UsuarioRetornoDTO {

    private Long id;
    private String nome;
    private BigDecimal saldo;

    public BigDecimal getSaldo() { return saldo; }
    public void setSaldo(BigDecimal saldo) { this.saldo = saldo; }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
