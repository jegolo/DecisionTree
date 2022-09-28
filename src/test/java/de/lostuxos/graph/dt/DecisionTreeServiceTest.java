package de.lostuxos.graph.dt;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DecisionTreeServiceTest {

    @Test
    public void minimalDecisionTree() {

        //GIVEN
        var startNode = new Node("Start");
        var childNode = new Node("Child");

        var nodeRegistry = new NodeRegistry();
        nodeRegistry.addNode(startNode);
        nodeRegistry.addNode(childNode);

        var nodeService = new DecisionTreeService();

        //WHEN
        List<Node> allowedNodes = nodeService.calculateAllowedNodes(Collections.emptyList(), nodeRegistry);

        //THEN
        assertThat(allowedNodes)
                .hasSize(2)
                .containsExactly(startNode, childNode);


    }

    @Test
    public void childSelectedTree() {

        //GIVEN
        var startNode = new Node("Start");
        var childNode = new Node("Child");


        var nodeRegistry = new NodeRegistry();
        nodeRegistry.addNode(startNode);
        nodeRegistry.addNode(childNode);

        var nodeService = new DecisionTreeService();

        //WHEN
        List<Node> allowedNodes = nodeService.calculateAllowedNodes(List.of(childNode), nodeRegistry);

        //THEN
        assertThat(allowedNodes)
                .hasSize(1)
                .containsExactly(startNode);


    }

    @Test
    public void childDependsOnStart() {

        //GIVEN
        var startNode = new Node("Start");
        var childNode = new Node("Child");
        var depends = new Edge();
        depends.setNodeList(List.of(startNode));
        depends.setEdgeType(EdgeType.OR);
        childNode.setNeeds(depends);

        var nodeRegistry = new NodeRegistry();
        nodeRegistry.addNode(startNode);
        nodeRegistry.addNode(childNode);

        var nodeService = new DecisionTreeService();

        //WHEN
        List<Node> allowedNodes = nodeService.calculateAllowedNodes(List.of(childNode), nodeRegistry);

        //THEN
        assertThat(allowedNodes)
                .isEmpty();

    }
}