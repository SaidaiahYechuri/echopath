package innoday.echostar.com.echopath;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yechsai
 *
 */
public class TempShortestPath {

	private double totalDistance;
	
	private ArrayList<EdgeDTO> edgeDTOs = new ArrayList<EdgeDTO>();

	/**
	 * Get the value of totalDistance of this TempShortestPath	
	 * @return the totalDistance
	 */
	public double getTotalDistance() {
		return totalDistance;
	}

	/**
	 * Set value of totalDistance  
	 * @param totalDistance the totalDistance to set
	 */
	public void setTotalDistance(double totalDistance) {
		this.totalDistance = totalDistance;
	}

	/**
	 * Get the value of edgeDTOs of this TempShortestPath	
	 * @return the edgeDTOs
	 */
	public ArrayList<EdgeDTO> getEdgeDTOs() {
		return edgeDTOs;
	}

	/**
	 * Set value of edgeDTOs  
	 * @param edgeDTOs the edgeDTOs to set
	 */
	public void setEdgeDTOs(ArrayList<EdgeDTO> edgeDTOs) {
		this.edgeDTOs = edgeDTOs;
	}
}
