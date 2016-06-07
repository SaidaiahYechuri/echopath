package innoday.echostar.com.echopath;

/**
 * @author yechsai
 *
 */
public class EdgeDTO {

	private String from;
	
	private String to; 
	
	private double distance;
	
	private String face;

	/**
	 * Constructor
	 */
	public EdgeDTO(String from, String to, double distance, String face) {
		super();
		this.from = from;
		this.to = to;
		this.distance = distance;
		this.face = face;
	}

	public EdgeDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Get the value of from of this EdgeDTO	
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * Set value of from  
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * Get the value of to of this EdgeDTO	
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * Set value of to  
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * Get the value of distance of this EdgeDTO	
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * Set value of distance  
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 * Get the value of face of this EdgeDTO	
	 * @return the face
	 */
	public String getFace() {
		return face;
	}

	/**
	 * Set value of face  
	 * @param face the face to set
	 */
	public void setFace(String face) {
		this.face = face;
	} 
}