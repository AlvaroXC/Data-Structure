public class LinkList {
    private Link first;
    private Link last;
    
    public LinkList() {
        first = null;
        last= null;
    }

    public void lastElement(){
        double current= last.getdData();
        System.out.println(current);
    }


    public void firstElement(){
        double current = first.getdData();
        System.out.println(current);
    }

    public boolean isEmpty() {
        return (first==null);
    }

    public void insertFirst(double dd) { 
        Link newLink = new Link(dd);
        if(isEmpty()==true){
            newLink.setNext(last);
            first=newLink;
            last= newLink;

        }else{
            newLink.setNext(first);
            first= newLink;
        }
    }

    public Link deleteFirst() {
        Link temp=null; 
        if(!isEmpty()){
            temp = first;
            first= first.getNext();
            //first = first.next;
        }
        return temp; 
    }

    //buscar un valor en especifico
    public Link find(double key){
        Link current=first;
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

    //insertar al final
    public void insertLast(double dd){

        Link newLink = new Link(dd);
        Link current=first;

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
    public Link deleteLast(){
        Link temp = null;
        Link current= first;

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

    public void elements(){
        Link current=first;
        int contador=0;
        while(current!=null){
            current= current.getNext();
            contador++;
        }

        System.out.println(contador);
    }

    public double getElementAt(int index){
        Link current= first;
        int contador=0;
        while(current!=null){
            if(contador==index){
                return current.getdData();
            }else{
                contador++;
                current= current.getNext();
            }
        }
        return -1;
    }

    public int findPosition(double value){
        Link current = first;
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

    public void deleteAt(int index){
        Link current = first;

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

        Link temp = current.getNext().getNext();
        current.setNext(temp);
    }

    public void deleteLink(double value){
        int pos = findPosition(value);
        if(pos!= -1){
            deleteAt(pos);
        }
    }




    public void displayList() {
        System.out.print("List (first--> ");
        Link current = first;
        while(current != null) {
            current.displayLink(); 
            current = current.getNext(); 
        }
        System.out.println("<--last)");
    }

}