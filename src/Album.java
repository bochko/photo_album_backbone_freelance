
public class Album {

	private String name;
	private String condition;
	private PhotoManager manager;

	// Constructor
	public Album(String name, String condition, PhotoManager manager) {
		this.name = name;
		this.condition = condition;
		this.manager = manager;
	}

	// Return the name of the album
	public String getName() {
		return name;
	}

	// Return the condition associated with the album
	public String getCondition() {
		if (condition.equals("")) {
			System.out.println("NO_CONDITION_AVAILABLE");
		}
		return condition;
	}

	// Return the manager
	public PhotoManager getManager() {
		return manager;
	}

	// Return all photos that satisfy the album condition
	public LinkedList<Photo> getPhotos() {

		LinkedList<Photo> album_photos = new LinkedList<Photo>();
		LinkedList<Photo> full_selection = new LinkedList<Photo>();

		full_selection = manager.getPhotos();

		if (!full_selection.empty()) {
			full_selection.findFirst(); // set to start of list
			while (!full_selection.last()) {
				Photo photo = full_selection.retrieve(); // set photo to current
															// element in photos
															// list
				String[] photo_tags;
				String[] condition_tags;
				photo_tags = toTagsString(photo.getTags()).split(","); //create the photo_tags array
				condition_tags = toTagsString(conditionsToTagList()).split(","); //create the condition_tags array

				if (tagsMatch(photo_tags, condition_tags)) {
					album_photos.insert(photo);
				}
				full_selection.findNext();
			}
			Photo photo = full_selection.retrieve(); // set photo to current
														// element in photos
														// list
			// check last element
			String[] photo_tags;
			String[] condition_tags;
			photo_tags = toTagsString(photo.getTags()).split(",");
			condition_tags = toTagsString(conditionsToTagList()).split(",");

			if (tagsMatch(photo_tags, condition_tags)) {
				album_photos.insert(photo);
			}

		}

		return album_photos;

	}

	public LinkedList<String> conditionsToTagList() {
		String[] tag_array;
		LinkedList<String> list;
		if (condition.contains("AND")) {
			tag_array = condition.split(" AND ");
			list = new LinkedList<String>();
			for (String tag : tag_array) {
				list.insert(tag);
			}
		} else {
			tag_array = new String[1];
			tag_array[0] = condition;
			list = new LinkedList<String>();
			for (String tag : tag_array) {
				list.insert(tag);
			}
		}

		return list;

	}

	private String toTagsString(LinkedList<String> linkedList) {
		String result = "";

		if (!linkedList.empty()) {
			linkedList.findFirst();
			while (!linkedList.last()) {
				result += linkedList.retrieve() + ",";
				linkedList.findNext();
			}
			result += linkedList.retrieve();
		}

		return result;
	}

	// check if tags in photos match ALL the condition tags
	private boolean tagsMatch(String[] photo_tags, String[] condition_tags) {

		if (condition_tags[0].equals(""))
			return true;

		// we assume all conditions exist in photo tags

		for (int i = 0; i < condition_tags.length; i++) {
			for (int k = 0; k < photo_tags.length; k++) {
				if (condition_tags[i].equals(photo_tags[k])) {
					condition_tags[i] = "TRUE"; //change local array value to true, if it matches
				}
			}
		}

		// if it turns out one of the condition tags wasn't changed to true -
		// exit with false.
		for (String condition : condition_tags) {
			if (!condition.equals("TRUE")) {
				return false;
			}
		}
		
		//if nothing points to missing tags, return true
		return true;
	}
}
