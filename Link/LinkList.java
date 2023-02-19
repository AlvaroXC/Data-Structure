public class LinkList<T> {
    private Link<T> first;
    private Link<T> last;
    
    public LinkList() {
        first = null;
        last= null;
    }


    public void lastElement(){
        T current= last.getdData();
        System.out.println(current);
    }


    public void firstElement(){
        T current = first.getdData();
        System.out.println(current);
    }

    public boolean isEmpty() {
        return (first==null);
    }

    public void insertFirst(T dd) { 
        Link<T> newLink = new Link<T>(dd);
        if(isEmpty()==true){
            newLink.setNext(last);
            first=newLink;
            last= newLink;

        }else{
            newLink.setNext(first);
            first= newLink;
        }
    }

    public Link<T> deleteFirst() {
        Link<T> temp=null; 
        if(!isEmpty()){
            temp = first;
            first= first.getNext();
            //first = first.next;
        }
        return temp; 
    }



    //insertar al final
    public void insertLast(T dd){

        Link<T> newLink = new Link<T>(dd);
        Link<T> current=first;

        if(!isEmpty()){
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

        int contador = elements();
        for(int i=0; i<contador; i++){
            deleteFirst();
        }
        System.out.println("Lista vacia");
        
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