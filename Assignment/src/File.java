
public class File {
	private int id;
    private String name;
    private double size;
    private String type;

    // Creates a new file with ID, name, size, and type
    public File(int id,String name, double size, String type) {
    	this.id = id;
        this.name = name;
        this.size = size;
        this.type = type;
    }
    // Gets the file ID
    public int getId() {
        return id;
    }

    // Gets the file name
    public String getName() {
        return name;
    }

    // Gets the file size
    public double getSize() {
        return size;
    }

    // Gets the file type
    public String getType() {
        return type;
    }

    // Gets a string that shows the details of the file
    @Override
    public String toString() {
        return "File{" + 
        		"id=" + id +
                ", name=" + name +
                ", size=" + size +
                ", type=" + type +
                '}';
    }
}
