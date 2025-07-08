import java.util.*;


public class BestFit extends DiskPackingAlgorithm {
	private double diskCapacity;

	// Constructor to set the disk capacity
    public BestFit(double diskCapacity) {
        this.diskCapacity = diskCapacity;
    }
    
    @Override
    public String getAlgorithmName() {
        return "Best Fit";
    }

    // Packs the files into disks using the Best Fit 
    @Override
    public ArrayList<Disk> packFiles(ArrayList<File> files, ArrayList<Disk> disks) {
    	// Loop through each file to be packed
        for (File f : files) {
        	
            Disk best = null;  // Best disk found for the current file
            double bestRem = Double.MAX_VALUE; // Smallest remaining space found so far
            
            
         // Search the disk with the least remaining space that can still fit the file size
            for (Disk d : disks) {
                double rem = d.getRemainingCapacity();
                if (rem >= f.getSize() && rem < bestRem) {
                    bestRem = rem;
                    best = d;
                }
            }
         // Place the file in the best disk found or create a new disk if none of it can fit
            if (best != null) {
                best.addFile(f);
            } else {
            	Disk newDisk = new Disk(disks.size() + 1, diskCapacity);
                newDisk.addFile(f);          
                disks.add(newDisk);
            }
        }
        return disks;  // Return the updated list of disks with files packed
    }
}
