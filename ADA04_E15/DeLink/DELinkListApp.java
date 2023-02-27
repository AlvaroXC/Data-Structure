package ADA04_E15.DeLink;

/**
 * La clase DELinkApp ejecuta la lista
 * @author Alvaro Xool
 * @author Paulina Perera
 */
public class DELinkListApp {


    /**
     * @param args
     */
    public static void main(String[] args) {
        DELinkList<Double> lista = new DELinkList<Double>();
        lista.insertFirst(15.5); 
        lista.insertFirst(55.5);
        lista.insertFirst(35.5);
        lista.insertFirst(45.5);
        lista.insertFirst(18.5);
        lista.insertFirst(23.5);
        lista.insertAt(9.2, 3);
        lista.displayList();
        lista.lastElement();
        System.out.println(lista.findPosition(52.3));
        lista.insertFirst(25.3);
        lista.replace(25.3, 2.0);
        lista.displayList();
        lista.replaceWithIndex(26.3, 100);
        lista.displayList();
        lista.deleteAt(-6);
        
    }
}
