public class LinkListApp {
    

    public static void main(String[] args) {
        LinkList<Double> lista = new LinkList<Double>();

        lista.insertFirst(15.5); // ultimo de la lista
        lista.insertFirst(55.5);
        lista.insertFirst(35.5);
        lista.insertFirst(45.5);
        lista.insertFirst(18.5);
        lista.insertFirst(23.5); //primero de la lista
        lista.replace(23.5,20.2);
        lista.replaceWithIndex(14.5, 5);
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
