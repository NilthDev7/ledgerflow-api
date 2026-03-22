package ledgerFlow.model.entity;
import jakarta.persistence.*;

@Entity
public class Instituicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String instituicaoNome;

    @Column(nullable = false)
    private String cod;

    public Instituicao(){};

    public Instituicao(long id, String instituicaoNome, String cod) {
        this.id = id;
        this.instituicaoNome = instituicaoNome;
        this.cod = cod;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInstituicaoNome() {
        return instituicaoNome;
    }

    public void setInstituicaoNome(String instituicaoNome) {
        this.instituicaoNome = instituicaoNome;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
}

