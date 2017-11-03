package pl.com.wwa5.java;

public class FinderMin extends Finder {
    @Override
    public boolean isBoundary(double currentDistance, double boundaryDistance) {
        return currentDistance <= boundaryDistance;
    }
}
