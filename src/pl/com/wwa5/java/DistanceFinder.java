package pl.com.wwa5.java;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DistanceFinder {
    public Collection<Point> findNearest(Collection<Point> surface) throws DistanceFinderException{
        return finder(surface, new FinderMin());
    }

    public Collection<Point> findFarthest(Set<Point> surface) throws DistanceFinderException{
        return finder(surface, new FinderMax());
    }

    private Collection<Point> finder(Collection<Point> surface, Finder finder) throws DistanceFinderException{
        if(surface == null || surface.isEmpty()){
            throw new DistanceFinderException();
        }
        Set<Point> found = new HashSet<>();

        double boundaryDistance = -1;
        Point boundaryP1 = null;
        Point boundaryP2 = null;

        for(Point p1 : surface){
            for(Point p2 : surface){
                if(p1.equals(p2)){
                    continue;
                }
                double currentDistance = p1.distance(p2);
                if(boundaryDistance == -1){
                    boundaryDistance = currentDistance;
                }
                if(finder.isBoundary(currentDistance, boundaryDistance)){
                    boundaryDistance = currentDistance;
                    boundaryP1 = p1;
                    boundaryP2 = p2;
                }
            }
        }
        found.add(boundaryP1);
        found.add(boundaryP2);
        return found;
    }
}
