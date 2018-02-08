import java.util.Vector;

public class Map {

    private Vector<Triangle> triangles;
    private Vector<Problem> problems;
    public static int map_size = 23;
    Map(String filepath) {
        this.triangles = new Vector<>();

        this.triangles.add(new Triangle(new Vertex(11,0), new Vertex(13, 1), new Vertex(18,5)));
        this.triangles.add(new Triangle(new Vertex(5,4), new Vertex(7, 9), new Vertex(5,8)));
        this.triangles.add(new Triangle(new Vertex(2,3), new Vertex(4, 11), new Vertex(2,6)));
        this.triangles.add(new Triangle(new Vertex(13,7), new Vertex(14, 9), new Vertex(17,10)));
        this.triangles.add(new Triangle(new Vertex(4,9), new Vertex(11, 16), new Vertex(9,11)));
        this.triangles.add(new Triangle(new Vertex(11,3), new Vertex(19, 7), new Vertex(18,10)));
        this.triangles.add(new Triangle(new Vertex(14,10), new Vertex(17, 12), new Vertex(22,11)));
        this.triangles.add(new Triangle(new Vertex(3,1), new Vertex(12, 9), new Vertex(6,9)));
        this.triangles.add(new Triangle(new Vertex(9,11), new Vertex(14, 12), new Vertex(14,19)));
        this.triangles.add(new Triangle(new Vertex(12,2), new Vertex(18, 7), new Vertex(20,8)));
        this.triangles.add(new Triangle(new Vertex(3,3), new Vertex(10, 6), new Vertex(12,8)));
        this.triangles.add(new Triangle(new Vertex(9,15), new Vertex(16, 19), new Vertex(14,15)));
        this.triangles.add(new Triangle(new Vertex(11,2), new Vertex(18, 6), new Vertex(11,3)));
        this.triangles.add(new Triangle(new Vertex(11,11), new Vertex(20, 12), new Vertex(13,17)));
        this.triangles.add(new Triangle(new Vertex(1,13), new Vertex(2, 13), new Vertex(5,20)));
        this.triangles.add(new Triangle(new Vertex(13,16), new Vertex(17, 19), new Vertex(14,20)));



        this.problems = new Vector<>();
        //this.problems.add(new Problem(new Vertex(4,11), new Vertex(19,7)));

        this.problems.add(new Problem(new Vertex(3,3), new Vertex(19,7)));
        this.problems.add(new Problem(new Vertex(4,11), new Vertex(19,7)));
        this.problems.add(new Problem(new Vertex(9,11), new Vertex(18,6)));
        this.problems.add(new Problem(new Vertex(2,6), new Vertex(19,7)));
        this.problems.add(new Problem(new Vertex(13,7), new Vertex(14,20)));
        this.problems.add(new Problem(new Vertex(2,3), new Vertex(19,7)));
        this.problems.add(new Problem(new Vertex(18,6), new Vertex(5,20)));
        this.problems.add(new Problem(new Vertex(19,7), new Vertex(5,20)));
        this.problems.add(new Problem(new Vertex(10,6), new Vertex(14,20)));
        this.problems.add(new Problem(new Vertex(18,5), new Vertex(5,20)));
        this.problems.add(new Problem(new Vertex(22,11), new Vertex(1,13)));
        this.problems.add(new Problem(new Vertex(5,20), new Vertex(19,7)));
    }

    Vector<Triangle> getTriangles() {
        return this.triangles;
    }

    Vector<Problem> getProblems() {
        return this.problems;
    }

}
