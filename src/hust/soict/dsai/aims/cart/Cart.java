package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    public Cart() {
    }
    public double totalCost() {
        double totalCost = 0.0;
        for (Media media : itemsOrdered) {
            totalCost += media.getCost();
        }
        return totalCost;
    }
    public void search_by_ID(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                found = true;
                System.out.println(media);
                break;
            }
        }
        if (!found) {
            System.out.println("This media item cannot be found.");
        }
    }
    public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	public void search_by_title(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                found = true;
                System.out.println(media);
            }
        }
        if (!found) {
            System.out.println("This media item cannot be found.");
        }
    }
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int count = 1;
        for (Media media : itemsOrdered) {
            System.out.println(count + ". " + media.toString());
            count++;
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. Cannot add more items.");
        } else if (itemsOrdered.contains(media)) {
            System.out.println("This item cannot be added because it is already in the cart.");
        } else {
            itemsOrdered.add(media);
            System.out.println(media.getTitle() + " has been added to the cart.");
        }
    }
    public void addMedia(Media... medias) {
        for (Media media : medias) {
            if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full. Cannot add more items.");
                break; // Stop adding further items if cart is full
            } else if (itemsOrdered.contains(media)) {
                System.out.println(media.getTitle() + " cannot be added because it is already in the cart.");
            } else {
                itemsOrdered.add(media);
                System.out.println(media.getTitle() + " has been added to the cart.");
            }
        }
    }
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
        	itemsOrdered.remove(media);
            System.out.println(media.getTitle() + " has been removed from the cart.");
        } else {
            System.out.println(media.getTitle() + " is not in the cart.");
        }
    }
    public int getNumbersOfDvds() {
    	return itemsOrdered.size();
    }
    public Media find_media_by_title(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
        
    }
}