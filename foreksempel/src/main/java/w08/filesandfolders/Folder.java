package w08.filesandfolders;

import java.util.ArrayList;
import java.util.List;

public class Folder {
	private String name;
	private Folder parent;
	private List<Folder> folders;
	private List<File> files;

	public Folder(String name, Folder parent) {
		folders = new ArrayList<>();
		files = new ArrayList<>();

		setName(name);
		move(parent);
	}

	public List<Object> findAll(String pattern) {
		List<Object> result = new ArrayList<>();
		findAll(pattern, result);
		return result;
	}

	private void findAll(String pattern, List<Object> result) {
		for (File file : files) {
			if (matchesName(pattern, file.getName())) {
				result.add(file);
			}
		}
		// denne manglet for å fange opp treffe på mapper 
//		for (Folder folder : folders) {
//			if (matchesName(pattern, folder.getName())) {
//				result.add(folder);
//			}
//		}
		
		for (Folder folder : folders) {
			folder.findAll(pattern, result);
		}
	}

	public Object findFirst(String pattern) {
		for (File file : files) {
			if (matchesName(pattern, file.getName()))
				return file;
		}

		for (Folder folder : folders) {
			if (matchesName(pattern, folder.getName()))
				return folder;
		}

		for (Folder folder : folders) {
			Object found = folder.findFirst(pattern);
			if (found != null)
				return found;
		}

		return null;
	}

	/*
	 * Her gjøres det en 1:1 match, det taes ikke hensyn til store og små bokstaver
	 * osv., heller ingen pattern. Men, vhsi du ønsker en form for pattern match kan
	 * det legges til støtte for det her. Hva med feks '*.txt'? Kan du legge til
	 * støtte for det?
	 */
	private boolean matchesName(String pattern, String name) {
		return pattern.equals(name);
	}

	/*
	 * Hvordan fungerer contains? Hvis en skal sjekke om this inneholder
	 * destination, så kan en sjekke alle parents til destination helt til parent er
	 * null for om den aktuelle Folder (dest, dest.parent, dest.parent.parent etc,
	 * men dette skjer rekursivt) er lik this. Hvis den er lik this, så må en
	 * returnere True siden destination da ligger i en subfolder til this, eller
	 * dypere. Hvis en kommer helt dit og ender opp med null, da returnerer en false
	 * - destination er ikke en subfolder.
	 */
	public boolean contains(Folder destination) {
		if (destination == this)
			return true;
		else if (destination == null)
			return false;
		else
			return this.contains(destination.parent);
	}

	public void move(Folder destination) {
		if (destination != null && this.contains(destination)) {
			throw new IllegalStateException("Uendelig løkke...");
		}

		// parent må ha beskjed før vi endrer parent til en ny Folder.
		if (parent != null)
			parent.delete(this);

		// Selv
		setParent(destination);

		// ny parent må få beskjed
		if (parent != null)
			parent.add(this);
	}

	public void delete(Folder folder) {
		folders.remove(folder);
	}

	public void add(Folder folder) {
		if (!folders.contains(folder))
			folders.add(folder);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) {
			throw new IllegalStateException("Name cannot be null.");
		}
		if (name.isBlank())
			throw new IllegalStateException("Name cannot be of zero length.");
		this.name = name.trim();
	}

	public Folder getParent() {
		return parent;
	}

	private void setParent(Folder parent) {
		this.parent = parent;
	}

	public void addFile(File file) {
		files.add(file);
	}

	public void deleteFile(File file) {
		files.remove(file);
	}

	@Override
	public String toString() {
		String tmp = "/" + getName();
		if (parent != null)
			tmp = parent.toString() + tmp;
		return tmp;
	}

	public void printTree() {
		System.out.println(toString());

		for (File file : files) {
			System.out.println(file.toString());
		}

		for (Folder folder : folders) {
			folder.printTree();
		}
	}
}
