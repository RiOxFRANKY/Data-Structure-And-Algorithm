

class Node<T>{
    T data;
    Node<T> next;

    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }
}

class LinkedList<T>{
    private Node<T> head;

    public void printf(){
        Node<T> curr = head;
        if (curr == null) {
            System.out.println("LinkedList is empty");
            System.err.println();
            return;
        }
        while (curr != null) {
            System.out.print(curr.data + "\t");
            curr = curr.next;
        }
        System.err.println();
        return;
    }


    public int length(){
        int count = 0;
        Node<T> itr = head;
        while (itr != null) {
            count++;
            itr = itr.next;
        }

        return count;
    }

    public void insertAtBeginning(T data){
        Node<T> node = new Node<>(data,head);
        head = node;
        return;
    }

    public void insertAtEnd(T data){
        if (head == null) {
            Node<T> node = new Node<>(data,null);
            head = node;
            return;
        }
        Node<T> itr = head;
        while (itr.next != null) {
            itr = itr.next;
        }
        itr.next = new Node<>(data, null);
        return;
    }

    public void insertAt(int index, T data){
        if (index < 0 || index >= length()) {
            System.out.println("Invalid Index");
            return;
        }

        if (index == 0) {
            insertAtBeginning(data);
            return;
        }

        int count = 0;
        Node<T> itr = head;
        while (itr != null) {
            if (count == index - 1) {
                Node<T> node = new Node<>(data,itr.next);
                itr.next = node;
            }
            count++;
            itr = itr.next;
        }
        return;
    }

    public void removeAt(int index){
        if (index < 0 || index >= length()) {
            System.out.println("Invalid Index");
            return;
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        int count = 0;
        Node<T> itr = head;
        while (itr != null) {
            if (count == index - 1) {
                itr.next = itr.next.next;
            }
            count++;
            itr = itr.next;
        }
        return;
    }

    public void insertValues(T[] data_list){
        for(T data: data_list){
            insertAtEnd(data);
        }
        return;
    }

    public void insertAfterValue(T data_after, T data_to_insert){
        Node<T> itr = head;
        while (itr != null) {
            if (itr.data == data_after) {
                Node<T> node = new Node<>(data_to_insert, itr.next);
                itr.next = node;
                break;
            }
            itr = itr.next;
        }
        return;
    }

    public void removeByValue(T data){
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node<T> itr = head;
        while (itr.next != null) {
            if (itr.next.data == data) {
                itr.next = itr.next.next;
                return;
            }
            itr = itr.next;
        }
    }

    public void reverse(){
        Node<T> prev = null;
        Node<T> itr = head;
        Node<T> next;
        while (itr != null) {
            next = itr.next;
            itr.next = prev;
            prev = itr;
            itr = next; 
        }

        head = prev;
        return;
    }


    public Node<T> getHead(){
        if (head == null) {
            throw new RuntimeException("Stack is Empty");
        }
        return head;
    }

    public T get(int index){
        if (index >= length()) {
            throw new RuntimeException("Index Out of Bounds");
        }
        int count = 0;
        Node<T> itr = head;
        while (itr != null) {
            if (count == index) {
                return itr.data;
            }
            count++;
            itr = itr.next;
        }
        throw new RuntimeException("Unexpected error: Index not found");
    }
}