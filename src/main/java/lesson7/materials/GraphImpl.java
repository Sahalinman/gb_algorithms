package lesson7.materials;

import java.util.*;

public class GraphImpl implements Graph {

    private List<Vertex> vertexList;
    private boolean[][] adjMatrix;

    private List<Edge> edges = new ArrayList<>();

    private Integer[][] adjWeighedMatrix;
    private boolean weighed;

    public GraphImpl(int maxVertexCount, boolean weighed) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.weighed = weighed;
        if (weighed) {
            this.adjWeighedMatrix = new Integer[maxVertexCount][maxVertexCount];
        } else {
            this.adjMatrix = new boolean[maxVertexCount][maxVertexCount];
        }
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = true;
        return true;
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, int edgeValue) {

        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjWeighedMatrix[startIndex][endIndex] = edgeValue;
        edges.add(new Edge(vertexList.get(startIndex), vertexList.get(endIndex), edgeValue));

        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(startLabel, secondLabel);

        for (String other : others) {
            result &= addEdge(startLabel, other);
        }

        return result;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        if (weighed) {
            for (int i = 0; i < getSize(); i++) {
                System.out.print(vertexList.get(i));
                for (int j = 0; j < getSize(); j++) {
                    if (adjWeighedMatrix[i][j] != null) {
                        System.out.print(" -> " + vertexList.get(j));
                    }
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < getSize(); i++) {
                System.out.print(vertexList.get(i));
                for (int j = 0; j < getSize(); j++) {
                    if (adjMatrix[i][j]) {
                        System.out.print(" -> " + vertexList.get(j));
                    }
                }
                System.out.println();
            }
        }
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitedVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitedVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
        System.out.println();
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        if (weighed) {
            for (int i = 0; i < getSize(); i++) {
                if (adjWeighedMatrix[currentIndex][i] != null && !vertexList.get(i).isVisited()) {
                    return vertexList.get(i);
                }
            }
        } else {
            for (int i = 0; i < getSize(); i++) {
                if (adjMatrix[currentIndex][i] && !vertexList.get(i).isVisited()) {
                    return vertexList.get(i);
                }
            }
        }
        return null;
    }

    private void visitedVertex(Stack<Vertex> stack, Vertex vertex) {
//        System.out.print(vertex.getLabel() + " ");
        stack.add(vertex);
        vertex.setVisited(true);
    }

    private void visitedVertex(Queue<Vertex> queue, Vertex vertex) {
//        System.out.print(vertex.getLabel() + " ");
        queue.add(vertex);
        vertex.setVisited(true);
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitedVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitedVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
        System.out.println();
    }

    public List<String> searchWays(String startLabel, String endLabel) {

        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        Vertex vertexStart = vertexList.get(startIndex);
        Vertex vertexEnd = vertexList.get(endIndex);

        List<Vertex> ways = new ArrayList<>();
        Vertex v;
        while (getNearUnvisitedVertex(vertexStart) != null) {
            v = getNearUnvisitedVertex(vertexStart);
            ways.add(v);
            v.setVisited(true);
        }

        List<String> waysName = new ArrayList<>();

        for (int i = 0; i < ways.size(); i++) {

            Stack<Vertex> stack = new Stack<>();
            Vertex vertex = vertexList.get(startIndex);
            StringBuilder wayName = new StringBuilder(vertex.getLabel());

            ways.get(i).setVisited(false);

            visitedVertex(stack, vertex);
            while (!stack.isEmpty() && !vertex.getLabel().equals(vertexEnd.getLabel())) {
                vertex = getNearUnvisitedVertex(stack.peek());
                if (vertex != null) {
                    visitedVertex(stack, vertex);
                } else {
                    stack.pop();
                }
                wayName.append(" " + vertex.getLabel());
            }
            // System.out.println();
            vertexStart.setVisited(false);
            vertexEnd.setVisited(false);
            waysName.add(String.valueOf(wayName));
        }

        return waysName;
    }

    private int getWeightRoute(String way) {

        List<String> parsedWay = List.of(way.split(" "));
        int routeWeight = 0;
        for (int i = 0; i < parsedWay.size(); i++) {
            Edge edge = null;
            try {
                edge = getEdgeFromList(parsedWay.get(i), parsedWay.get(i + 1));
            } catch (ArrayIndexOutOfBoundsException e) {}
            if (edge != null) {
                routeWeight += edge.getEdgeValue();
            }
        }
        return routeWeight;
    }

    private Edge getEdgeFromList(String from, String to) {
        for (Edge e : edges) {
            if (e.getFrom().getLabel().contains(from) && e.getTo().getLabel().equals(to)) {
                return e;
            }
        }
        return null;
    }

    public void findBestRoute(List<String> waysName) {

        TreeMap<String, Integer> finalBestRoute = new TreeMap<>();
        int bestRoute = getWeightRoute(waysName.get(0));
        for (String w : waysName) {
            int route = getWeightRoute(w);
            System.out.println("Маршрут : " + w + " :: Длина пути : " + route);
            if (bestRoute >= route) {
                finalBestRoute.clear();
                finalBestRoute.put(w, route);
            }
        }

        System.out.println("============================================");
        for (Map.Entry route : finalBestRoute.entrySet()) {
            System.out.println("Оптимальный маршрут : " + route.getKey() + " с длиной пути " + route.getValue() + " единиц");
        }
    }
}

