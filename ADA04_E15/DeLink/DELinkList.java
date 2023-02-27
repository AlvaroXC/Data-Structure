package ADA04_E15.DeLink;

/**
 * DELinkList crea una lista ligada y contiene metodos para manipularla
 * Extiende de la interfaz Comparable
 * 
 * @param <T> tipo de elementos que se almacena a la lista 
 * 
 * @author Alvaro Xool
 * @author Paulina Perera
 */

public class DELinkList<T extends Comparable<T>> {

    private DELink<T> first;
    private DELink<T> last;

    /**
     *Contructor de la clase DELinkList con apuntadores al primer y ultimo elemento
    */

    public DELinkList() {
        first = null;
        last = null;
    }

    /**
     * Muestra el ultimo elemento de la lista
     * Si esta vacia la lista manda un mensaje
    */

    public void lastElement() {
        if(!isEmpty()){

            System.out.println(last.getdData());
        }
        else{
            System.out.println("La lista está vacia");
        }
    }

    /**
     * Muestra el primer elemento de la lista
     * Si esta vacia la lista manda un mensaje
    */
    public void firstElement() {
        if(!isEmpty()){

            System.out.println(first.getdData());
        }else{
            System.out.println("La lista está vacia");
        }
    }
    
    /**
     * Verifica si la lista esta vacia
     * @return boolean
    */
    public boolean isEmpty() {
        return (first == null);
    }

    /**
     * Inserta un elemento al principio de la lista
     * @param dd
     * 
    */
    public void insertFirst(T dd) {
        DELink<T> newLink = new DELink<T>(dd);
        if (isEmpty() == true) {
            newLink.setNext(last);
            first = newLink;
            last = newLink;

        } else {
            newLink.setNext(first);
            first = newLink;
        }
    }

    /**
     * Elimina el primer elemento de la lista
     * @return DELink<T>
    */
    public DELink<T> deleteFirst() {
        DELink<T> current = null;
        if (!isEmpty()) {
            current = first;
            first = first.getNext();
        }
        else{
            System.out.println("La lista está vacia");
        }
        return current;
    }


    /**
     * Inserta un elemento al final de la lista
     * Si esta vacia la lista se inserta como primer elemento
     * @param dd
     */
    public void insertLast(T dd) {

        DELink<T> newLink = new DELink<T>(dd);
        DELink<T> current = last;

        if (isEmpty()) {
            insertFirst(dd);

        } else {
            newLink.setNext(null);
            current.setNext(newLink);
        }
    }

    /**
     * Elimina el ultimo elemento de la lista
     * @return DELink<T>
     */
    public DELink<T> deleteLast() {
        DELink<T> temp = null;
        DELink<T> current = first;

        if(isEmpty()){
            System.out.println("La lista está vacia");

        }else{

            while (current != null) {
                if (current.getNext().getNext() == null) {
                    temp = current.getNext();
                    current.setNext(null);
                } else {
                    current = current.getNext();
                }
            }
        }

        return temp;
    }

