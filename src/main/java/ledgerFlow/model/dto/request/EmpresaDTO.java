package ledgerFlow.model.dto.request;

public class EmpresaDTO{

    private Long id;

    private String nome;

    public EmpresaDTO() {
    }

    public EmpresaDTO(Long id, String nome) {
    }

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
