package ADA04_E15.DoublyLink;

/**
 * DpublyLinkList crea una lista doblemente ligada y contiene metodos para manipularla
 * Extiende de la interfaz Comparable
 * 
 * @param <T> tipo de elementos que se almacena a la lista 
 * 
 * @author Alvaro Xool
 * @author Paulina Perera
 */
public class DoublyLinkList<T extends Comparable<T>>{

    private DoublyLink<T> first;
    private DoublyLink<T> last;
    
    /**
     * Constructor de la clase DoublyLinkList con apuntadores al primer y ultimo elemento
     */
    public DoublyLinkList() {
        first = null;
        last= null;
    }

    /**
     * Muestra el ultimo elemento de la lista
     * Si esta vacia la lista manda un mensaje
    */   
    public void lastElement(){
        if(isEmpty()){
            System.out.println("La lista está vacia");
        }
        else{

            System.out.println(last.getdData());
        }
    }

    /**
     * Muestra el primer elemento de la lista
     * Si esta vacia la lista manda un mensaje
    */
    public void firstElement(){
        if(isEmpty()){
            System.out.println("La lista está vacia");
        }
        else{

            System.out.println(first.getdData());
        }
    }
    
    /**
     * Verifica si la lista esta vacia
     * @return boolean
    */
    public boolean isEmpty() {
        return (first==null);
    }

    /**
     * Inserta un elemento al principio de la lista
     * @param dd
     * 
    */    
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

    /**
     * Elimina el primer elemento de la lista
     * @return DELink<T>
    */
    public DoublyLink<T> deleteFirst() {
        DoublyLink<T> current=null; 
        if(!isEmpty()){
            current = first;
            first= first.getNext();
        }else{
            System.out.println("La lista está vacia");
        }
        return current; 
    }

    /**
     * Elimina el ultimo elemento de la lista
     * @return DELink<T>
     */ 
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

    /**
     * Inserta un elemento en orden descendente
     * El primer dato que encuentre que sea mayor a dd, dd se insertara despues
     * Si la lista esta vacia o si la referencia al anterior es igual a null se inserta como el primero
     * 
     * @param dd
     * 
    */
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


    /**
     * Inserta un elemento en orden ascendente
     * El primer dato que encuentre que sea menor a dd, se insertara despues
     *Si la lista esta vacia o si la referencia al anterior es igual a null se inserta como el primero
     * @param dd
     */
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

    /**
     * Inserta un elemento al final de la lista
     * Si esta vacia la lista se inserta como primer elemento
     * @param dd
     */
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

    /**
     * Inserta un elemento en un index especifico
     * Si no existe el index en la lista, manda un mensaje
     * @param dd
     * @param index
     * 
    */
    public void insertAt(T dd, int index) {
        //int elements= elements();
        DoublyLink<T> newLink = new DoublyLink<T>(dd);
        if (isEmpty()) {
            first = newLink;
            last = newLink;
        }else if(index<0 || index>elements()){
            System.out.println("Index no valido");
        }
        else if (index == 0) {
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

    /**
     * Cuenta los elementos que hay en la lista
     * @return int
    */

    public int elements(){
        DoublyLink<T> current=first;
        int contador=0;
        while(current!=null){
            current= current.getNext();
            contador++;
        }

        return contador;
    }

    /**
     * Busca un elemento especifico en la lista
     * @return T
     * @throws NotFound
    */
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

    /** 
     * Encuentra el elemento de la lista
     * @return DELink<T>
     * @throws NullPointerException
    */
    public DoublyLink<T> find(T key){
        DoublyLink<T> current=first;

        try{
            while(current.getdData()!= key){
                if(current.getNext()==null){
                    return null;
                }
                else{
                    current= current.getNext();
                }
            }
        }catch(NullPointerException e){
            System.out.println("No se encontró el elemento");
        }
        return current;

    }

   /**
     * Busca un nodo en la lista y devuelve su posicion
     * Si no existe el valor devuelve -1
     * @param value
     * @return int
    */
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

    /**
     *Reemplaza el dato de un nodo, lo busca por su valor
     *@param valueB dato del nodo que se va reemplazar
     *@param valueA dato por el cual se cambia valueB 
    */
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
            if(current==null){
                System.out.println("El dato no se encuentra en la lista");
            }
        }
    }

    /**
     * Reemplaza el dato de un nodo, lo busca por su posicion
     * @param value
     * @param index
    */
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
            if(current==null){
                System.out.println("Index no existente");
            }
        }
    }
    /**
     * Elimina los nodos de la lista
    */
    public void cleanList(){
        first=null;
        last=null;
        System.out.println("Lista borrada");
    }

    /**
     * Imprimer los datos de la lista
     */

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