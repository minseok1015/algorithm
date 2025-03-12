package 백준;
import java.io.*;
import java.util.*;

public class Solution1991 {
    private static class Node{
        Node left;
        Node right;
        char value;

        public Node(char value, Node left,Node right){
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    private static Node root;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  =Integer.parseInt(br.readLine());

        Node head = new Node('A', null,null);

        for(int i =0 ; i <N; i++){
            String[] nodeInfo = br.readLine().split(" ");
            char root = nodeInfo[0].charAt(0);
            char left = nodeInfo[1].charAt(0);
            char right = nodeInfo[2].charAt(0);

            insert(head,root,left,right);
        }

        preorder(head);
        System.out.println();
        inorder(head);
        System.out.println();
        postorder(head);

    }

    private static void insert(Node temp,char root, char left, char right){
        if(temp.value== root){  //현재 내가 찾고 있던 노드이면
            temp.left = (left== '.' ? null : new Node(left,null,null));
            temp.right = (right== '.' ? null : new Node(right,null,null));
        }else{                  //아니면 왼쪽 오른쪽 나눠서 찾아감
            if(temp.left!=null) insert(temp.left,root,left,right);
            if(temp.right!=null) insert(temp.right,root,left,right);
        }
    }

    private static void preorder(Node node){
        if(node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }
    private static void inorder(Node node){
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    private static void postorder(Node node){
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }

}

//이렇게 풀면 만약에 노드가 순서대로 들어오지 않는다면 문제가 생길 수도 있지 않을까??