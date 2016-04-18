public class Photo {

	private String path; // file path / name of photo
	private LinkedList<String> tags; // list containing all the tags of a photo

	// Constructur
	public Photo(String path) {
		this.path = path;
		tags = new LinkedList<String>();
	}

	// Return the path (full file name) of the photo. A photo is uniquely
	// identified by its path.
	public String getPath() {
		return path;
	}

	// Return all tags associated with the photo
	public LinkedList<String> getTags() {
		if (tags.empty()) {
			System.out.println("NO_TAGS_AVAILABLE_FOR_PHOTO");
		}
		return tags;
	}

	// Set the list of tags
	public void setTags(LinkedList<String> tags) {
		this.tags = tags;
	}

}
