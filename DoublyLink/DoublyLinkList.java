package DoublyLink;

public class DoublyLinkList<T>{

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
        if(isEmpty()==true){
            newLink.setNext(last);
            first=newLink;
            last= newLink;

        }else{
            first.setPrevious(newLink);
            newLink.setNext(first);//ok
            first= newLink;//ok
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

    public int elements(){
        DoublyLink<T> current=first;
        int contador=0;
        while(current!=null){
            current= current.getNext();
            contador++;
        }

        return contador;
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