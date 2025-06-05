class Stack<T>{
    private int length = 0;
    private LinkedList<T> stack = new LinkedList<>();
    public void push(T data){
        stack.insertAtEnd(data);
        length++;
    }

    public T pop(){
        if (length == 0) {
            throw new RuntimeException("The Stack is Empty");
        }

        T ans = stack.get(length-1);
        stack.removeAt(length-1);
        length--;
        return ans;
    }

    public T peek(){
        if (length == 0) {
            throw new RuntimeException("The Stack is Empty");
        }

        return stack.get(length-1);
    }

    public boolean isEmpty(){
        if (stack.getHead() == null) {
            return true;
        }

        return false;
    }

    public int size(){
        return length;
    }

    public void printf(){
        stack.printf();
        return;
    }

}