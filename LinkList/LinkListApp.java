public class LinkListApp {
    

    public static void main(String[] args) {
        LinkList lista = new LinkList();

        lista.insertFirst(15.5); // ultimo de la lista
        lista.insertFirst(55.5);
        lista.insertFirst(35.5);
        lista.insertFirst(45.5);
        lista.insertFirst(18.5);
        lista.insertFirst(23.5); //primero de la lista
        lista.displayList();
        lista.insertLast(16.5);
        lista.insertLast(18.5);
        lista.displayList();
        lista.elements();
        //lista.deleteLast();
        //lista.findDelete(15.5);
        lista.displayList();
        lista.elements();
        
        try{
            Link temp= lista.find(15);
            System.out.println("Value: "+temp.getdData());

        }catch(NullPointerException e){
            System.out.println("No se encontro el elemento");
        }
    }
}