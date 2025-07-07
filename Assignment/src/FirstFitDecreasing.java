
import java.util.*;

public class FirstFitDecreasing extends FirstFit {
	
	// Constructor that calls the superclass constructor to set disk capacity
	public FirstFitDecreasing(double diskCapacity) {
		super(diskCapacity);
	}
	
	// Sorts files from largest to smallest, then applies First Fit
	@Override
	public ArrayList<Disk> packFiles(ArrayList<File> files, ArrayList<Disk> disks) {
		ArrayList<File> sortedFiles = new ArrayList<>();
    	sortedFiles.addAll(files);
    	
    	// Sort files in decreasing order by size
		Collections.sort(sortedFiles, new Comparator<File>() {
			@Override
			public int compare(File f1, File f2) {
				return Double.compare(f2.getSize(), f1.getSize());
			}
		});
		
		// Call the FirstFit logic in the parent class
		return super.packFiles(sortedFiles, disks);
	}

	@Override
	public String getAlgorithmName() {
		return "First Fit Decreasing";
	}
	
}

