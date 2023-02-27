package ADA04_E15.DoublyLink;

/**
 * La clase DoublyLinkApp ejecuta la lista
 * @author Alvaro Xool
 * @author Paulina Perera
 */

public class DoublyLinkApp {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        DoublyLinkList<Double> lista= new DoublyLinkList<Double>();
        lista.insertFirst(55.3); //ultimo de la lista
        lista.insertFirst(5.3);
        lista.insertFirst(55.0);
        lista.insertFirst(55.7); //primero de la lista
       lista.displayList();
        lista.insertLast(85.1);
        lista.lastElement();
        lista.firstElement();
        lista.insertFirst(50.25);
        lista.insertLast(1.3);
        lista.lastElement();
        lista.displayList();
        lista.firstElement();
        lista.deleteLast();
        lista.displayList();
        lista.lastElement();
        lista.insertFirst(1.3);
        lista.insertFirst(54.2);
        lista.displayList();
        lista.insertFirst(53.3);
        lista.displayList();
        lista.insertInOrderIncrease(55.8);
        lista.displayList();
        lista.insertInOrderIncrease(55.7);
        lista.displayList();
        lista.insertInOrderIncrease(55.9);
        lista.displayList();
        lista.insertInOrderDecrease(0.2);
        lista.displayList();
        lista.insertAt(66.3, -10);
        lista.displayList();
        lista.replaceWithIndex(4000.2, -12);
    }
    
}
