package pl.com.wwa5.java;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DistanceFinderOptimized {
    public Collection<Point> findNearest(Collection<Point> surface) throws DistanceFinderException{
        return finderMin(surface, new FinderMin());
    }

    public Collection<Point> findFarthest(Set<Point> surface) throws DistanceFinderException{
        return finderMax(surface, new FinderMax());
    }

    private Collection<Point> finderMax(Collection<Point> surface, Finder finder) throws DistanceFinderException{
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
                if (p2.getX() >= 100 && p2.getX()<= 900 && p2.getY() >= 100 && p2.getY()<= 900 &&
                        p1.getX() >= 100 && p1.getX()<= 900 && p1.getY() >= 100 && p1.getY()<= 900) {
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

    private Collection<Point> finderMin(Collection<Point> surface, Finder finder) throws DistanceFinderException{
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
                if (Math.abs(p1.getX()-p2.getX()) >= 50 && Math.abs(p1.getY()-p2.getY()) >=50) {
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
