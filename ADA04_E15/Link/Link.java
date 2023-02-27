
/**
 * La clase DELink crea un nodo
 * @author Alvaro Xool
 * @author Paulina Perera
 */

public class Link<T> {
    private T dData;
    private Link<T> next; 

    /**
     * Constructor del DELink, le asigan su dato al nodo
     * @param dd
     */
    public Link(T dd) {
        dData = dd;
    }

    /**
     * Imprime el dato del nodo
     */
    public void displayLink() {
        System.out.print("{" + dData + "} ");
    }

    /**
     * Obtiene el dato de un nodo
     * @return T
     */
    public T getdData() {
        return dData;
    }

    /**
     * Obtiene la referencia del siguiente nodo
     * @return DELink<T>
     */
    public Link<T> getNext() {
        return next;
    }

    /**
     * Establece la referencia al nodo siguiente
     * @param next
     */
    public void setNext(Link<T> next) {
        this.next = next;
    }
    
    /**
     * Establece el dato de un nodo
     * @param dData
     */
    public void setdData(T dData) {
        this.dData = dData;
    }
}