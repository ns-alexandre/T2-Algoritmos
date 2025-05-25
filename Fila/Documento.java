import java.util.Date;

public class Documento {
    private String nomeArquivo;
    private String nomeUsuario;
    private Date horarioSolicitacao;
    private Date horarioImpressao;

    public Documento(String nomeArquivo, String nomeUsuario) {
        this.nomeArquivo = nomeArquivo;
        this.nomeUsuario = nomeUsuario;
        this.horarioSolicitacao = new Date();
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public Date getHorarioSolicitacao() {
        return horarioSolicitacao;
    }

    public void setHorarioImpressao(Date horarioImpressao) {
        this.horarioImpressao = horarioImpressao;
    }

    public Date getHorarioImpressao() {
        return horarioImpressao;
    }

    @Override
    public String toString() {
        return "Arquivo: " + nomeArquivo + " - Usuário: " + nomeUsuario + " - Solicitado em: " + horarioSolicitacao;
    }
}
