/*
        Triangles - An implementation of A* in Java

        Jurgen PALSMA
        University of Kent
        jjp29@kent.ac.uk
*/

import java.util.List;
import java.util.Vector;

public class Path {


    List<Vertex> vertices;


    Path(Vertex start) {
      this.vertices = new Vector<>();
      this.vertices.add(start);
    }

    Path(Path base) {
        this.vertices = new Vector<>();

        for (Vertex v : base.getVertices()) {
            this.vertices.add(v);
        }
    }

    void addVertex(Vertex v) {

        this.vertices.add(v);
    }

    Vertex getFinish() {
        return vertices.get(vertices.size() - 1);
    }


    List<Vertex> getVertices() {
        return this.vertices;
    }

    void print() {
        System.out.print("Path: ");
        for (Vertex v : this.vertices) {
            System.out.print("(" + v.get_x() + ", " + v.get_y() + ") ");
        }
        System.out.println();
    }

}
