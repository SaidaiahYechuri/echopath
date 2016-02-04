package innoday.echostar.com.echopath;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saidaiah.yechuri on 1/31/16.
 */
public class ShortestPathDTO {

    private double minDistance = Double.POSITIVE_INFINITY;

    private List<Location> locations = new ArrayList<Location>();

    /**
     * Constructor
     */
    public ShortestPathDTO(double minDistance, List<Location> locations) {
        super();
        this.minDistance = minDistance;
        this.locations = locations;
    }

    /**
     * Constructor
     */
    public ShortestPathDTO() {
    }

    /**
     * Get the value of minDistance of this ShortestPathDTO
     * @return the minDistance
     */
    public double getMinDistance() {
        return minDistance;
    }

    /**
     * Set value of minDistance
     * @param minDistance the minDistance to set
     */
    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    /**
     * Get the value of locations of this ShortestPathDTO
     * @return the locations
     */
    public List<Location> getLocations() {
        return locations;
    }

    /**
     * Set value of locations
     * @param locations the locations to set
     */
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    /*
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "ShortestPathDTO [minDistance=" + minDistance + ", locations="
                + locations + "]";
    }
}
