package DELink;

public class DELinkList<T extends Comparable<T>> {

    private DELink<T> first;
    private DELink<T> last;

    public DELinkList() {
        first = null;
        last = null;
    }

    public void lastElement() {
        T current = last.getdData();
        System.out.println(current);
    }

    public void firstElement() {
        T current = first.getdData();
        System.out.println(current);
    }

    public boolean isEmpty() {
        return (first == null);
    }

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

    public DELink<T> deleteFirst() {
        DELink<T> current = null;
        if (!isEmpty()) {
            current = first;
            first = first.getNext();
        }
        return current;
    }

    // insertar al final
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

    // eliminar al final
    public DELink<T> deleteLast() {
        DELink<T> temp = null;
        DELink<T> current = first;

        while (current != null) {
            if (current.getNext().getNext() == null) {
                temp = current.getNext();
                current.setNext(null);
            } else {
                current = current.getNext();
            }
        }

        return temp;
    }

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

    public void insertAt(T dd, int index) {
        DELink<T> newLink = new DELink<T>(dd);
        if (index == 0) {
            insertFirst(dd);
        } else {
            DELink<T> current = first;
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

    public int elements() {
        DELink<T> current = first;
        int contador = 0;
        while (current != null) {
            current = current.getNext();
            contador++;
        }

        return contador;
    }

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

    public void replaceWithIndex(T value, int index) {
        int contador = 0;

        if (isEmpty()) {
            System.out.println("Lista vacia");

        } else {
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

    // buscar un valor de tipo double(numero)
    public DELink<T> find(T key) {
        DELink<T> current = first;
        while (current.getdData() != key) {
            if (current.getNext() == null) {
                return null;
            } else {
                current = current.getNext();
            }
        }

        return current;

    }

    // busca la posicion de ese elemento
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

    // recibe la posicion del elemento
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
            return;
        }

        DELink<T> temp = current.getNext().getNext();
        current.setNext(temp);
    }

    /*
     * recibe un valor de tipo double, manda a buscar la posicion de ese valor
     * y despues lo manda a eliminar
     */
    public void deleteLink(T value) {
        int pos = findPosition(value);
        if (pos != -1) {
            deleteAt(pos);
        }
    }

    public void cleanList() {

        int contador = elements();
        for (int i = 0; i < contador; i++) {
            deleteFirst();
        }
        System.out.println("Lista vacia");

    }

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
