package com.java;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}

class NodeInfo {
    TreeNode node;
    int horizontalDistance;

    public NodeInfo(TreeNode node, int horizontalDistance) {
        this.node = node;
        this.horizontalDistance = horizontalDistance;
    }
}

public class Main {
    public void printBottomView(TreeNode root) {
        if (root == null) {
            return;
        }

        Map<Integer, NodeInfo> bottomViewMap = new TreeMap<>();
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.add(new NodeInfo(root, 0));

        while (!queue.isEmpty()) {
            NodeInfo currentInfo = queue.poll();
            TreeNode currentNode = currentInfo.node;
            int horizontalDistance = currentInfo.horizontalDistance;

            bottomViewMap.put(horizontalDistance, currentInfo);

            if (currentNode.left != null) {
                queue.add(new NodeInfo(currentNode.left, horizontalDistance - 1));
            }

            if (currentNode.right != null) {
                queue.add(new NodeInfo(currentNode.right, horizontalDistance + 1));
            }
        }

        for (NodeInfo nodeInfo : bottomViewMap.values()) {
            System.out.print(nodeInfo.node.data + " ");
        }
    }

    public static void main(String[] args) {
        Main bottomView = new Main();

        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        // Print the bottom view of the binary tree
        System.out.println("Bottom View of the Binary Tree:");
        bottomView.printBottomView(root);
    }
}
