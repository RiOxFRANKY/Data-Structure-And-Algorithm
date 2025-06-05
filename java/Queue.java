class Queue<T> {
    private LinkedList<T> queue = new LinkedList<>();
    private int length = 0;

    public void enqueue(T data){
        queue.insertAtBeginning(data);
        length++;
    }

    public T dequeue(){
        if (length == 0) {
            throw new RuntimeException("The Stack is Empty");
        }

        T ans = queue.get(0);
        queue.removeAt(0);
        length--;
        return ans;
    }

    public T front(){
        if (length == 0) {
            throw new RuntimeException("The Stack is Empty");
        }

        return queue.get(0);
    }

    public int size(){
        return length;
    }

    public void printf(){
        queue.printf();
    }


}
