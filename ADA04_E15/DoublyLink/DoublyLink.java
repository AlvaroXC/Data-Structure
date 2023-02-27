package ADA04_E15.DoublyLink;

/**
 * La clase DoublyLink crea un nodo
 * 
 * @author Alvaro Xool
 * @author Paulina Perera
 */
public class DoublyLink<T> {

    private T dData;
    private DoublyLink<T> next;
    private DoublyLink<T> previous;

    /**
     * Constructor de la clase DoublyLink, se crea el nodo con su valor
     * @param dd
     */
    public DoublyLink(T dd) {
        dData = dd;
    }

 
    /**
     * Obtiene el dato de un nodo
     * 
     * @return T
     */   
    public T getdData() {
        return dData;
    }


    /**
     * Obtiene la referencia hacia el nodo anterior
     * @return DoublyLink<T>
     */
    public DoublyLink<T> getPrevious(){
        return previous;
    }
    
    /**
     * Establece la referencia al nodo anterior
     * @param previous
     */
    public void setPrevious(DoublyLink<T> previous) {
        this.previous = previous;
    }

    /**
     * Obtiene la referencia al nodo siguiente
     * @return DoublyLink<T>
     */
    public DoublyLink<T> getNext() {
        return next;
    }
    
    /**
     * Establece la referencia al nodo siguiente
     * @param next
     */
    public void setNext(DoublyLink<T> next) {
        this.next = next;
    }
    
    /**
     * Establece el dato del nodo
     * @param dData
     */
    public void setdData(T dData) {
        this.dData = dData;
    }

    /**
     * Imprime el dato del nodo
     */
    public void displayLink() {
        System.out.print("{" + dData + "} ");
    }
}
