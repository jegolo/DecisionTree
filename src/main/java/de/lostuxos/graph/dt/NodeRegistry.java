package de.lostuxos.graph.dt;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

public class NodeRegistry {
    private List<Node> nodes = new LinkedList<>();

    public void addNode(Node node) {
        nodes.add(node);
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
