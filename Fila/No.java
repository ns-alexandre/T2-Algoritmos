public class No<T> {
    private T info;
    private No<T> proximo;

    public No(T info) {
        this.info = info;
        this.proximo = null;
    }

    public T getInfo() {
        return info;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }
}
