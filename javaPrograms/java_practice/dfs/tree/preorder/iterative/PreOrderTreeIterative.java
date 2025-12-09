package java_practice.dfs.tree.preorder.iterative;

import java_practice.dfs.tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTreeIterative {

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

        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);

        while (!stack.empty()) {
            Node curr = stack.pop();
            list.add(curr.data);

            if(curr.right != null) {
                stack.push(curr.right);
            }
            if(curr.left != null) {
                stack.push(curr.left);
           }
        }
        System.out.println(list);

        //1 2 4 5 3 6
    }
}
