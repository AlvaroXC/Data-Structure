package DoublyLink;

public class DoublyLinkApp {
    public static void main(String[] args) {
        DoublyLinkList<Double> lista= new DoublyLinkList<Double>();
        
        lista.insertFirst(55.3); //ultimo de la lista
        lista.insertFirst(5.3);
        lista.insertFirst(55.0);
        lista.insertFirst(55.7); //primero de la lista
        lista.insertLast(85.1);
        lista.lastElement();
        lista.firstElement();
        lista.insertFirst(50.25);
        lista.insertLast(1.3);
        lista.lastElement();
        lista.displayList();
        //lista.firstElement();
        lista.deleteLast();
        lista.displayList();
        lista.lastElement();
    }
    
}
