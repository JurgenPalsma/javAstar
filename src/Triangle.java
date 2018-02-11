/*
        Triangles - An implementation of A* in Java

        Jurgen PALSMA
        University of Kent
        jjp29@kent.ac.uk
*/

import java.util.Vector;

public class Triangle { // The obstacles

    private Vector<Vertex> vertices;

    Triangle(Vertex a, Vertex b, Vertex c) {
        this.vertices = new Vector<>();

        // Add the three vertices of the triangle to the object's list
        this.vertices.add(a);
        this.vertices.add(b);
        this.vertices.add(c);

    }

    Vector<Vertex> getVertices() {
        return this.vertices;
    }

}
