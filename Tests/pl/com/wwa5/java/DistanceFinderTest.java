package pl.com.wwa5.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.*;

public class DistanceFinderTest {
    @Test
    public void findNearest() throws Exception, DistanceFinderException {
        Set<Point> surface = new HashSet<>();
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        Point p3 = new Point(0, 5);
        surface.add(p1);
        surface.add(p2);
        surface.add(p3);

        DistanceFinder df = new DistanceFinder();
        Collection<Point> nearest = df.findNearest(surface);
        Assert.assertTrue(nearest.contains(p1));
        Assert.assertTrue(nearest.contains(p2));
        Assert.assertTrue(nearest.size() == 2);
    }

    @Test
    public void findFarthest() throws Exception, DistanceFinderException {
        Set<Point> surface = new HashSet<>();
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        Point p3 = new Point(0, 5);
        surface.add(p1);
        surface.add(p2);
        surface.add(p3);

        DistanceFinder df = new DistanceFinder();
        Collection<Point> farthest = df.findFarthest(surface);
        System.out.println(farthest);
        Assert.assertTrue(farthest.size() == 2);
        Assert.assertTrue(farthest.contains(p1));
        Assert.assertTrue(farthest.contains(p3));
    }

    @Test(expected = DistanceFinderException.class)
    public void testEmptySurface() throws Exception, DistanceFinderException {
        Set<Point> surface = new HashSet<>();
        DistanceFinder df = new DistanceFinder();
        Collection<Point> nearest = df.findNearest(surface);
    }

    @Test
    public void testEmptySurface2() throws Exception {
        Set<Point> surface = new HashSet<>();
        DistanceFinder df = new DistanceFinder();
        boolean exceptionOccured = false;
        try {
            Collection<Point> nearest = df.findNearest(surface);
            Assert.fail("Nie moge tu wejsc");
        } catch (DistanceFinderException e) {
            exceptionOccured = true;
        }
        Assert.assertTrue(exceptionOccured);
    }

    @Test
    public void test10000Nearest() throws DistanceFinderException{
        Set<Point> surface = new HashSet<>();
        Random r = new Random();
        for(int i = 0; i< 10000; i ++){
            surface.add(new Point(100 + (r.nextInt(1000) * 10),
                    100 + (r.nextInt(1000) * 10)));
        }
        Point p1 = new Point(0,0);
        surface.add(p1);
        Point p2 = new Point(0,1);
        surface.add(p2);
        DistanceFinder df = new DistanceFinder();
        Collection<Point> nearest = df.findNearest(surface);
        Assert.assertEquals(nearest.size(), 2);
        Assert.assertTrue(nearest.contains(p1));
        Assert.assertTrue(nearest.contains(p2));
    }

    @Test
    public void test10000Farthest() throws DistanceFinderException{
        Set<Point> surface = new HashSet<>();
        Random r = new Random();
        for(int i = 0; i< 10000; i ++){
            surface.add(new Point(100 + (r.nextInt(1000) * 10),
                    100 + (r.nextInt(1000) * 10)));
        }
        Point p1 = new Point(0,0);
        surface.add(p1);
        Point p2 = new Point(0,1);
        surface.add(p2);
        DistanceFinder df = new DistanceFinder();
        Collection<Point> farthest = df.findFarthest(surface);
    }

    @Test
    public void test10000FarthestOptimized() throws DistanceFinderException{
        Set<Point> surface = new HashSet<>();
        Random r = new Random();
        for(int i = 0; i< 10000; i ++){
            int korX = (int)Math.random() * 1000;
            int korY = (int)Math.random() * 1000;
            surface.add(new Point(korX,korY));
        }
        Point p1 = new Point(0,0);
        surface.add(p1);
        Point p2 = new Point(0,1);
        surface.add(p2);
        DistanceFinderOptimized df = new DistanceFinderOptimized();
        Collection<Point> farthest = df.findFarthest(surface);
    }

    @Test
    public void test10000NearestOptimized() throws DistanceFinderException{
        Set<Point> surface = new HashSet<>();
        Random r = new Random();
        for(int i = 0; i< 10000; i ++){
            int korX = (int)Math.random() * 1000;
            int korY = (int)Math.random() * 1000;
            surface.add(new Point(korX,korY));
        }
        Point p1 = new Point(0,0);
        surface.add(p1);
        Point p2 = new Point(0,1);
        surface.add(p2);
        DistanceFinderOptimized df = new DistanceFinderOptimized();
        Collection<Point> nearest = df.findNearest(surface);

    }
}