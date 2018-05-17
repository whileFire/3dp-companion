import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.imageio.ImageIO;

public interface FileWrite {

	default public void writeFile(String directoryName, String fileName, String content){
		
	    String PATH = "";//this.getClass().getProtectionDomain().getCodeSource().getLocation() + "";
	    //directoryName = this.getClass().getSimpleName().concat(directoryName);

	    /*System.out.println(PATH);				// 1
	    System.out.println(directoryName);		// 2
	    System.out.println(fileName);			// 3
	     */
	    
	    File directory = new File(directoryName);
	    if (! directory.exists()){
	        directory.mkdirs();
	        // If you require it to make the entire directory path including parents,
	        // use directory.mkdirs(); here instead.
	    }
	
	    File file = new File(directoryName + "/" + fileName);
	    
	    //System.out.println(file.getAbsolutePath());		// 4
	    try{
	        FileWriter fw = new FileWriter(file.getAbsoluteFile());
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(content);
	        bw.close();
	    }
	    catch (IOException e){
	        e.printStackTrace();
	        System.exit(-1);
	    }
	}

	default public String readFile(String filePath)
	{
	    StringBuilder contentBuilder = new StringBuilder();
	    try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
	    {
	        stream.forEach(s -> contentBuilder.append(s).append("\n"));
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    String returnValue = contentBuilder.toString();
	    System.out.println("readFile has returned: " + '"' + contentBuilder.toString() + '"');
	    
	    return contentBuilder.toString();
	}
	
	default public void readBMP(String BMPFileName) throws IOException {
		System.out.println(getClass().getResource(BMPFileName));
		File imageFile = new File("C:\\Users\\Ashley\\Google Drive\\PC\\eclipse\\Printertle_0.0.1\\Projects\\Default\\image.bmp");
	    BufferedImage image = ImageIO.read(imageFile);// ImageIO.read(getClass().getResource(BMPFileName));

	    int[][] array2D = new int[image.getHeight()][image.getWidth()]; //*

	    for (int xPixel = 0; xPixel < image.getHeight(); xPixel++) //*
	    {
	        for (int yPixel = 0; yPixel < image.getWidth(); yPixel++) //*
	        {
	            int color = image.getRGB(yPixel, xPixel); //*
	            if (color==Color.BLACK.getRGB()) {
	                array2D[xPixel][yPixel] = 1;
	            } else {
	                array2D[xPixel][yPixel] = 0; // ?
	            }
	        }
	    }
	    
	    for (int x = 0; x < array2D.length; x++)
	    {
	        for (int y = 0; y < array2D[x].length; y++)
	        {
	            System.out.print(array2D[x][y]);
	        }
	        System.out.println();
	        System.out.println();
	    }
	}

	    
}
