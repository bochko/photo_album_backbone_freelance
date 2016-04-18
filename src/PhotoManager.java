
public class PhotoManager {

	private LinkedList<Photo> photos;

	// Constructor
	public PhotoManager() {
		photos = new LinkedList<Photo>();
	}

	// Return all managed photos
	public LinkedList<Photo> getPhotos() {
		if (photos.empty()) {
			System.out.println("NO_PHOTOS_AVAILABLE");
		}
		return photos;
	}

	// Add a photo
	public void addPhoto(Photo p) {
		photos.insert(p);
	}

	// Delete a photo
	public void deletePhoto(String path) {
		if (!photos.empty()) {
			photos.findFirst();
			while (!photos.last()) {
				if (photos.retrieve().getPath().equals(path)) {
					photos.remove();
					return; // assuming the list has unique photos, after
							// deletion method returns
				}
				photos.findNext();
			}
			photos.findNext();
			if (photos.retrieve().getPath().equals(path)) {
				photos.remove();
				return; // assuming the list has unique photos, after
						// deletion method returns
			}
		} else {
			System.out.println("PhotoManager LinkedList is empty.");
		}
	}
}
