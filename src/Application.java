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
	
	public HashMap<Integer, Project> importProjects() {
		String[] projectFolders;
		int projectCount = 0;
		HashMap<Integer, Project>	projects = new HashMap<>();
		File projectsDirectory = new File("Projects\\");
		projectFolders = projectsDirectory.list();
		//System.out.println(projectFolders.length);
			for (int i=0;i<projectFolders.length;i++) {
				File fileToTest = new File("Projects\\" + projectFolders[i] + "\\");
				if(verifyFolderIsProject(fileToTest)) {
					projectCount++;
					projects.put(projectCount, makeProjectObjectFromFolder(fileToTest));
				}
			}
		return projects;
		//System.out.println(projectCount);
	}
	
	
	public Project makeProjectObjectFromFolder(File inputFolder) {
		Project projectFromFolder = new Project(inputFolder);
			//Now make a project object out of that folder. o.o jeeze this is going well
		return projectFromFolder;
	}
	
	
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
	
	
	public void readFolderStructure()	{

		File rootDirectory = new File(".");
		File projectsDirectory = new File("Projects\\");
		//File projectsDirectory = new File("Projects\\Default\\projectInfo.txt");

		//printFileDetails(rootDirectory);
		//printFileDetails(projectsDirectory);
		
	}
	
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
	
	public void readTest() {
		String imageFile = readFile("image.png");
		System.out.println(imageFile);
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
