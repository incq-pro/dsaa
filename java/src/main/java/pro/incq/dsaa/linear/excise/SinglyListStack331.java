package pro.incq.dsaa.linear.excise;

public class SinglyListStack331<T> {
    private static class Node<T> {
        T d;
        Node<T> next;

        public Node(T d, Node<T> next) {
            this.d = d;
            this.next = next;
        }
    }

    private Node<T> head;

    public void push(T d) {
        head = new Node<>(d, head);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T pop() {
        if (head != null) {
            T d = head.d;
            head = head.next;
            return d;
        }
        throw new IndexOutOfBoundsException();
    }

    public static void main(String[] args) {
        SinglyListStack331<Integer> stack = new SinglyListStack331<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
