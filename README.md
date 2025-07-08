# Bin Packing Problem of Disk File Allocation

Assignment for UECS2453 Problem Solving with Data Structures and Algorithms

This repository presents a bin packing problem study of disk file allocation to evaluate and compare the efficiency of different algorithm by using Big O notation. These algorithms are implemented in Java and designed using an object-oriented approach to ensure the program is flexible and maintainable. 

## Objective
The main objective is to study the time complexity to evaluate the efficiency of Best Fit, Best Fit Decreasing, First Fit, and First Fit Decreasing algorithms by using Big O notation in the worst case. Each algorithm applies a different method for placing files into disks based on file sizes and the remaining capacities of the disks to minimize the number of disks used while ensuring all files are successfully stored. The effectiveness of each algorithm is evaluated based on its time complexity, providing a clear comparison of its performance with other algorithms.

## Technology Used
|Tool|Description|
|---|---|
|Eclipse|For running Java code|
|Java (JDK22)|Programming language used for developing algorithms|

## Algorithms Used
1. Best Fit
2. Best Fit Decreasing
3. First Fit
4. First Fit Decreasing

## Methodology
1. Defining problem
2. Stating assumptions
3. Designing overall system architecture and UML diagram
4. Designing flow chart for each algorithm
5. Preparing testing data file (files.txt)
6. Developing instruction code in Java
7. Efficiency evaluation by Big O notation

## Assumptions
1. All the disks are assumed to be set in the same capacity in double type through the user input in the program. The input is validated to ensure it is numerical and at least as large as the largest file size, preventing placement issues.
2. The number of disks is set in int type as a constant at the top of the main program.
3. The size of the files and capacity of the disks are assumed to be in the unit of Gigabytes (GB).
4. All the files should have four attributes, which are the file ID in int type, file name in String type, file size in double type, and file type in String type. Any modifications of the files such as insertion of new files, deletion and edit of the current files should be done in the “files.txt” text file.
5. The files information does not include the quantities of the files since we assume that all file has a unique file name and unique ID. This stimulates the real-world application, which normally our computers do not allow us to create files with the same name under one same directory.
6. Each record in the “files.txt” is assumed to represent a file, not representing any folders or a mixture of folders and files.
7. The disk information, such as the disk ID, disk capacity, disk’s remaining capacity, and files stored in the disk, are assumed to be unmodifiable manually since it is a one-time program.

## Overall System Architecture
The system uses an object-oriented approach with a clear separation between file management and packing algorithms. The flexibility of this architecture is high, allowing it to support different packing algorithms to optimize disk utilization.
### Main class (UECS2453_Assignment_G11.java)
This class serves as the main class and the primary entry point of the entire program. It is responsible for handling user input, particularly the disk capacity, managing the logical flow of the program, and executing different disk packing algorithms which are the Best Fit, Best Fit Decreasing, First Fit, and First Fit Decreasing algorithms. It reads the input file (files.txt), creates file objects, and initializes instances of the packing algorithm classes. Once the files are processed and packed into disks, the printPackingResult() method is executed to display the output report, which shows the number of disks used and the specific files stored in each disk.
### Packable interface (Packable.java)
The Packable interface sets a rule that all disk packing algorithm classes must follow. It includes a method called packFiles(ArrayList<File> files, ArrayList<Disk> disks), which each implementing class must define. This ensures that each algorithm has its own way of packing files into disks. By using this interface, the program can handle all algorithms in the same way, even if they work differently inside. This makes the program more flexible and easier to maintain, as the main class can use any algorithm without needing to understand its internal workings.
### DiskPackingAlgorithm abstract class: (DiskPackingAlgorithm.java)
This class is an abstract class that defines the common structure and behavior used by all packing algorithm classes, such as the Best Fit class, Best Fit Decreasing class, First Fit class, and First Fit Decreasing class. It declares an abstract method, packFiles(), which takes a list of files and disks and is intended to be implemented by concrete subclasses to determine how files should be packed into disks. Additionally, the class includes another abstract method, getAlgorithmName(), in which each subclass must implement to return a string representing the name of the packing algorithm used. Since multiple packing algorithms are implemented, this method helps distinguish their results in the output report. Furthermore, the class provides a method called printPackingResult(), which prints the results of the disk packing process. It displays the algorithm name, the number of disks used, and detailed information about each disk, including the disk ID, the number of files stored, file identifiers, maximum capacity, and remaining capacity. This method helps visualize the packing process results for each algorithm and ensures consistency in the output.
### Best Fit class (BestFit.java)
The BestFit class implements the Packable interface and inherits from DiskPackingAlgorithm. It follows the Best Fit strategy to pack files, where each file is placed into the disk with the least remaining space that can still accommodate the file. If no existing disk can store the file, a new disk is created. This method helps minimize wasted space and allocates disk space efficiently.
### Best Fit Decreasing class (BestFitDecreasing.java)
The BestFitDecreasing class is a subclass of BestFit class, which improves upon the Best Fit strategy by first sorting the files in descending order based on their size before packing. This allows larger files to be placed earlier when more space is available, helping to reduce fragmentation and space inefficiency. After sorting, it applies the same logic as the Best Fit algorithm. This approach can result in better packing and fewer disks used, making it an optimized version of Best Fit. 
### First Fit class (FirstFit.java)
The FirstFit class implements the Packable interface and inherits from DiskPackingAlgorithm. It follows the First Fit strategy to pack files using a simple approach. It goes through each file and places it in the first disk that has enough space. If no existing disk can store the file, a new disk is created. While the First Fit strategy is not as space efficient as the Best Fit strategy, it is faster because it eliminates the need to search for the disk with the least remaining capacity. This method is suitable for scenarios where performance is prioritized over optimization. 
### First Fit Decreasing class (FirstFitDecreasing.java)
The FirstFitDecreasing class is a subclass of FirstFit class, which improves upon the First Fit strategy by first sorting the files in descending order based on their size before packing. This allows larger files to be placed earlier when more space is available, helping to reduce the risk of leaving small gaps that cannot accommodate larger files later. After sorting, it applies the same logic as the First Fit algorithm. This approach can result in fewer disks being used, making it an optimized version of First Fit. 
### File class (File.java)
This class encapsulates the properties of a file to be stored. Each file object stores information such as the file ID, file name, file size (measured in Gigabytes (GB)), and file type. The class includes getter methods to retrieve these attributes. Besides, it overrides the toString() method to allow a formatted display of file information.
### Disk class (Disk.java)
This class represents a single disk with a fixed storage capacity, which the user is prompted to enter. Each Disk object is initialized with a unique ID a, a specified capacity, an initial remainingCapacity that is set to be the same as the capacity, and an empty ArrayList for the fileStored. The fileStored is used to store all files that will be placed on the disk. It also provides getter methods to retrieve the disk’s ID, total capacity, remaining capacity, and the list of stored files. The method addFile(File file) is used to check whether the file size is less than or equal to the disk’s remaining capacity. If the file fits, it is added to the disk, and the remaining capacity is updated accordingly. This helps ensure efficient disk usage without exceeding the capacity limit.

