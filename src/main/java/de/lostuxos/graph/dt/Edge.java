package de.lostuxos.graph.dt;

import lombok.Data;

import java.util.List;

@Data
public class Edge {
    private EdgeType edgeType;
    List<Node> nodeList;

}
