package com.clodrock;

import java.util.HashMap;
import java.util.Map;

public class Node {

    private String nodeName;
    private Boolean visited = false;

    public Boolean getVisited(){
        return visited;
    }

    public void setVisited(){
        visited = Boolean.TRUE;
    }

    public Node(String name) {
        this.nodeName = name;
    }
    private Map<Node, Integer> nodeMap = new HashMap<>();

    public String getName()
    {
        return this.nodeName;
    }
    private Integer distance = Integer.MAX_VALUE;

    public void addNode(Node node, int distance){
        nodeMap.put(node, distance);
    }

    public Map<Node,Integer> getNodeMap(){
        return this.nodeMap;
    }

    public void setDistance(Integer distance){
        this.distance = distance;
    }

    public Integer getDistance(){
        return this.distance;
    }
}
