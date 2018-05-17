import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class Application implements FileWrite{

	public Application() {
		// TODO Auto-generated constructor stub
	}
	
	
	/*
	 * Creates the Projects folder and creates a Default project inside with all requisite files
	 */
	public void initializeFolderStructure() {
		String defaultDirectory = "Projects\\Default\\";
		File directory = new File(defaultDirectory + "Layers\\");
		if (!directory.exists()){
	        directory.mkdirs();
		}
	    for(int i=1;i<=3;i++) {
		    this.writeFile(defaultDirectory + "Layers\\", i + ".txt", "000090000900009");
		}
		this.writeFile(defaultDirectory, "projectInfo.txt", "Default Project");
	
	}
	
	
	/*
	 * Run at start to find all current projects and import into listbox
	 * @return Hashmap of all projects
	 */
	public HashMap<Integer, Project> importProjects() {
		String[] projectFolders;
		int projectCount = 0;
		HashMap<Integer, Project>	projects = new HashMap<>();
		File projectsDirectory = new File("Projects\\");									//Grabs the Projects folder
		projectFolders = projectsDirectory.list();											//makes a String array of all of the subfolders in projects folder

			for (int i=0;i<projectFolders.length;i++) {										//Create File object out of each Projects subfolder to check if it's
				File fileToTest = new File("Projects\\" + projectFolders[i] + "\\");		//actually a Project
				if(verifyFolderIsProject(fileToTest)) {
					projectCount++;
					projects.put(projectCount, makeProjectObjectFromFolder(fileToTest));	//If it is a project, add it to projects HashMap to be returned
				}
			}
		return projects;
		//System.out.println(projectCount);
	}
	
	
	/*
	 * Verifies whether a subfolder in Projects folder is a real project
	 * @return true
	 */
	public static boolean verifyFolderIsProject(File inputFile) {
		boolean hasProjectInfo	=	false;
		boolean hasLayers		=	false;
		for (int i=0;i<inputFile.list().length; i++) {
			if(inputFile.list()[i].equals("projectInfo.txt")) {
				hasProjectInfo	=	true;
			}
			if(inputFile.list()[i].equals("Layers")) {
				hasLayers	=	true;
			}
		}
		return (hasProjectInfo && hasLayers);
	}
	
	
	/*
	 * Instantiate Projects
	 * @return	A project!
	 */
	public Project makeProjectObjectFromFolder(File inputFolder) {
		Project projectFromFolder = new Project(inputFolder);
		return projectFromFolder;
	}
	
	
	/*
	 * For testing how File properties display 
	 */
	public void printFileDetails(File fileToRead) {
		System.out.println("====printFileDetails start====" + fileToRead.getName());
		System.out.println("Is a directory: " + fileToRead.isDirectory());
		System.out.println("Is a file: " + fileToRead.isFile());
		System.out.println("Filepath: " + fileToRead.getPath());
		System.out.println("ToString: " + fileToRead.toString());
		System.out.println("getName: " + fileToRead.getName());
		if(fileToRead.isDirectory()) {
			System.out.println("File List: ");
			
			for (int i=0;i<fileToRead.list().length;i++) {
				System.out.println(fileToRead.list()[i]);
			}
		}
		System.out.println("getParent: " + fileToRead.getParent());
		System.out.println("getClass: " + fileToRead.getClass());
		System.out.println("====printFileDetails end====");
	}
	
	
	public static void main(String[] args) {
		
		Application a1 = new Application();
		a1.initializeFolderStructure();
		a1.importProjects();
		
		try {a1.readBMP("C:\\Users\\Ashley\\Google Drive\\PC\\eclipse\\Printertle_0.0.1\\Projects\\Default\\image.bmp");
		} catch (IOException e){
			
		} finally {
			
		}
	}

}
