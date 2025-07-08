import java.util.*;

public class FirstFit extends DiskPackingAlgorithm {
	private double diskCapacity;
	
	// Constructor to set the disk capacity
	public FirstFit(double diskCapacity) {
		this.diskCapacity = diskCapacity;
	}
	
	// Packs the files into disks using the First Fit 
	@Override
	public ArrayList<Disk> packFiles(ArrayList<File> files, ArrayList<Disk> disks) {
		// Loop through each file to be packed
		for (File file : files) {
			boolean placed = false;
			 // Try to place the file in one of the existing disks
			for (Disk disk : disks) {
				if (disk.getRemainingCapacity() >= file.getSize()) {
					disk.addFile(file);
					placed = true;
					break; // Stop after placing in the first suitable disk
				}
			}
			// Create a new disk if no disk can hold the file
			if (!placed) {
				Disk newDisk = new Disk(disks.size() + 1, diskCapacity);
				newDisk.addFile(file);
				disks.add(newDisk);
			}
		}
		return disks;
	}
	
	// Returns the name of the algorithm
	@Override
	public String getAlgorithmName() {
		return "First Fit";
	}
}