## Data Structures Selection
To store and manage data in our program, two main data structures, which are the ArrayList of File objects (ArrayList<File>) and ArrayList of Disk objects(ArrayList<Disk>), are used. Both are part of the Java Collection Framework and able to easy to add or remove items when needed as it provides a dynamic storage. The ArrayList helps manage the collection of files that need to be stored and the disks used to store them, making the data handling flexible and efficient.
### ArrayList of File Objects (ArrayList<File>)
This structure is used to store all the file objects that need to be packed into disks. Each file is represented by a File object, which stores information such as ID, name, size, and file type. These file objects are created when data is read from the input file (files.txt), in the main class (UECS2453_Assignment_G11.java). After creation, they are added one by one into an ArrayList<File>. Overall, using an ArrayList keeps the file organized and manageable in one place. Its combination of benefits of automatic resizing, efficient traversal, sorting, and fast indexed access make it easier and more flexible to apply different packing algorithms to the same set of files.
### ArrayList of Disk Objects (ArrayList<Disk>)
This structure is used to store all the disk objects created during the packing process. Each disk is represented by a Disk object, which stores information such as ID, total capacity, remaining capacity, and the list of files stored on the disk. These disk objects are created as needed during the file packing process and are then added one by one into an ArrayList<Disk>. Overall, using ArrayList is a practical choice which strikes a good balance between performance and flexibility to keep all the disks organized in one place dynamically. Its combination of automatic resizing, efficient appending, iteration, and quick random access via indexing make it easier to manage the packing process and generate a clear output report for each algorithm.

## Conclusion
All the Best Fit, Best Fit Decreasing, First Fit, and First Fit Decreasing algorithms have the same time complexity of O(n²) under the worst-case scenario if they share the same operations apart from the logic of the packing process. Although the Best Fit Decreasing and First Fit Decreasing algorithms include an additional sorting step to sort the file in descending order based on file size, which has a time complexity of O(n log n), the subsequent packing operation of O(n²) will dominate the overall performance of this program. This shows that if the number of input files increases, the time taken to process the bin packing operation for all these algorithms will increase by quadratic time. 

## Authors
- [@Yu-2008] (https://github.com/Yu-2008)
- [@Cammy276] (https://github.com/Cammy276)
- [@LIOWKEHAN] (https://github.com/LIOWKEHAN)
- [@Jacqueline-Lim] (https://github.com/Jacqueline-Lim)

## Contributing

Contributions are always welcome!

To get started:

1. **Fork** the repository to your GitHub account.
2. **Create a new branch** for your feature or fix:  
   `git checkout -b your-feature-name`
3. **Make your changes** and commit them with a clear message:  
   `git commit -m "Add: Description of your change"`
4. **Push** your branch to your forked repository:  
   `git push origin your-feature-name`
5. **Open a Pull Request** from your branch to the main project.

Feel free to open an issue first if you'd like to discuss your idea before implementing it.

