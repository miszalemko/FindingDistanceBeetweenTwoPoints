package pl.com.wwa5.java;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Runner {
    public static void main(String[] args) throws DistanceFinderException{
        Set<Point> surface = new HashSet<>();
        surface.add(new Point(0,0));
        surface.add(new Point(0,1));
        surface.add(new Point(0,5));

        DistanceFinder df = new DistanceFinder();
        Collection<Point> nearest = df.findNearest(surface);
        System.out.println(nearest);
    }
}