    /**
     * Inserta un elemento en orden ascendente
     * El primer dato que encuentre que sea menor a dd, se insertara despues
     * Si la lista esta vacia se inserta como el primero
     * @param dd
     */
    public void insertInOrderIncrease(T dd) {

        if (isEmpty()) {
            insertFirst(dd);
        } else {

            DELink<T> newLink = new DELink<T>(dd);
            DELink<T> previous = null;
            DELink<T> current = first;
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

    /**
     * Inserta un elemento en orden descendente
     * El primer dato que encuentre que sea mayor a dd, dd se insertara despues
     * Si la lista esta vacia se inserta como el primero
     * @param dd
     * 
    */
    public void insertInOrderDecrease(T dd) {

        if (isEmpty()) {
            insertFirst(dd);
        } else if (dd.compareTo(first.getdData()) > 0) {
            insertFirst(dd);
        } else {

            DELink<T> current = first;
            DELink<T> previos = null;
            DELink<T> newLink = new DELink<T>(dd);

            while (current != null && dd.compareTo(current.getdData()) < 0) {
                previos = current;
                current = current.getNext();
            }
            previos.setNext(newLink);
            newLink.setNext(current);
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
        DELink<T> newLink = new DELink<T>(dd);
        if (index == 0) {
            insertFirst(dd);
        }else if(index<0 || index>elements()){
            System.out.println("Index no valido");
        }
         else {
            DELink<T> current = first;
            for (int i = 0; i < index - 1; i++) {
                if (current == null) {
                    System.out.println("Index no valido");
                    return;
                }
                current = current.getNext();
            }
            newLink.setNext(current.getNext());
            current.setNext(newLink);
        }
    }
    /**
     * Cuenta los elementos que hay en la lista
     * @return int
    */
    public int elements() {
        DELink<T> current = first;
        int contador = 0;
        while (current != null) {
            current = current.getNext();
            contador++;
        }

        return contador;
    }


    /**
     * Busca un elemento especifico en la lista
     * @return T
    */
    public T getElementAt(int index) {
        DELink<T> current = first;
        int contador = 0;
        while (current != null) {
            if (contador == index) {
                return current.getdData();
            } else {
                contador++;
                current = current.getNext();
            }
        }
        throw new NotFound("No se encontro el elemento");
    }

    /**
     * Reemplaza el dato de un nodo, lo busca por su posicion
     * @param value
     * @param index
    */
    public void replaceWithIndex(T value, int index) {
        int contador = 0;

        if (isEmpty()) {
            System.out.println("Lista vacia");

        }else if(index<0 || index>elements()){
            System.out.println("Index no valido");
        }
        else {
            DELink<T> current = first;
            while (current != null) {

                if (contador == index) {
                    current.setdData(value);
                    break;
                } else {
                    current = current.getNext();
                    contador++;
                }
            }
        }
    }

    /**
     *Reemplaza el dato de un nodo, lo busca por su valor
     *@param valueB dato del nodo que se va reemplazar
     *@param valueA dato por el cual se cambia valueB 
    */
    public void replace(T valueB, T valueA) {

        if (isEmpty()) {
            System.out.println("Lista vacia");
        } else {
            DELink<T> current = first;
            while (current != null) {
                if (current.getdData().equals(valueB)) {
                    current.setdData(valueA);
                    break;
                } else {
                    current = current.getNext();
                }
            }
        }
    }

    /** 
     * Encuentra el elemento de la lista
     * @return DELink<T>
    */
    public DELink<T> find(T key) {
        DELink<T> current = first;
        try{

            while (current.getdData() != key) {
                if (current.getNext() == null) {
                    return null;
                } else {
                    current = current.getNext();
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
     * @return contador
    */
    public int findPosition(T value) {
        DELink<T> current = first;
        int contador = 0;

        if (isEmpty()) {
            return -1;
        } else {
            while (current != null) {
                if (value == current.getdData()) {
                    return contador;
                } else {
                    current = current.getNext();
                    contador++;
                }
            }
        }

        return contador;
    }

    /**
     * Elimina el elemento que se encuentra en una posicion especifica
     * @param index
    */
    public void deleteAt(int index) {
        DELink<T> current = first;

        if (isEmpty())
            return;
        if (index == 0) {
            first = current.getNext();
            return;
        }

        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.getNext();

        }

        if (current == null || current.getNext() == null) {
            System.out.println("No existe el indice");
        }

        DELink<T> temp = current.getNext().getNext();
        current.setNext(temp);
    }

    /**
     * Busca la posicion de un nodo en especifico y lo elimina
     * @param value
    */
    public void deleteLink(T value) {
        int pos = findPosition(value);
        if (pos != -1) {
            deleteAt(pos);
        }
    }

    /**
     * Elimina los datos de la lista
    */
    public void cleanList() {
        first=null;
        last=null;
        System.out.println("La lista fue limpiada");

    }

    /**
     * Imprime la lista
    */
    public void displayList() {
        System.out.print("List (first--> ");
        DELink<T> current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println("<--last)");
    }

}
