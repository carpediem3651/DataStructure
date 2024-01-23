package Practice;

public class BST {
    Node head = null;

    public class Node {
        Node left;
        Node right;
        int value;

        public Node(int data) {
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
            while (true) {
                // CASE 2-1: 현재 Node의 왼쪽에 Node가 들어가야 할 때
                if (data < findNode.value) {
                    if (findNode.left != null) {
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
        // Case1: 삭제할 Node가 Leaf Node인 경우
        if (currNode.left == null && currNode.right == null) {
            // 자식 노드를 삭제한 후에 연결 할 노드가 없으니 부모 노드는 null이 된다.
            if(value <currParentNode.value) {
                currParentNode.left = null;
                currNode = null;
            }else {
                currParentNode.right = null;
                currNode = null;
            } 
            return true; 
        // Case2-1: 삭제할 Node가 Child Node를 한 개 가지고 있을 때 (왼쪽인 경우)
        } else if (currNode.left != null && currNode.right == null) {
            if(value < currParentNode.value) {
                // 부모 노드는 삭제된 노드의 왼쪽 자식을 가리킨다.
                currParentNode.left = currNode.left;
                currNode = null;
            } else {
                currParentNode.right = currNode.left;
                currNode = null;
            }
            return true;
        // Case2-2: 삭제할 Node가 Child Node를 한 개 가지고 있을 때 (오른쪽인 경우)
        } else if (currNode.left == null && currNode.right != null) {
            if (value < currParentNode.value) {
                currParentNode.left = currNode.right;
                currNode = null;
            } else {
                currParentNode.right = currNode.right;
                currNode = null;
            }
            return true;
        // Case3-1: 삭제할 Node가 Child Node를 두개 가지고 있다.
        } else {
            // 삭제할 Node가 부모 Node의 왼쪽에 있을 때
            if (value < currParentNode.value) {
                
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                // changeNode에는 삭제할 Node의 오른쪽 자식 Node중에서 가장 작은 값이 들어가있다.

                if (changeNode.right != null) {
                    // Case 3-1-2: chageNode의 오른쪽 Child Node가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    // Case 3-1-1: changeNode의 Child Node가 없을 때
                    changeParentNode.left = null;
                }

                // currParentNode의 왼쪽 Child Node에 삭제할 Node의 오른쪽 자식중 가장 작은 값을 가진 Node를 연결
                currParentNode.left = changeNode;

                // parentNode의 왼쪽 Child Node가 현재 ChangeNode이고, changeNode의 왼쪽 / 오른쪽 Child Node를 모두
                // 삭제할 currNode의 기존 왼쪽/오른쪽 Node로 변경
                changeNode.right = currNode.right;
                changeNode.left = currNode.left;

                currNode = null;
            }
        }
        

}
