package ledgerFlow.model.dto.response;

public class InstituicaoRetornoDTO {

    private Long id;
    private String instituicaoNome;

    public InstituicaoRetornoDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstituicaoNome() {
        return instituicaoNome;
    }

    public void setInstituicaoNome(String instituicaoNome) {
        this.instituicaoNome = instituicaoNome;
    }
}
