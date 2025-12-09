package java_practice.dfs.tree.preorder.recursive;
import java_practice.dfs.tree.Node;

public class PreOrderTreeRecursive {
    public static void main(String[] args) {
        // Create binary tree
        //       1
        //      /  \
        //    2     3
        //   / \     \
        //  4   5     6
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        preOrder(root);
        //1 2 4 5 3 6
    }
    public static void preOrder(Node node) {
        if(node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}
