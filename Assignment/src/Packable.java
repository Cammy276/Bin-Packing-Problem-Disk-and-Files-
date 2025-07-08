import java.util.*;

public interface Packable {
	// Method to pack files into disks
    ArrayList<Disk> packFiles(ArrayList<File> files, ArrayList<Disk> disks);
}

