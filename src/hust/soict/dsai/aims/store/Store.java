package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;


public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
	public Store() {
    }
    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println(media.getTitle() + " is already in the store.");
        } else {
            itemsInStore.add(media);
            System.out.println(media.getTitle() + " has been added to the store.");
        }
    }

    public void addMedia(Media... medias) {
        for (Media media : medias) {
            if (itemsInStore.contains(media)) {
                System.out.println(media.getTitle() + " is already in the store.");
            } else {
                itemsInStore.add(media);
                System.out.println(media.getTitle() + " has been added to the store.");
            }
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
        	itemsInStore.remove(media);
            System.out.println(media.getTitle() + " has been removed from the store.");
        } else {
            System.out.println(media.getTitle() + " is not in the store.");
        }
    }
    public Media search_by_title(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
        
    }

}