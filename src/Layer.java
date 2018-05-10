/**
 * 
 */

/**
 * @author Ashley
 *
 */
public class Layer {

	private	int		layerNumber;
	private	String	layerData;

	private	int			length;
	private	int			width;
	
	
	/**
	 * 
	 */
	public Layer(int 	layerNumber,
				 String	layerData,
				 int		length,
				 int		width) {
		this.setLayerNumber(layerNumber);
		this.setLayerData(layerData);
		this.setLength(length);
		this.setWidth(width);
	}
	
	
	/**
	 * @return the layerNumber
	 */
	public int getLayerNumber() {
		return layerNumber;
	}
	
	
	/**
	 * @param layerNumber the layerNumber to set
	 */
	public void setLayerNumber(int layerNumber) {
		this.layerNumber = layerNumber;
	}
	
	
	/**
	 * @return the layerData
	 */
	public String getLayerData() {
		return layerData;
	}
	
	
	/**
	 * @param layerData the layerData to set
	 */
	public void setLayerData(String layerData) {
		this.layerData = layerData;
	}
	
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}


	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}


	/**
	 * @return the height
	 */
	public int getLength() {
		return length;
	}


	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

}
