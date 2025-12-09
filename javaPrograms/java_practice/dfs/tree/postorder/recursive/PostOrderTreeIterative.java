package java_practice.dfs.tree.postorder.recursive;

import java_practice.dfs.tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTreeIterative {

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

        Stack<Node> st1 = new Stack<>();
        st1.push(root);
        Stack<Node> st2 = new Stack<>();
        List<Integer> list = new ArrayList<>();

        while (!st1.empty()) {
            Node curr = st1.pop();
            st2.push(curr);

            if(curr.left != null) {
                st1.push(curr.left);
            }
            if(curr.right != null) {
                st1.push(curr.right);
            }
        }

        while (!st2.empty()) {
            list.add(st2.pop().data);
        }

        System.out.println(list);

    }
}
