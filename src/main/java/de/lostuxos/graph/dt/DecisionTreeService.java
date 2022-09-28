package de.lostuxos.graph.dt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DecisionTreeService {
    public List<Node> calculateAllowedNodes(List<Node> selectedNodes, NodeRegistry nodeRegistry) {

        List<Node> result = nodeRegistry.getNodes();

        var  dependencies = calculateDependencies(selectedNodes,nodeRegistry);

        if (!selectedNodes.isEmpty()) {
            result.removeAll(dependencies);
        }

        return result;
    }

    private List<Node> calculateDependencies(List<Node> selectedNodes, NodeRegistry nodeRegistry) {
        var enlarged = enlargeSelectedNodes(selectedNodes);

        return enlarged;
    }

    private List<Node> enlargeSelectedNodes(List<Node> selectedNodes) {
       var result = new LinkedList<Node>();
       for (var element : selectedNodes) {
           result.add(element);
           if (element.getNeeds() != null) {
               result.addAll(enlargeSelectedNodes(element.getNeeds().getNodeList()));
           }
       }
       return result;
    }
}
