import java.io.*;
import java.util.*;

class Node {

    int root;
    Node left;
    Node right;

    Node (int n) {
        this.root = n;
        this.left = null;
        this.right = null;
    }

    public void insert(int n) {
        if (root > n) {
            if (left == null) {
                left = new Node(n);
            } else {
                left.insert(n);
            }
        }
        else {
            if (right == null) {
                right = new Node(n);
            } else {
                right.insert(n);
            }
        }
    }

}

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node node = new Node(Integer.parseInt(br.readLine()));

        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) break;

            node.insert(Integer.parseInt(input));
        }

        postOrder(node);

    }

    public static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.root);
    }
}