import java.io.File;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class Project implements FileWrite {
	
	private HashMap<Integer, Layer>		layers;
	private	ImageIcon					projectPicture;
	private	String						projectName;
	
	

	public Project (HashMap<Integer, Layer>	layers,
							 String		projectName) {
		//this.setLayers();
		this.setProjectName(projectName);
	}
		
	public Project(File inputFolder) {
		
		File projectData = new File(inputFolder.toString() + "\\projectInfo.txt");
		String projectDataString = projectData.toString();
		
		projectDataString = readFile(projectData.getPath());
		
		this.setProjectName(projectDataString);
		this.setLayers(inputFolder);
		this.setProjectPicture(inputFolder);

		System.out.println(this.getProjectName());
		System.out.println("Width: " + layers.get(1).getWidth());
		System.out.println("Length: " + layers.get(1).getLength());
		System.out.println("Height: " + layers.size());
		System.out.println("Layers: " + this.getLayers());
		
	}
	
	
	/**
	 * Proper image size:		229x200
	 * Filetype:				PNG
	 * 
	 * @param inputFolder
	 */
	public void setProjectPicture(File inputFolder) {
		ImageIcon icon = new ImageIcon(inputFolder.toString() + "\\image.png", "");
		this.projectPicture = icon;
	}

	
	public ImageIcon getProjectPicture() {
		return this.projectPicture;
	}
	
	
	/**
	 * @return the layers
	 */
	public HashMap<Integer, Layer> getLayers() {
		return layers;
	}


	/**
	 * @param layers the layers to set
	 */
	public void setLayers(File projectFolder) {
		File layerFolder = new File(projectFolder.getPath() + "\\Layers");
		String[] layerFiles = layerFolder.list();
		int layerCount = 0;
		int layerLength = 0;
		int layerWidth = 0;
		
		//Check Layers folder for txt files
		for (int i=0;i<layerFiles.length;i++) {
			if(layerFiles[i].substring(layerFiles[i].length() - 3).equals("txt")) {
				layerCount++;
			}
		}
		
		String layerText = readFile(layerFolder.getPath() + "\\1.txt");
		char[] layerTextChars = layerText.toCharArray();
		for (int i=0; i<layerTextChars.length; i++) {
			if(layerTextChars[i] == '9') {
				layerLength++;
			}
		}
		layerWidth = layerText.indexOf("9");
		
		//If no txt files, check for BMPs
		if (layerCount == 0) {
			for (int i=0;i<layerFiles.length;i++) {
				if(layerFiles[i].substring(layerFiles[i].length() - 3).equals("bmp")) {
					layerCount++;
				}
			}
		}
		
		HashMap<Integer, Layer> projectLayers = new HashMap<>();
		
		for(int i=0;i<layerCount;i++) {
			layerText = readFile(layerFolder.getPath() + "\\" + (i+1) + ".txt");
			Layer l1 = new Layer(i, layerText, layerLength, layerWidth);
			projectLayers.put(i, l1);
		}
		
		this.layers = projectLayers;
	}


	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}


	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	

	
}
