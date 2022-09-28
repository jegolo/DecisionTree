package de.lostuxos.graph.dt;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Node {

    private final String name;
    //can be xor,or,and
    private Edge needs;
    //is a list of or
    private List<Node> prohabibt;

}
