package java_practice.dfs.tree.inorder.iterative;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class InorderTreeIterative {
    public static List<Integer> nodeList = new ArrayList<>();
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.empty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            nodeList.add(curr.data);
            curr = curr.right;
        }
        System.out.println(nodeList);
        //4 2 5 1 3 6
    }
}
