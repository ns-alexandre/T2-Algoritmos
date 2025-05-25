public class Fila<T> {
    private No<T> inicio;
    private No<T> fim;
    private int tamanho;

    public Fila() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void enfileirar(T elemento) {
        No<T> novo = new No<>(elemento);
        if (estaVazia()) {
            inicio = novo;
        } else {
            fim.setProximo(novo);
        }
        fim = novo;
        tamanho++;
    }

    public T desenfileirar() {
        if (estaVazia()) return null;
        T elemento = inicio.getInfo();
        inicio = inicio.getProximo();
        tamanho--;
        if (inicio == null) fim = null;
        return elemento;
    }

    public int getTamanho() {
        return tamanho;
    }

    public No<T> getInicio() {
        return inicio;
    }
}
