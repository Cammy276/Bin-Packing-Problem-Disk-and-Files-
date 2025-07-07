import java.util.*;

public class Disk {
    private int id;
    private double capacity;
    private double remainingCapacity;
    private ArrayList<File> fileStored;

    // Create a new disk with given ID and capacity
    public Disk(int id, double capacity) {
        this.id = id;
        this.capacity = capacity;
        this.remainingCapacity = capacity;
        this.fileStored = new ArrayList<>();
    }
    // Get the disk ID
    public int getId() {
        return id;
    }
    // Get the total capacity of the disk
    public double getCapacity() {
        return capacity;
    }
    
    // Get how much space is left
    public double getRemainingCapacity() {
        return remainingCapacity;
    }

    // Get the list of files stored on the disk
    public ArrayList<File> getFileStored() {
        return fileStored;
    }

    // Try to add a file to the disk
    public boolean addFile(File file) {
        if (file.getSize() <= remainingCapacity) {
            fileStored.add(file); // Store the file
            remainingCapacity -= file.getSize(); // Reduce remaining space
            return true;
        }
        return false;  // Disk is full for this file
    }
    
}
