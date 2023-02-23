
public class LinkList<T extends Comparable<T>> {
    private Link<T> first;
    
    public LinkList() {
        first = null;
    }

    public void insertInOrderIncrease(T dd) {
        
        if (isEmpty()) {
            insertFirst(dd);
        } else {

            Link<T> newLink = new Link<T>(dd);
            Link<T> previous = null;
            Link<T> current = first;
            while (current != null && dd.compareTo(current.getdData()) > 0) {
                previous = current;
                current = current.getNext();
            }
            if (previous == null) {
                newLink.setNext(first);
                first = newLink;
            } else {
                previous.setNext(newLink);
                newLink.setNext(current);
            }
        }
    }

    public void insertInOrderDecrease(T dd){

        
        if(isEmpty()){
            insertFirst(dd);
        }
        else if(dd.compareTo(first.getdData())>0){
            insertFirst(dd);
        }else{

            Link<T> current = first;
            Link<T> previos = null;
            Link<T> newLink = new Link<T>(dd);
            while(current!=null && dd.compareTo(current.getdData())<0){
                previos=current;
                current=current.getNext();
            }
            previos.setNext(newLink);
            newLink.setNext(current);
        }

    }

    public void lastElement() {
        if(isEmpty()){
            System.out.println("La lista está vacía");
        }else{
            Link<T> current = first;
            while(current.getNext() != null){
                current = current.getNext();
            }
            System.out.println(current.getdData());
        }
    }


    public void firstElement(){
        if(isEmpty()){
            System.out.println("La lista está vacia");
        }else{

            T current = first.getdData();
            System.out.println(current);
        }
    }

    public boolean isEmpty() {
        return (first==null);
    }

    public void insertFirst(T dd) { 
        Link<T> newLink = new Link<T>(dd);
        if(isEmpty()==true){
            newLink.setNext(first);
            first=newLink;
        }else{
            newLink.setNext(first);
            first= newLink;
        }
    }

    public Link<T> deleteFirst() {
        Link<T> current=null; 
        if(!isEmpty()){
            current = first;
            first= first.getNext();
        }
        return current; 
    }



    //insertar al final
    public void insertLast(T dd){

        Link<T> newLink = new Link<T>(dd);
        Link<T> current=first;

        if(isEmpty()){
            insertFirst(dd);

        }else{
            
            while(current!=null){

                if(current.getNext()==null){
                    newLink.setNext(null);
                    current.setNext(newLink);
                }else{
                    current.setNext(current.getNext());
                }
            }
        }
    }
    
    //eliminar al final
    public Link<T> deleteLast(){
        Link<T> temp = null;
        Link<T> current= first;

        while(current!=null){
            if(current.getNext().getNext()==null){
                temp = current.getNext();
                current.setNext(null);
            }
            else{
                current= current.getNext();
            }
        }

        return temp;
    }

    public void insertAt(T dd, int index) {
        Link<T> newLink = new Link<T>(dd);
        if (index == 0) {
            insertFirst(dd);
        } else {
            Link<T> current = first;
            for (int i = 0; i < index - 1; i++) {
                if (current == null) {
                    System.out.println("Index out of bounds");
                    return;
                }
                current = current.getNext();
            }
            newLink.setNext(current.getNext());
            current.setNext(newLink);
        }
    }

    public int elements(){
        Link<T> current=first;
        int contador=0;
        while(current!=null){
            current= current.getNext();
            contador++;
        }

        return contador;
    }

    public T getElementAt(int index){
        Link<T> current= first;
        int contador=0;
        while(current!=null){
            if(contador==index){
                return current.getdData();
            }else{
                contador++;
                current= current.getNext();
            }
        }
        throw new NotFound("No se encontro el elemento");
    }

    
    public void replaceWithIndex(T value, int index){
        int contador=0;

        if(isEmpty()){
            System.out.println("Lista vacia");

        }else{
            Link<T> current= first;
            while(current!= null){
                
                if(contador==index){
                    current.setdData(value);
                    break;
                }else{
                    current= current.getNext();
                    contador++;
                }
            }
        }
    }

    public void replace(T valueB, T valueA){
        
        if(isEmpty()){
            System.out.println("Lista vacia");
        }else{
            Link<T> current = first;
            while(current!=null){
                if(current.getdData().equals(valueB)){
                    current.setdData(valueA);
                    break;
                }else{
                    current=current.getNext();
                }
            }
        }
    }

    //buscar un valor de tipo double(numero)
    public Link<T> find(T key){
        Link<T> current=first;
            while(current.getdData()!= key){
                if(current.getNext()==null){
                    return null;
                }
                else{
                    current= current.getNext();
                }
            }

        return current;

    }



    //busca la posicion de ese elemento
    public int findPosition(T value){
        Link<T> current = first;
        int contador=0;

        if(isEmpty()){
            return -1;
        }
        else{
            while(current!=null){
                if(value==current.getdData()){
                    return contador;
                }else{
                    current=current.getNext();
                    contador++;
                }
            }
        }


        return contador;
    }

    //recibe la posicion del elemento
    public void deleteAt(int index){
        Link<T> current = first;

        if(isEmpty())
            return;
        if(index==0){
            first= current.getNext();
            return;
        }


        for(int i=0; current!= null && i<index-1; i++){
            current = current.getNext();

        }

        if(current==null || current.getNext()==null){
            return;
        }

        Link<T> temp = current.getNext().getNext();
        current.setNext(temp);
    }




    /*
    recibe un valor de tipo double, manda a buscar la posicion de ese valor
    y despues lo manda a eliminar
    */
    public void deleteLink(T value){
        int pos = findPosition(value);
        if(pos!= -1){
            deleteAt(pos);
        }
    }

    public void cleanList(){
        first=null;
    }



    public void displayList() {
        System.out.print("List (first--> ");
        Link<T> current = first;
        while(current != null) {
            current.displayLink(); 
            current = current.getNext(); 
        }
        System.out.println("<--last)");
    }

}