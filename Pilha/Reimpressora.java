import java.util.Date;

public class Reimpressora {
    private Pilha<Documento> pilhaReimpressao;

    public Reimpressora(int capacidadePilha) {
        pilhaReimpressao = new Pilha<>(capacidadePilha);
    }

    public boolean solicitarReimpressao(String nomeArquivo, String nomeUsuario) {
        Documento doc = new Documento(nomeArquivo, nomeUsuario);
        return pilhaReimpressao.push(doc);
    }

    public Documento executarReimpressao() {
        Documento doc = pilhaReimpressao.pop();
        if (doc != null) {
            doc.setHorarioImpressao(new Date());
        }
        return doc;
    }

    public String consultarDocumento(String nomeArquivo) {
        return pilhaReimpressao.consultarDocumento(nomeArquivo);
    }

    public String mostrarPilha() {
        return pilhaReimpressao.toString();
    }
}
