class Node {
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

    // 삭제
    public boolean delete(int value) {
        boolean searched = false;

        Node currParentNode = this.head;
        Node currNode = this.head;

        // 코너 케이스1: Node가 하나도 없을 때
        if (this.head == null) {
            return false;
        } else {
            // 코너 케이스2: Node가 하나이고 해당 Node가 삭제할 Node일 때
            if (this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }

            while (currNode != null) {
                if (currNode.value == value) {
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

            if (searched == false) {
                return false;
            }
        }
        // currNode는 해당 데이터를 가지고 있는 Node
        // currParentNode는 해당 데이터를 가지고 있는 Node의 부모 Node

        // Case1: 삭제할 Node가 Leaf Node인 경우
        if (currNode.left == null && currNode.right == null) {
            if (value < currParentNode.value) {
                currParentNode.left = null;
                currNode = null;
            } else {
                currParentNode.right = null;
                currNode = null;
            }
            return true;
            // Case2-1: 삭제할 Node가 Child Node를 한 개 가지고 있을 경우(왼쪽 child)
        } else if (currNode.left != null && currNode.right == null) {
            if (value < currParentNode.value) {
                currParentNode.left = currNode.left;
                currNode = null;
            } else {
                currParentNode.right = currNode.left;
                currNode = null;
            }
            return true;
            // Case2-2: 삭제할 Node가 Child Node를 한 개 가지고 있을 경우(오른쪽 child)
        } else if (currNode.left == null && currNode.right != null) {
            if (value < currParentNode.value) {
                currParentNode.left = currNode.right;
                currNode = null;
            } else {
                currParentNode.right = currNode.right;
                currNode = null;
            }
            return true;
        } else {
            // Case 3-1: 삭제할 Node가 Parent Node 왼쪽에 있을 때
            if (value < currParentNode.value) {
                // 삭제할 Node가 부모 Node의 왼쪽에 있을 때
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (currNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }

                if (changeNode.right != null) {
                    // Case3-1-2: changeNode의 오른쪽 Child Node가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    // Case3-1-1: changeNode의 Child Node가 없을 때
                    changeParentNode.left = null;
                }

                // currParentNode의 왼쪽 Child Node에 삭제할 Node의 오른쪽 자식중, 가장 작은 값을 가진 changeNode를 연결
                currParentNode.left = changeNode;

                // parentNode의 왼쪽 Child Node가 현재 chageNode이고, changeNode의 왼쪽/오른쪽 Child Node를 모두
                // 삭제할 currNode의
                // 왼쪽/오른쪽 Node로 변경
                changeNode.right = currNode.right;
                changeNode.left = currNode.left;

                currNode = null;
            } else {
                // Case 3-2: 삭제할 노드가 parent Node의 오른쪽에 있을 때
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (currNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }

                if (changeNode.right != null) {
                    // Case3-2-2: 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 오른쪽에 Child Node가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    // Case3-2-1: 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 오른쪽에 Child Node가 없을 때
                    changeParentNode.left = null;
                }

                // parent Node 의 오른쪽 Child Node 에 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 changeNode 를
                // 연결
                currParentNode.right = changeNode;

                changeNode.right = currNode.right;
                changeNode.left = currNode.left;

                currNode = null;
            }
            return true;
        }
    }
}
