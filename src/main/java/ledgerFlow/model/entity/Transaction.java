package ledgerFlow.model.entity;
import ledgerFlow.model.enums.StatusTransacao;
import ledgerFlow.model.enums.TipoTransacao;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transacoes")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "id_usuario_origem")
    private Usuario emitente;

    @ManyToOne
    @JoinColumn(name = "id_usuario_destino")
    private Usuario remetente;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipo;

    @Enumerated(EnumType.STRING)
    private StatusTransacao status;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime dataTransacao;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Usuario getEmitente() {
        return emitente;
    }

    public void setEmitente(Usuario emitente) {
        this.emitente = emitente;
    }

    public Usuario getRemetente() {
        return remetente;
    }

    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public StatusTransacao getStatus() {
        return status;
    }

    public void setStatus(StatusTransacao status) {
        this.status = status;
    }

    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDateTime dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    @PrePersist
    public void prePersist(){
        this.dataTransacao = LocalDateTime.now();
    }

}
