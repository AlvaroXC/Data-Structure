package DoublyLink;

public class DoubleLink<T> {

    private T dData;
    private DoubleLink<T> next;
    private DoubleLink<T> previous;

    public DoubleLink(T dd) {
        dData = dd;
    }

    public T getdData() {
        return dData;
    }

    public DoubleLink<T> getPrevious(){
        return previous;
    }
    
    public void setPrevious(DoubleLink<T> previous) {
        this.previous = previous;
    }
    
    public DoubleLink<T> getNext() {
        return next;
    }
    
    public void setNext(DoubleLink<T> next) {
        this.next = next;
    }
    
    public void setdData(T dData) {
        this.dData = dData;
    }

    public void displayLink() {
        System.out.print("{" + dData + "} ");
    }
}
