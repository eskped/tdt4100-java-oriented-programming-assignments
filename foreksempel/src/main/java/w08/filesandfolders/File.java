package w08.filesandfolders;

public class File {
	private String name;
	private Folder parent;

	public File(String name, Folder parent) {
		setName(name);
		move(parent);
	}

	public void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException("Name cannot be null.");
		if (name.isBlank())
			throw new IllegalArgumentException("Name cannot be of zero length.");
		this.name = name.trim();
	}

	public String getName() {
		return name;
	}

	public Folder getParent() {
		return parent;
	}

	public void move(Folder destination) {
		if (destination == null)
			throw new IllegalArgumentException("Can't move file to 'null'");
		if (parent != null)
			parent.deleteFile(this);
		parent = destination;
		parent.addFile(this);
	}

	@Override
	public String toString() {
		return parent.toString() + "/" + getName();
	}
}
