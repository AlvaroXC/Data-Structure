public class LinkListApp {
    

    public static void main(String[] args) {
        LinkList<String> lista = new LinkList<String>();
        lista.insertFirst("Hola");
        lista.insertFirst("Que tal");
        /* 
        lista.insertFirst(15.5); // ultimo de la lista
        lista.insertFirst(55.5);
        lista.insertFirst(35.5);
        lista.insertFirst(45.5);
        lista.insertFirst(18.5);
        lista.insertFirst(23.5); //primero de la lista
        lista.insertAt(9.2, 3);
        lista.displayList();
        lista.lastElement();*/
        lista.insertInOrderIncrease("No");
        lista.displayList();
        /*
        
        try{
            Link temp= lista.find(15);
            System.out.println("Value: "+temp.getdData());

        }catch(NullPointerException e){
            System.out.println("No se encontro el elemento");
        }*/
    }
}
