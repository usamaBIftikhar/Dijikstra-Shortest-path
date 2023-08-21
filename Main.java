package com.clodrock;

import java.util.Comparator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addNode(nodeB, 10);
        nodeA.addNode(nodeC, 15);

        nodeB.addNode(nodeD, 12);
        nodeB.addNode(nodeF, 15);

        nodeC.addNode(nodeE, 10);

        nodeD.addNode(nodeE, 2);
        nodeD.addNode(nodeF, 1);

        nodeF.addNode(nodeE, 5);

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        calculateNodeDistance(graph, nodeA);
    }

    private static void calculateNodeDistance(Graph graph, Node rootNode){
        rootNode.setDistance(0);
        int counter = 1;

        while(counter < graph.nodeList.size()) {
            Node node = findNode(graph);
            calculateDistance(node);
            node.setVisited();
            counter++;
        }

        for (Node node : graph.nodeList){
            System.out.println(node.getName() + " ---> " + node.getDistance());
        }
    }

    private static Node findNode(Graph graph) {
        return graph.nodeList.stream().filter(p->!p.getVisited()).min(Comparator.comparing(Node::getDistance)).get();
    }

    private static void calculateDistance(Node node){
        Map<Node, Integer> nodeMap =  node.getNodeMap();
        for(Map.Entry<Node, Integer> neigh : nodeMap.entrySet()){
            if(neigh.getValue() + node.getDistance() < neigh.getKey().getDistance())
                neigh.getKey().setDistance(neigh.getValue() + node.getDistance());
        }
    }
}
