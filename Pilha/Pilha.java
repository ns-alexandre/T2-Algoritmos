public class Pilha<T> {
    private No<T> topo;
    private int tamanho;
    private int capacidadeMaxima;

    public Pilha(int capacidadeMaxima) {
        this.topo = null;
        this.tamanho = 0;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public boolean estaCheia() {
        return tamanho >= capacidadeMaxima;
    }

    public boolean push(T elemento) {
        if (estaCheia()) return false;
        No<T> novo = new No<>(elemento);
        novo.setProximo(topo);
        topo = novo;
        tamanho++;
        return true;
    }

    public T pop() {
        if (estaVazia()) return null;
        T elemento = topo.getInfo();
        topo = topo.getProximo();
        tamanho--;
        return elemento;
    }

    public int getTamanho() {
        return tamanho;
    }

    public No<T> getTopo() {
        return topo;
    }

    public String consultarDocumento(String nomeArquivo) {
        No<T> atual = topo;
        int posicao = tamanho;
        while (atual != null) {
            Documento doc = (Documento) atual.getInfo();
            if (doc.getNomeArquivo().equals(nomeArquivo)) {
                return "Arquivo encontrado na posição " + posicao + ", solicitado em: " + doc.getHorarioSolicitacao();
            }
            atual = atual.getProximo();
            posicao--;
        }
        return "Documento não encontrado na pilha.";
    }

    @Override
    public String toString() {
        if (estaVazia()) return "Pilha vazia.";
        StringBuilder sb = new StringBuilder();
        No<T> atual = topo;
        int posicao = tamanho;
        while (atual != null) {
            sb.append("Posição ").append(posicao).append(": ").append(atual.getInfo()).append("\n");
            atual = atual.getProximo();
            posicao--;
        }
        return sb.toString();
    }
}
