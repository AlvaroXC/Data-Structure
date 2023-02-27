public class LinkList<T extends Comparable<T>> {
    private Link<T> first;

    public LinkList() {
        first = null;
    }

    /**
     * Inserta un elemento en orden ascendente
     * El primer dato que encuentre que sea menor a dd, se insertara despues
     * Si la lista esta vacia se inserta como el primero
     * 
     * @param dd
     */
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

    /**
     * Inserta un elemento en orden descendente
     * El primer dato que encuentre que sea mayor a dd, dd se insertara despues
     * Si la lista esta vacia se inserta como el primero
     * 
     * @param dd
     * 
     */
    public void insertInOrderDecrease(T dd) {

        if (isEmpty()) {
            insertFirst(dd);
        } else if (dd.compareTo(first.getdData()) > 0) {
            insertFirst(dd);
        } else {

            Link<T> current = first;
            Link<T> previos = null;
            Link<T> newLink = new Link<T>(dd);
            while (current != null && dd.compareTo(current.getdData()) < 0) {
                previos = current;
                current = current.getNext();
            }
            previos.setNext(newLink);
            newLink.setNext(current);
        }

    }

    /**
     * Muestra el ultimo elemento de la lista
     * Si esta vacia la lista manda un mensaje
     */
    public void lastElement() {
        if (isEmpty()) {
            System.out.println("La lista está vacía");
        } else {
            Link<T> current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            System.out.println(current.getdData());
        }
    }

    /**
     * Muestra el primer elemento de la lista
     * Si esta vacia la lista manda un mensaje
     */
    public void firstElement() {
        if (isEmpty()) {
            System.out.println("La lista está vacia");
        } else {

            System.out.println(first.getdData());
        }
    }

    /**
     * Verifica si la lista esta vacia
     * 
     * @return boolean
     */
    public boolean isEmpty() {
        return (first == null);
    }

    /**
     * Inserta un elemento al principio de la lista
     * 
     * @param dd
     * 
     */
    public void insertFirst(T dd) {
        Link<T> newLink = new Link<T>(dd);
        if (isEmpty() == true) {
            newLink.setNext(first);
            first = newLink;
        } else {
            newLink.setNext(first);
            first = newLink;
        }
    }

    /**
     * Elimina el primer elemento de la lista
     * 
     * @return DELink<T>
     */
    public Link<T> deleteFirst() {
        Link<T> current = null;
        if (!isEmpty()) {
            current = first;
            first = first.getNext();
        } else {
            System.out.println("La lista está vacia");
        }
        return current;
    }

    /**
     * Inserta un elemento al final de la lista
     * Si esta vacia la lista se inserta como primer elemento
     * 
     * @param dd
     */
    public void insertLast(T dd) {

        Link<T> newLink = new Link<T>(dd);
        Link<T> current = first;

        if (isEmpty()) {
            insertFirst(dd);

        } else {

            while (current != null) {

                if (current.getNext() == null) {
                    newLink.setNext(null);
                    current.setNext(newLink);
                } else {
                    current = current.getNext();
                }
            }
        }
    }

    /**
     * Elimina el ultimo elemento de la lista
     * 
     * @return DELink<T>
     */
    public Link<T> deleteLast() {
        Link<T> temp = null;
        Link<T> current = first;

        if (isEmpty()) {
            System.out.println("La lista está vacia");
        } else {

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
     * Inserta un elemento en un index especifico
     * Si no existe el index en la lista, manda un mensaje
     * 
     * @param dd
     * @param index
     * 
     */
    public void insertAt(T dd, int index) {
        Link<T> newLink = new Link<T>(dd);
        if (index == 0) {
            insertFirst(dd);
        } else if (index < 0 || index > elements()) {
            System.out.println("Index no valido");
        } else {
            Link<T> current = first;
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
     * 
     * @return int
     */
    public int elements() {
        Link<T> current = first;
        int contador = 0;
        while (current != null) {
            current = current.getNext();
            contador++;
        }

        return contador;
    }

    /**
     * Busca un elemento especifico en la lista
     * 
     * @return T
     */
    public T getElementAt(int index) {
        Link<T> current = first;
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
     * 
     * @param value
     * @param index
     */
    public void replaceWithIndex(T value, int index) {
        int contador = 0;

        if (isEmpty()) {
            System.out.println("Lista vacia");

        } else {
            Link<T> current = first;
            while (current != null) {

                if (contador == index) {
                    current.setdData(value);
                    break;
                } else {
                    current = current.getNext();
                    contador++;
                }
            }
            if (current == null) {
                System.out.println("Index no existente");
            }
        }
    }

    /**
     * Reemplaza el dato de un nodo, lo busca por su valor
     * 
     * @param valueB dato del nodo que se va reemplazar
     * @param valueA dato por el cual se cambia valueB
     */
    public void replace(T valueB, T valueA) {

        if (isEmpty()) {
            System.out.println("Lista vacia");
        } else {
            Link<T> current = first;
            while (current != null) {
                if (current.getdData().equals(valueB)) {
                    current.setdData(valueA);
                    break;
                } else {
                    current = current.getNext();
                }
            }
            if (current == null) {

                System.out.println("El dato no se encuentra en la lista");
            }
        }
    }

    /**
     * Encuentra el elemento de la lista
     * 
     * @return DELink<T>
     */
    public Link<T> find(T key) {

        Link<T> current = first;
        try {

            while (current.getdData() != key) {
                if (current.getNext() == null) {
                    return null;
                } else {
                    current = current.getNext();
                }
            }
        } catch (NullPointerException e) {
            System.out.println("No se encontró el elemento");
        }

        return current;

    }

    /**
     * Busca un nodo en la lista y devuelve su posicion
     * Si no existe el valor devuelve -1
     * 
     * @param value
     * @return contador
     */
    public int findPosition(T value) {
        Link<T> current = first;
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
     * 
     * @param index
     */
    public void deleteAt(int index) {
        Link<T> current = first;

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
            return;
        }

        Link<T> temp = current.getNext().getNext();
        current.setNext(temp);
    }

    /**
     * Busca la posicion de un nodo en especifico y lo elimina
     * 
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
        first = null;
        System.out.println("La lista fue limpiada");
    }

    /**
     * Imprime la lista
     */
    public void displayList() {
        System.out.print("List (first--> ");
        Link<T> current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println("<--last)");
    }

}