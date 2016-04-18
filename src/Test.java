
public class Test {
	public static void main(String[] args) {
		PhotoManager manager = new PhotoManager();

		Photo photo1 = new Photo("hedgehog.jpg");
		photo1.setTags(toTagsLinkedList("animal, hedgehog, apple, grass, green"));
		manager.addPhoto(photo1);

		Photo photo2 = new Photo("bear.jpg");
		photo2.setTags(toTagsLinkedList("animal, bear, cab, grass, wind"));
		manager.addPhoto(photo2);

		Photo photo3 = new Photo("orange-butterfly.jpg");
		photo3.setTags(toTagsLinkedList("insect, butterfly, flower, color"));
		manager.addPhoto(photo3);

		Photo photo4 = new Photo("black-butterfly.jpg");
		photo4.setTags(toTagsLinkedList("insect, butterfly, black, flower"));
		manager.addPhoto(photo4);

		Photo photo5 = new Photo("fox.jpg");
		photo5.setTags(toTagsLinkedList("animal, fox, tree, forest, grass"));
		manager.addPhoto(photo5);

		Photo photo6 = new Photo("panda.jpg");
		photo6.setTags(toTagsLinkedList("animal, bear, panda, grass"));
		manager.addPhoto(photo6);

		Photo photo7 = new Photo("wolf.jpg");
		photo7.setTags(toTagsLinkedList("animal, wolf, mountain, sky, snow, cloud"));
		manager.addPhoto(photo7);

		Photo photo8 = new Photo("raccoon.jpg");
		photo8.setTags(toTagsLinkedList("animal, raccoon, log, snow"));
		manager.addPhoto(photo8);

		System.out.println("Project sheet example:");
		System.out.println("--------------------------");

		Album album1 = new Album("Album1", "bear", manager);
		Album album2 = new Album("Album2", "animal AND grass", manager);

		System.out.println("Album1: " + toPathsString(album1.getPhotos()));
		System.out.println("Album2: " + toPathsString(album2.getPhotos()));
		System.out.println("--------------------------\n\n");

		System.out.println("Get photo1 path and tags:");
		System.out.println("--------------------------");
		System.out.println("photo1 path: " + photo1.getPath());
		System.out.println("photo1 tags: " + toTagsString(photo1.getTags()));
		System.out.println("--------------------------\n\n");

		System.out.println("Get album2 name, condition, and photos:");
		System.out.println("--------------------------");
		System.out.println("album2 name: " + album2.getName());
		System.out.println("album2 condition: " + album2.getCondition());
		System.out.println("album2 photos: " + toPathsString(album2.getPhotos()));
		System.out.println("--------------------------\n\n");

		System.out.println("Change 'panda.jpg' tags to only 'animal, panda':");
		System.out.println("--------------------------");

		photo6.setTags(toTagsLinkedList("animal, panda"));

		System.out.println("Album1: " + toPathsString(album1.getPhotos()));
		System.out.println("Album2: " + toPathsString(album2.getPhotos()));
		System.out.println("--------------------------\n\n");

		System.out.println("Add a new photo 'duck.jpg' with tags 'animal, duck, grass, water':");
		System.out.println("--------------------------");

		Photo photo9 = new Photo("duck.jpg");
		photo9.setTags(toTagsLinkedList("animal, duck, grass, water"));
		manager.addPhoto(photo9);

		System.out.println("Album1: " + toPathsString(album1.getPhotos()));
		System.out.println("Album2: " + toPathsString(album2.getPhotos()));
		System.out.println("--------------------------\n\n");

		System.out.println("Delete the photos 'bear.jpg' and 'fox.jpg':");
		System.out.println("--------------------------");

		manager.deletePhoto("bear.jpg");
		manager.deletePhoto("fox.jpg");

		System.out.println("Album1: " + toPathsString(album1.getPhotos()));
		System.out.println("Album2: " + toPathsString(album2.getPhotos()));
		System.out.println("--------------------------\n\n");

		System.out.println("Create a new album with the condition 'butterfly AND insect AND flower':");
		System.out.println("--------------------------");

		Album album3 = new Album("Album3", "butterfly AND insect AND flower", manager);

		System.out.println("Album3: " + toPathsString(album3.getPhotos()));
		System.out.println("--------------------------\n\n");

		System.out.println(
				"Create a new album with the impossible condition 'animal AND insect'. Nothing will be matched:");
		System.out.println("--------------------------");

		Album album4 = new Album("Album4", "animal AND insect", manager);

		System.out.println("Album4: " + toPathsString(album4.getPhotos()));
		System.out.println("--------------------------\n\n");

		System.out.println("Create a new album with empty condition. All photos will be matched:");
		System.out.println("--------------------------");

		Album album5 = new Album("Album5", "", manager);

		System.out.println("Album5: " + toPathsString(album5.getPhotos()));
		System.out.println("--------------------------\n\n");

		System.out.println("Get tags from unset photo tags:");
		System.out.println("--------------------------");

		Photo photo10 = new Photo("empty-tags.jpg");

		System.out.println("photo10 tags: " + toTagsString(photo10.getTags()));
		System.out.println("--------------------------\n\n");

		System.out.println("Get photos from empty PhotoManager:");
		System.out.println("--------------------------");

		PhotoManager emptyManager = new PhotoManager();

		System.out.println("emptyManager photos: " + toPathsString(emptyManager.getPhotos()));
		System.out.println("--------------------------\n\n");

		System.out.println("Get name, condition, and photos from empty album:");
		System.out.println("--------------------------");

		Album album6 = new Album("Album6", "", emptyManager);

		System.out.println("album6 name: " + album6.getName());
		System.out.println("album6 condition: " + album6.getCondition());
		System.out.println("album6 photos: " + toPathsString(album6.getPhotos()));
		System.out.println("--------------------------\n\n");
	}

	// Utilities methods (DONT CHANGE)

	private static LinkedList<String> toTagsLinkedList(String tags) {
		LinkedList<String> result = new LinkedList<String>();
		String[] tagsArray = tags.split("\\s*,\\s*");

		for (int i = 0; i < tagsArray.length; i++) {
			result.insert(tagsArray[i]);
		}

		return result;
	}

	private static String toPathsString(LinkedList<Photo> photos) {
		String result = "";

		if (!photos.empty()) {
			photos.findFirst();
			while (!photos.last()) {
				result += photos.retrieve().getPath() + ",";
				photos.findNext();
			}
			result += photos.retrieve().getPath();
		}

		return result;
	}

	private static String toTagsString(LinkedList<String> linkedList) {
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
}
