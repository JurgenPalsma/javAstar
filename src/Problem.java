/*
        Triangles - An implementation of A* in Java

        Jurgen PALSMA
        University of Kent
        jjp29@kent.ac.uk
*/

public class Problem {

    private Vertex start;
    private Vertex finish;

    Problem(Vertex start, Vertex finish) {
        this.start = new Vertex(start.get_x(), start.get_y());
        this.finish = new Vertex(finish.get_x(), finish.get_y());
    }

    Vertex getStart() {
        return this.start;
    }

    Vertex getFinish() {
        return this.finish;
    }
}
