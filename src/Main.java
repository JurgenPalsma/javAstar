/*
        Triangles - An implementation of A* in Java

        Jurgen PALSMA
        University of Kent
        jjp29@kent.ac.uk
*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Vector;
import java.lang.Math;

public class Main {


    public static double estimateDistance(Vertex start, Vertex finish) {

        // We estimate the distance using a Pythagoeran equation with a factor of alpha - alpha being a parameter that I
        // have tuned over multiple runs to have the shortest execution time whilst having the most optimal path
        // results possible.

        double alpha = 0.15;

        return Math.sqrt(Math.pow((finish.get_x() - start.get_x()), 2) + Math.pow((finish.get_y() - start.get_y()), 2)) * alpha;
    }

    public static double actualDistance(LinkedList<Vertex> v_list) {

        // A unit of distance is an intermediate vertex in a path, so we simply return the number of vertices.

        return v_list.size();
    }

    public static LinkedList<Vertex> nextConfigs(Vertex v, Map map) {

        // To get the next possible vertices, we move in a star-shaped fashion. We explore vertices up, down, left, right,
        // and diagonally, by increasing the distance by one each time. As a result, some possible vertices are
        // not returned. This is why some paths are not optimal - however, this star technique was MUCH faster than
        // other vector-finding techniques I tried. See the isValid(Map, int) method I implemented in the Vertex class-
        // this determines if a vector is an acceptable configuration.

        LinkedList<Vertex> configs = new LinkedList<>();

        // Go up
        int i = 1;
        while (true) {
            Vertex up = new Vertex(v.get_x(), v.get_y() + i);
            if (up.isValid(map, v))
                configs.add(up);
            else
                break;
            i++;
        }

        // Go up-right
        i = 1;
        while (true) {
            Vertex up = new Vertex(v.get_x() + i, v.get_y() + i);
            if (up.isValid(map, v))
                configs.add(up);
            else
                break;
            i++;
        }

        // Go right
        i = 1;
        while (true) {
            Vertex up = new Vertex(v.get_x() + i, v.get_y());
            if (up.isValid(map, v))
                configs.add(up);
            else
                break;
            i++;
        }

        // Go down-right
        i = 1;
        while (true) {
            Vertex up = new Vertex(v.get_x() + i, v.get_y() - i);
            if (up.isValid(map, v))
                configs.add(up);
            else
                break;
            i++;
        }

        // Go down
        i = 1;
        while (true) {
            Vertex up = new Vertex(v.get_x(), v.get_y() - i);
            if (up.isValid(map, v))
                configs.add(up);
            else
                break;
            i++;
        }

        // Go down-left
        i = 1;
        while (true) {
            Vertex up = new Vertex(v.get_x() - i, v.get_y() - i);
            if (up.isValid(map, v))
                configs.add(up);
            else
                break;
            i++;
        }

        // Go left
        i = 1;
        while (true) {
            Vertex up = new Vertex(v.get_x() - i, v.get_y());
            if (up.isValid(map, v))
                configs.add(up);
            else
                break;
            i++;
        }

        // Go up-left
        i = 1;
        while (true) {
            Vertex up = new Vertex(v.get_x() - i, v.get_y() + i);
            if (up.isValid(map, v))
                configs.add(up);
            else
                break;
            i++;
        }

        return configs;
    }

    public static void writeRoute(LinkedList<Vertex> route, String file_name) throws IOException {

        // function to write the route to a given file


        BufferedWriter out = null;
        try {
            FileWriter fstream = new FileWriter(file_name, true);
            out = new BufferedWriter(fstream);

            StringBuilder s_route = new StringBuilder();
            for (int i = 0; i < route.size(); i++) {
                s_route.append("(" + route.get(i).get_x() + ", " + route.get(i).get_y() + ")");
                if (i < route.size() - 1)
                    s_route.append(" ");
            }

            out.write(s_route.toString());
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            throw e;
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }


    public static void main(String[] args) {

        // Load Map
        Map map = new Map();

        // Get list of triangles
        Vector<Triangle> triangles = map.getTriangles();
        Vector<Problem> problems = map.getProblems();

        try { // A* - based on A.M King's material in the CO528 module at the University of Kent

            int problem_counter = 0;
            while (problem_counter < problems.size()) {

                Problem p = problems.get(problem_counter);
                LinkedList<Vertex> route = new LinkedList<>();
                route.add(p.getStart());
                PriorityQueue<Pair> pairs = new PriorityQueue<>();
                pairs.add(new Pair(estimateDistance(p.getFinish(), p.getStart()), route));

                while (true) {
                    if (pairs.size() == 0)
                        break; // null
                    Pair pair = pairs.poll();
                    route = pair.getRoute();
                    Vertex last = route.getLast();

                    if (last.get_x() == p.getFinish().get_x() && last.get_y() == p.getFinish().get_y()) {
                        writeRoute(route, "./../out/" + problem_counter + ".txt");
                        problem_counter++;
                        break;
                    } else {
                        LinkedList<Vertex> nextVertices = nextConfigs(last, map);

                        for (Vertex v : nextVertices) {
                            if (!route.contains(v)) {
                                LinkedList<Vertex> nextRoute = new LinkedList<>(route);
                                nextRoute.addLast(v);
                                double distance = actualDistance(nextRoute);
                                distance += estimateDistance(v, p.getFinish());
                                pairs.add(new Pair(distance, nextRoute));
                            }
                        }
                    }

                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
