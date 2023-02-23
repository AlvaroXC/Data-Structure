package DoublyLink;

public class DoublyLinkList<T extends Comparable<T>>{

    private DoublyLink<T> first;
    private DoublyLink<T> last;
    
    public DoublyLinkList() {
        first = null;
        last= null;
    }

    public void lastElement(){
        System.out.println(last.getdData());
    }


    public void firstElement(){
        System.out.println(first.getdData());
    }
    

    public boolean isEmpty() {
        return (first==null);
    }

    public void insertFirst(T dd) {
        DoublyLink<T> newLink = new DoublyLink<T>(dd);
        if (isEmpty() == true) {
            newLink.setNext(last);
            first = newLink;
            last = newLink;
        } else {
            first.setPrevious(newLink);
            newLink.setNext(first);
            first = newLink;
        }
    }

    public DoublyLink<T> deleteFirst() {
        DoublyLink<T> current=null; 
        if(!isEmpty()){
            current = first;
            first= first.getNext();
            //first = first.next;
        }else{
            System.out.println("La lista está vacia");
        }
        return current; 
    }

    public DoublyLink<T> deleteLast(){

        DoublyLink<T> current= last;

        if(!isEmpty()){
            last= current.getPrevious();
            last.setNext(null);
        }else{
            System.out.println("La lista está vacia");
        }

        return current;
    }

    public void insertInOrderDecrease(T dd){
        DoublyLink<T> newLink = new DoublyLink<T>(dd);
        DoublyLink<T> current= first;
        
        if(isEmpty()){
            insertFirst(dd);
        }else{
            while(current!=null && dd.compareTo(current.getdData())<0){
                current=current.getNext();
            }
            if(current==null){
                insertLast(dd);
            }
            else if(current.getPrevious()==null){
                insertFirst(dd);
            }
            else{
                current.getPrevious().setNext(newLink);
                newLink.setPrevious(current.getPrevious());
                newLink.setNext(current);
                current.setPrevious(newLink);
            }
        }
    
    
    
    
    }


    public void insertInOrderIncrease(T dd) {
        DoublyLink<T> newLink = new DoublyLink<T>(dd);
        DoublyLink<T> current = first;

        while (current != null && dd.compareTo(current.getdData()) >= 0) {
            current = current.getNext();
        }
        if (current == null) {
            insertLast(dd);
        } else if (current.getPrevious() == null) {
            insertFirst(dd);
        } else {
            current.getPrevious().setNext(newLink);
            newLink.setPrevious(current.getPrevious());
            newLink.setNext(current);
            current.setPrevious(newLink);
        }
    }

    public void insertLast(T dd){

        DoublyLink<T> newLink = new DoublyLink<T>(dd);

        if(isEmpty()){
            insertFirst(dd);

        }else{
            last.setNext(newLink);
            newLink.setPrevious(last);
            newLink.setNext(null);
            last=newLink;
        }
    }


    public void deleteAt(int index){
        DoublyLink<T> current = first;

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

        DoublyLink<T> temp = current.getNext().getNext();
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

    public void insertAt(T dd, int index) {
        DoublyLink<T> newLink = new DoublyLink<T>(dd);
        if (isEmpty()) {
            first = newLink;
            last = newLink;
        } else if (index == 0) {
            newLink.setNext(first);
            first.setPrevious(newLink);
            first = newLink;
        } else {
            DoublyLink<T> current = first;
            for (int i = 0; i < index - 1 && current.getNext() != null; i++) {
                current = current.getNext();
            }
            if (current == last) {
                last = newLink;
            }
            newLink.setNext(current.getNext());
            current.getNext().setPrevious(newLink);
            current.setNext(newLink);
            newLink.setPrevious(current);
        }
    }

    public int elements(){
        DoublyLink<T> current=first;
        int contador=0;
        while(current!=null){
            current= current.getNext();
            contador++;
        }

        return contador;
    }

    public T getElementAt(int index){
        DoublyLink<T> current= first;
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

    public DoublyLink<T> find(T key){
        DoublyLink<T> current=first;
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

    public int findPosition(T value){
        DoublyLink<T> current = first;
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

    public void replace(T valueB, T valueA){
        
        if(isEmpty()){
            System.out.println("Lista vacia");
        }else{
            DoublyLink<T> current = first;
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

    public void replaceWithIndex(T value, int index){
        int contador=0;

        if(isEmpty()){
            System.out.println("Lista vacia");

        }else{
            DoublyLink<T> current= first;
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

    public void cleanList(){
        first=null;
        last=null;
        System.out.println("Lista borrada");
    }

    


    public void displayList() {

        if(isEmpty()){
            System.out.println("Lista vacia");
        }
        else{
            
            System.out.print("List (first--> ");
            DoublyLink<T> current = first;
            while(current != null) {
                current.displayLink(); 
                current = current.getNext(); 
            }
            System.out.println("<--last)");
        }
    }
    

    



}