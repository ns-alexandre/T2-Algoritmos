import java.util.Date;

public class Impressora {
    private Fila<Documento> fila;
    private int capacidade;
    private int ocupacao;

    public Impressora(int capacidade) {
        this.capacidade = capacidade;
        fila = new Fila<>();
        ocupacao = 0;
    }

    public boolean estaVazia() {
        return fila.estaVazia();
    }

    public boolean estaCheia() {
        return ocupacao >= capacidade;
    }

    public boolean adicionarDocumento(String nomeArquivo, String nomeUsuario) {
        if (estaCheia()) return false;
        Documento doc = new Documento(nomeArquivo, nomeUsuario);
        fila.enfileirar(doc);
        ocupacao++;
        return true;
    }

    public Documento imprimirDocumento() {
        if (estaVazia()) return null;
        Documento doc = fila.desenfileirar();
        doc.setHorarioImpressao(new Date());
        ocupacao--;
        return doc;
    }

    public String consultarDocumento(String nomeArquivo) {
        if (estaVazia()) return "Fila vazia.";
        No<Documento> atual = fila.getInicio();
        int pos = 1;
        while (atual != null) {
            Documento doc = atual.getInfo();
            if (doc.getNomeArquivo().equals(nomeArquivo)) {
                return "Arquivo encontrado na posição " + pos + ", solicitado em: " + doc.getHorarioSolicitacao();
            }
            atual = atual.getProximo();
            pos++;
        }
        return "Documento não encontrado.";
    }

    @Override
    public String toString() {
        if (estaVazia()) return "Fila vazia.";
        StringBuilder sb = new StringBuilder();
        No<Documento> atual = fila.getInicio();
        int pos = 1;
        while (atual != null) {
            sb.append("Posição ").append(pos).append(": ").append(atual.getInfo()).append("\n");
            atual = atual.getProximo();
            pos++;
        }
        return sb.toString();
    }
}
