import java.io.*;
import java.util.*;

public class UECS2453_Assignment_G11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // set initial disks and capacity
        final int diskCount = 5;
        double capacity = 0;

        //read files from files.txt
        ArrayList<File> files = new ArrayList<>();
        readFiles(files); 
        
        // If no files are read, display an error message and exit
        if (files.isEmpty()) {
			System.err.println("No files to process. Exiting.");
			sc.close();
			return;
		}
        
        double maxFileSize = getMaxFileSize(files);  // Get max size before asking user

        boolean isValid = false;
        // Loop until a valid disk capacity is entered
        while (!isValid) {
        	try {
        		System.out.print("Enter capacity of each disk: ");
                capacity = Double.parseDouble(sc.nextLine()); 
                // Ensure disk capacity is large enough to fit the largest file
                if (capacity < maxFileSize) {
                    throw new IllegalArgumentException("Disk capacity too small. The minimum size of capacity must be at least " + maxFileSize + ".\n");
                } else {
                isValid = true;}
        	} catch (NumberFormatException e) {
        		System.err.println("Invalid input for disk capacity. Please enter a positive number.\n");
        	} catch (IllegalArgumentException e){
        		 System.err.println("Error: " + e.getMessage());
        	} catch (Exception e) {
        	    System.err.println("An unexpected error occurred: " + e.getMessage());
        	}
        }

        sc.close();

        // create disks
        ArrayList<Disk> initialDisks = new ArrayList<>();
        for (int i = 1; i <= diskCount; i++) {
            initialDisks.add(new Disk(i, capacity));
        }

        // Implementing Best-Fit 
        BestFit bestFit = new BestFit(capacity);
        ArrayList<Disk> usedByBF = bestFit.packFiles(files, cloneDisks(initialDisks));
        System.out.println("=================================================================================");
        bestFit.printPackingResult(usedByBF);

        // Implementing Best-Fit Decreasing
        BestFitDecreasing bestFitDec = new BestFitDecreasing(capacity);
        ArrayList<Disk> usedByBFD = bestFitDec.packFiles(files, cloneDisks(initialDisks));
        System.out.println("=================================================================================");
        bestFitDec.printPackingResult(usedByBFD);

        // Implementing First-Fit 
        FirstFit firstFit = new FirstFit(capacity);
        ArrayList<Disk> usedByFF = firstFit.packFiles(files, cloneDisks(initialDisks));
        System.out.println("=================================================================================");
        firstFit.printPackingResult(usedByFF);
        
        // Implementing First-Fit Decreasing
        FirstFitDecreasing firstFitDec = new FirstFitDecreasing(capacity);
        ArrayList<Disk> usedByFFD = firstFitDec.packFiles(files, cloneDisks(initialDisks));
        System.out.println("=================================================================================");
        firstFitDec.printPackingResult(usedByFFD);

    }

    // Reads files from "files.txt" 
    public static void readFiles(ArrayList<File> files) {
        try (BufferedReader br = new BufferedReader(new FileReader("files.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double size = Double.parseDouble(parts[2].trim());
                    String type = parts[3].trim();
                    files.add(new File(id, name, size, type));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading files.txt: " + e.getMessage());
            System.exit(1);
        }
    }

    //Creates a copy of the disks so each algorithm can work with a clean set
    private static ArrayList<Disk> cloneDisks(ArrayList<Disk> disks) {
        ArrayList<Disk> copy = new ArrayList<>();
        for (Disk d : disks) {
            copy.add(new Disk(d.getId(), d.getCapacity()));
        }
        return copy;
    }
    // Gets the size of the largest file
    public static double getMaxFileSize(ArrayList<File> files) {
        double maxSize = 0;
        for (File f : files) {
            if (f.getSize() > maxSize) {
                maxSize = f.getSize();
            }
        }
        return maxSize;
    }

    
}
