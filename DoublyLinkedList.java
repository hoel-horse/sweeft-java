public class DoublyLinkedList{
    private Node head;
    private Node tail;
    private int size;

    private class Node{
        int data;
        Node prev;
        Node next;

        public Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        ++size;
    }

    public void remove(Node node){
        if(head == null){
            return;
        }

        if(node == head){
            head = head.next;
            if(head != null){
                head.prev = null;
            }
            else{
                tail = null;
            }
        }
        else if(node == tail){
            tail = tail.prev;
            tail.next = null;
        }
        else{
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        --size;
    }

    public int size(){
        return size;
    }

    public void display(){
        Node cur = head;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        DoublyLinkedList l = new DoublyLinkedList();
        l.add(1);
        l.add(2);
        l.add(3);
        l.display();

        Node node = l.head.next;
        l.remove(node);
        l.display();
    }
}