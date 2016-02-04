package innoday.echostar.com.echopath;

/**
 * Class to represent a connection between two {@link Location}s
 *
 * @author Saidaiah Yechuri
 * @since 1.0
 */
public class Edge {

    public Location target;

    public double distance;

    public Edge(Location argTarget, double argDistance) {
        target = argTarget;
        distance = argDistance;
    }

    /**
     * Constructor
     */
    public Edge() {
    }
}
