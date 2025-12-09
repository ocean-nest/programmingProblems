package java_practice.dfs.tree.inorder.recursive;

import java.util.ArrayList;
import java.util.List;

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

public class InorderTreeRecursive {
    public static List<Integer> nodeList = new ArrayList<>();
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        inorder(root, nodeList);
        System.out.println(nodeList);
        //4 2 5 1 3 6
    }

    public static void inorder(Node curr, List<Integer> nodeList) {
        if(curr != null) {
            inorder(curr.left, nodeList);
            nodeList.add(curr.data);
            inorder(curr.right, nodeList);
        }
    }
}
