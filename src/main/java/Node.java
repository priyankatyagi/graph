import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node {
    private String name;
    private List<Node> neighbours;

    public Node(String name) {
        this.name = name;
        neighbours = new ArrayList<Node>();
    }

    public void connectTo(Node other) {
        neighbours.add(other);
    }

    public boolean canReach(Node other) {
        return hopsTo(other)!= Integer.MAX_VALUE;
    }


    public int hopsTo(Node other) {
        List<Node> visitedNodes = new ArrayList<>();
        return hopsTo(other, visitedNodes);
    }

    private int hopsTo(Node other, List<Node> visitedNodes) {
        if(this == other)
            return 0;
        if(neighbours.contains(other))
            return 1;
        if(visitedNodes.contains(this))
            return Integer.MAX_VALUE;
        visitedNodes.add(this);

        List<Integer> hops = new ArrayList<>();

        for (Node neighbour : neighbours) {
            int hopsFromNeighbour = neighbour.hopsTo(other, visitedNodes);
            if(hopsFromNeighbour != Integer.MAX_VALUE)
                hops.add(1+hopsFromNeighbour);
        }

        if(hops.isEmpty())
            return Integer.MAX_VALUE;
        else
            return Collections.min(hops);
    }
}
