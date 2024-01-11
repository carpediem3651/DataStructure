package LinkedList;

public class SingleLinkedList<T> {
    public Node<T> head = null;

    // 노드 정의
    public class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (head == null) {
            head = new Node<T>(data);
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            // node의 포인터가 업다면 마지막 노드가 된다.
            node.next = new Node<T>(data);
        }
    }

    // 출력 메서드
    public void printAll() {
        if (head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    // 노드 검색 메서드
    public Node<T> search(T data) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            // 노드가 있다면, 노드가 없을 때 까지 순회하며 입력된 값과 맞는 노드를 찾는다.
            while(node != null) {
                if(node.data == data) {
                    return node;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }

    // 중간에 노드 넣기 메서드
    public void addNodeInside(T data, T isData) {
        // 중간 노드 넣기 전의 노드
        Node<T> searchedNode = this.search(isData);

        if (searchedNode == null) {
            this.addNode(data);
        } else {
            Node<T> nextNode = searchedNode.next;

            // 중간에 넣을 노드
            searchedNode.next = new Node<T>(data);

            // 다음 노드 가리키기(Pointer)
            searchedNode.next.next = nextNode;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> MyLinkedList = new SingleLinkedList<Integer>();
        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);

        // 1 노드 뒤에 5 노드 넣기
        // MyLinkedList.addNodeInside(5, 1);
        // 3 노드 뒤에 6 노드 넣기(끝 경계선 테스트)
        // MyLinkedList.addNodeInside(6, 3);
        // 20 노드 뒤에 7 노드 넣기
        MyLinkedList.addNodeInside(7, 20);
        MyLinkedList.printAll();
    }

}
