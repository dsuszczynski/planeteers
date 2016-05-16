package pl.suszczynski.planeteers.data;

/**
 * Created by daniel on 16.05.16.
 */
public abstract class DataBuilder<T> {

    protected T data;

    protected DataBuilder() {
        this.data = createData();
    }

    protected abstract T createData();

    public T build() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
