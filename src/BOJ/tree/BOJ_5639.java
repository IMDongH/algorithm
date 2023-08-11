package BOJ.tree;

import java.util.*;
import java.io.*;

public class BOJ_5639 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        String str = "";
        Tree tree = new Tree();
        while ((str = br.readLine())!=null&&!str.isEmpty()){
            tree.CreateNode(Integer.parseInt(str));
        }

        tree.postOrder(tree.root);
    }


    static class Tree{
        Node root;

        private void CreateNode(int data){

            if(this.root==null){
                root = new Node(data);
            }

            SearchNode(root,data);
        }

        private void SearchNode(Node node,int data){

            if(node == null) return ;

            if(node.data>data){
                if(node.left==null){
                    node.left = new Node(data);
                }else{
                    SearchNode(node.left,data);
                }
            }
            else if(node.data<data){
                if(node.right==null){
                    node.right = new Node(data);
                }else{
                    SearchNode(node.right,data);
                }
            }
        }
        private void postOrder(Node node){
            if(node == null) return;

            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
