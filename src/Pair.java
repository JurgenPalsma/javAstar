/*
        Triangles - An implementation of A* in Java

        This code was provided by Andy King - A.M.King@kent.ac.uk

        Jurgen PALSMA
        University of Kent
        jjp29@kent.ac.uk
*/

import java.util.*;


public class Pair implements Comparable<Pair>
{
    private double rank;
    private LinkedList<Vertex> route;

    public double getRank()
    {
        return rank;
    }

    public LinkedList<Vertex> getRoute()
    {
        return route;
    }

    Pair(double rank, LinkedList<Vertex> route)
    {
        this.rank = rank;
        this.route = route;
    }

    public int compareTo(Pair pair)
    {
        if (rank > pair.getRank()) return 1;
        else if (rank < pair.getRank()) return -1;
        else return 0; // return (int) (rank - pair.getRank());
    }

    public String toString() // force short debug traces
    {
        return "(" + String.format("%.2f", rank) + ", " + route + ")";
    }

}
