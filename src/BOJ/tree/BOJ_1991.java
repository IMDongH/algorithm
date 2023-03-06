package BOJ.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Node{
    char data;
    Node left;
    Node right;

    Node(char data){
        this.data = data;
    }
}

class Tree{
    Node root;

    public void createNode(char data, char left, char right){
        if(this.root==null){
            root = new Node(data);

            if(left != '.'){
                root.left = new Node(left);
            }
            if(right != '.'){
                root.right = new Node(right);
            }
        }
        else{
            searchNode(root,data,left,right);
        }
    }

    public void searchNode(Node root,char data, char leftData, char rightData){
        if(root == null){
            return;
        }
        else if(root.data == data){
            if(leftData != '.') root.left = new Node(leftData);
            if(rightData != '.') root.right = new Node(rightData);
        }
        else{
            searchNode(root.left,data,leftData,rightData);
            searchNode(root.right,data,leftData,rightData);
        }
    }

    public void preorder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(Node node){
        if(node == null){
            return;
        }

        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }
    public void postorder(Node node){
        if(node == null){
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
    }
}
public class BOJ_1991 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        for(int i = 0; i<n; i++){
            char[] chars = br.readLine().replaceAll(" ", "").toCharArray();
            tree.createNode(chars[0],chars[1],chars[2]);
        }

        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
    }


}