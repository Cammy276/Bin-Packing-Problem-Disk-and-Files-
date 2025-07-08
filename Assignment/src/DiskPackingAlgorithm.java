import java.util.*;

public abstract class DiskPackingAlgorithm implements Packable {
	// Defines how files should be packed into disks
	public abstract ArrayList<Disk> packFiles(ArrayList<File> files, ArrayList<Disk> disks);
	// Returns the name of the algorithm
	public abstract String getAlgorithmName();
    
	// Displays the result of the disk packing process
    public void printPackingResult(ArrayList<Disk> disksNeeded) {
        System.out.println("Algorithm: " + getAlgorithmName());
        System.out.println("Number of disks used: " + disksNeeded.size());
       
        // Shows how many files are stored in each disk
        for (Disk disk : disksNeeded) {
            System.out.println("Disk " + disk.getId() + ": " + disk.getFileStored().size() + " Files Stored");
        }
        
        // Prints detailed information for each disk
        System.out.println("\nDetailed Disk Contents:");
        for (Disk d : disksNeeded) {
            System.out.print("Disk " + d.getId()
                             + " [Maximum Capacity=" + d.getCapacity()
                             + ", Remaining Capacity=" + String.format("%.2f", d.getRemainingCapacity())
                             + "]");
            System.out.println();
            // Lists all file IDs stored on this disk
            for (File f : d.getFileStored()) {
                System.out.print(f.getId() + " "); 
            }
            System.out.println();
            
        }      
    }
}
