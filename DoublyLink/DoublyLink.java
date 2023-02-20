package DoublyLink;

public class DoublyLink<T> {

    private T dData;
    private DoublyLink<T> next;
    private DoublyLink<T> previous;

    public DoublyLink(T dd) {
        dData = dd;
    }

    public T getdData() {
        return dData;
    }

    public DoublyLink<T> getPrevious(){
        return previous;
    }
    
    public void setPrevious(DoublyLink<T> previous) {
        this.previous = previous;
    }
    
    public DoublyLink<T> getNext() {
        return next;
    }
    
    public void setNext(DoublyLink<T> next) {
        this.next = next;
    }
    
    public void setdData(T dData) {
        this.dData = dData;
    }

    public void displayLink() {
        System.out.print("{" + dData + "} ");
    }
}
