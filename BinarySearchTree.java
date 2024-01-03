public class Node {
    Node left;
    Node right;
    int value;

    public Node(int data) {
        this.value = data;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {
    Node head = null;

    public boolean insertNode(int data) {
        // CASE1. Node가 하나도 없을 떄
        if (this.head == null) {
            this.head = new Node(data);
        } else {
            // CASE2. Node가 하나 이상 들어가 있을 때
            Node findNode = this.head;
            while (true) {
                // CASE2-1. 현재 Node의 왼쪽에 Node가 들어가야할 때
                if (data < findNode.value) {
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }
                    // CASE2-2. 현재 Node의 오른쪽에 Node가 들어가야할 때
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

    // 탐색
    public Node search(int data) {
        // CASE1: Node가 하나도 없을 때
        if (this.head == null) {
            return null;
            // CASE2: Node가 하나 이상 있을 때
        } else {
            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.value == data) {
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
            // 코너 케이스2: Node가 하나이고 해당 Node가 삭제할 Node일 때
            if(this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }

            while (currNode != null) {
                if(currNode.value == value) {
                    searched = true;
                    break;
                } else if (value < currNode.value) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }

            if(searched == false) {
                return false;
            }
        }
        
        // Case1: 삭제할 Node가 Leaf Node인 경우
        if(currNode.left == null && currNode.right == null) {
            if(value < currParentNode.value) {
                currParentNode.left = null;
                currNode = null;
            } else {
                currParentNode.right = null;
                currNode = null;
            }
        }
    }
}
