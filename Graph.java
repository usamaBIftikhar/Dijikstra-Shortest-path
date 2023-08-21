package com.clodrock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Graph {
    List<Node> nodeList = new LinkedList<>();

    public void addNode(Node node){
        nodeList.add(node);
    }
}
