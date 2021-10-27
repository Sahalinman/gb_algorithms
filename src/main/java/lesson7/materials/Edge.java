package lesson7.materials;

import lombok.Data;

@Data
public class Edge {

    Vertex from;
    Vertex to;
    int edgeValue;

    public Edge(Vertex from, Vertex to, int edgeValue) {
        this.from = from;
        this.to = to;
        this.edgeValue = edgeValue;
    }

    public int getEdgeValue(String from, String to) {

        int result = 0;
        if (this.from.getLabel().equals(from) && this.to.getLabel().equals(to)) {
            result = this.getEdgeValue();
        }
        return result;
    }
}
