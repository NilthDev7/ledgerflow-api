package ledgerFlow.model.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fantasia;

    @Column(nullable = false)
    private String inscricaoEstadual;

    @Column(nullable = false)
    private String cnpj;

    public void setId(Long id) {
        this.id = id;
    }

    public Empresa(){};

    public Empresa(String fantasia, String cnpj, String inscricaoEstadual){
        setFantasia(fantasia);
        setCnpj(cnpj);
        setInscricaoEstadual(inscricaoEstadual);
    }


    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return fantasia;
    }

    public void setNome(String nome) {
        this.fantasia = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
