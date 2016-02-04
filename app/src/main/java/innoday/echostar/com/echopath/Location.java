package innoday.echostar.com.echopath;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Class to represent location information.
 * 
 * @author Saidaiah Yechuri
 * @since 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Location implements Comparable<Location>{

    private int id;

    private String name;

    private Set<Coordinate> coordinates = new HashSet<Coordinate>();

    private Set<Location> connectedLocations = new HashSet<Location>();

    private Location previous;

    private double minDistance = Double.POSITIVE_INFINITY;

    private List<Edge> adjacencies = new ArrayList<Edge>();

    private Direction face;

    /**
     * Empty Constructor
     */
    public Location() {
        super();
    }

    /**
     * Constructor
     */
    public Location(int id, String name, Set<Coordinate> coordinates,
                    Set<Location> connectedLocations) {
        super();
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.connectedLocations = connectedLocations;
    }

    /**
     * Get the value of face of this Location
     * @return the face
     */
    public Direction getFace() {
        return face;
    }

    /**
     * Set value of face
     *
     * @param face
     *            the face to set
     */
    public void setFace(Direction face) {
        this.face = face;
    }

    /**
     * Get the value of adjacencies of this Location
     * @return the adjacencies
     */
    public List<Edge> getAdjacencies() {
        return adjacencies;
    }

    /**
     * Set value of adjacencies
     * @param adjacencies the adjacencies to set
     */
    public void setAdjacencies(List<Edge> adjacencies) {
        this.adjacencies = adjacencies;
    }

    /**
     * Get the value of minDistance of this Location
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
     * Get the value of previous of this Location
     * @return the previous
     */
    public Location getPrevious() {
        return previous;
    }

    /**
     * Set value of previous
     * @param previous the previous to set
     */
    public void setPrevious(Location previous) {
        this.previous = previous;
    }

    /**
     * Get the value of id of this Location
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set value of id
     *
     * @param id
     *            the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the value of name of this Location
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set value of name
     *
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of coordinates of this Location
     *
     * @return the coordinates
     */
    public Set<Coordinate> getCoordinates() {
        return coordinates;
    }

    /**
     * Set value of coordinates
     *
     * @param coordinates
     *            the coordinates to set
     */
    public void setCoordinates(Set<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Get the value of connectedLocations of this Location
     *
     * @return the connectedLocations
     */
    public Set<Location> getConnectedLocations() {
        return connectedLocations;
    }

    /**
     * Set value of connectedLocations
     *
     * @param connectedLocations
     *            the connectedLocations to set
     */
    public void setConnectedLocations(Set<Location> connectedLocations) {
        this.connectedLocations = connectedLocations;
    }

    /*
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((coordinates == null) ? 0 : coordinates.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /*
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Location other = (Location) obj;
        if (coordinates == null) {
            if (other.coordinates != null)
                return false;
        } else if (!coordinates.equals(other.coordinates))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    /*
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return getName();
    }

    /*
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Location o) {
        return Double.compare(minDistance, o.minDistance);
    }
}
