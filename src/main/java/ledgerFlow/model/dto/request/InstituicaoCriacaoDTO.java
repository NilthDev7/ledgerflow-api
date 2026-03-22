package ledgerFlow.model.dto.request;

public class InstituicaoCriacaoDTO {


    private String instituicaoNome;

    private String cod;

    public InstituicaoCriacaoDTO() {}

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public InstituicaoCriacaoDTO(String instituicaoNome) {
        this.instituicaoNome = instituicaoNome;
    }

    public String getInstituicaoNome() {
        return instituicaoNome;
    }

    public void setInstituicaoNome(String instituicaoNome) {
        this.instituicaoNome = instituicaoNome;
    }
}
