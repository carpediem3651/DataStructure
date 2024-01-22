package Practice;

public class BST {
    Node head = null;

    public class Node {
        Node left;
        Node right;
        int value;

        public Node (int data) {
            this.value = data;
            this.right = null;
            this.left = null;
        }
    }

    public boolean insertNode(int data) {
        // CASE 1: Node가 하나도 없을 때
        if (this.head == null) {
            this.head = new Node(data);
        } else {
            // CASE 2: Node가 하나 이상 들어가 있을 때
            Node findNode = this.head;
            while(true) {
                // CASE 2-1: 현재 Node의 왼쪽에 Node가 들어가야 할 때
                if (data < findNode.value) {
                    if(findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }
                // CASE 2-2: 현재 Node의 오른쪽에 Node가 들어가야할 때 즉, data의 값이 Node의 오른쪽 값보다 클 때
                } else {
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public Node search(int data) {
        // CASE1: Node가 하나도 없을 때
        if (this.head == null) {
            return null;
        // CASE2: Node가 하나 이상 있을 때
        } else {
            Node findNode = this.head;
            while (findNode != null) {
                if( findNode.value == data) {
                    return findNode;
                } else if (data < findNode.value) {
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
            return null;
        }
    }

    public boolean delete(int value) {
        boolean searched = false;

        Node currParentNode = this.head;
        Node currNode = this.head;

        // 코너 케이스1: Node가 하나도 없을 때
        if(this.head == null) {
            return false;
        } else {
            // 코너 케이스2: Node가 단지 하나만 있고, 해당 Node가 삭제할 Node일 때
            if(this.head.value == value && this.head.left == null && this.head.right==null) {
                // null은 Node의 삭제를 의미한다.
                this.head = null;
                return true;
            }
            
            // Node가 없을 때 까지 반복한다.
            while (currNode != null) {
                if (currNode.value == value) {
                    searched = true;
                    break;
                    // 현재 노드의 값이 삭제할 노드의 값보다 클 경우
                } else if (value < currNode.value) {
                    // 아래 코드 이해가 잘....
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    // 현재 노드의 값이 삭제할 노드의 값보다 작은 경우
                    currParentNode = currNode;
                    currNode = currNode.right;
                }

                if (searched == false) {
                    return false;
                }
            }
            // currNode는 해당 데이터를 가지고 있는 Node
            // currParentNode는 해당 데이터를 가지고 있는 Node의 부모
        }
    }
}
