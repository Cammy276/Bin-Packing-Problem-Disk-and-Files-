import java.util.*;

public class BestFitDecreasing extends BestFit {

	// Constructor that calls the superclass constructor to set disk capacity
    public BestFitDecreasing(double diskCapacity) {
        super(diskCapacity);
    }

    @Override
    public String getAlgorithmName() {
        return "Best Fit Decreasing";   // Returns the name of the algorithm
    }

    // Packs the files using Best Fit Decreasing
    @Override
    public ArrayList<Disk> packFiles(ArrayList<File> files, ArrayList<Disk> disks) {
    	// Create a new ArrayList to sort the files
    	ArrayList<File> sortedFiles = new ArrayList<>();
    	sortedFiles.addAll(files);
    	
    	// Sort files in descending order based on size
        Collections.sort(sortedFiles, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                return Double.compare(f2.getSize(), f1.getSize()); 
            }
        });
        
        // Call the BestFit logic in the parent class
        return super.packFiles(sortedFiles, disks);
    }
}
