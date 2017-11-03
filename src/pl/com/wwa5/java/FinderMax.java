package pl.com.wwa5.java;

public class FinderMax extends Finder {
    @Override
    public boolean isBoundary(double currentDistance, double boundaryDistance) {
        return currentDistance >= boundaryDistance;
    }
}
