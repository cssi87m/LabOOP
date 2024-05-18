package hust.soict.dsai.aims;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import Books;
import CompactDisc;
import DigitalVideoDisc;
import Media;

public class Aims {

    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
		DigitalVideoDisc dvd1= new DigitalVideoDisc(1,"The Lion King","Animation","Roger Allers",87,19.95f);
		DigitalVideoDisc dvd2= new DigitalVideoDisc(2,"Star Wars","Science Fiction","George Lucas",87,24.95f);
		DigitalVideoDisc dvd3= new DigitalVideoDisc(3,"Aladin","Animation",18.99f);
		store.addMedia(dvd1,dvd2);
		store.addMedia(dvd3);
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void viewStore() {
    	List<Media> itemInStore=store.getItemsInStore();
        for(Media media:itemInStore) {
        	System.out.println(media.toString());
        }
        while (true) {
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void seeMediaDetails() {
        System.out.println("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.search_by_title(title);
        if (media != null) {
            System.out.println(media);
            while (true) {
                mediaDetailsMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        cart.addMedia(media);
                        break;
                    case 2:
                        if (media instanceof DigitalVideoDisc|| media instanceof CompactDisc) {
                            System.out.println("Playing media: " + media.getTitle());
                        } else {
                            System.out.println("Cannot play this type of media.");
                        }
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid choice. Please choose again.");
                }
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void addMediaToCart() {
        System.out.println("Enter the title of the media to add to cart: ");
        String title = scanner.nextLine();
        Media media = store.search_by_title(title);
        if (media != null) {
            cart.addMedia(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia() {
        System.out.println("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = store.search_by_title(title);
        if (media != null) {
            if (media instanceof DigitalVideoDisc || media instanceof CompactDisc) {
                System.out.println("Playing media: " + media.getTitle());
            } else {
                System.out.println("Cannot play this type of media.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void updateStore() {
        while (true) {
            System.out.println("Update Store: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add a media");
            System.out.println("2. Remove a media");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addMediaToStore();
                    break;
                case 2:
                    removeMediaFromStore();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    public static void addMediaToStore() {
        System.out.println("Enter media type (Book, CD, DVD): ");
        String type = scanner.nextLine();
        System.out.println("Enter media ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter media title: ");
        String title = scanner.nextLine();
        System.out.println("Enter media category: ");
        String category = scanner.nextLine();
        System.out.println("Enter media cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine();

        Media media;
        switch (type.toLowerCase()) {
            case "book":
                media = new Books(id, title, category, cost);
                break;
            case "cd":
                media = new CompactDisc(id, title, category, cost);
                break;
            case "dvd":
                media = new DigitalVideoDisc(id, title, category, cost);
                break;
            default:
                System.out.println("Invalid media type.");
                return;
        }
        store.addMedia(media);
    }

    public static void removeMediaFromStore() {
        System.out.println("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media media = store.search_by_title(title);
        if (media != null) {
            store.removeMedia(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void seeCurrentCart() {
        cart.print();
        while (true) {
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    filterMediasInCart();
                    break;
                case 2:
                    sortMediasInCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaInCart();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void filterMediasInCart() {
        System.out.println("Filter by: ");
        System.out.println("1. ID");
        System.out.println("2. Title");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter media ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                cart.search_by_ID(id);
                break;
            case 2:
                System.out.println("Enter media title: ");
                String title = scanner.nextLine();
                cart.search_by_title(title);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void sortMediasInCart() {
        System.out.println("Sort by: ");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                Collections.sort(cart.getItemsOrdered(),Media.COMPARE_BY_TITLE_COST);
                break;
            case 2:
            	Collections.sort(cart.getItemsOrdered(),Media.COMPARE_BY_COST_TITLE);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void removeMediaFromCart() {
        System.out.println("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media media = cart.find_media_by_title(title);
        if (media != null) {
            cart.removeMedia(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMediaInCart() {
        System.out.println("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = cart.find_media_by_title(title);
        if (media != null) {
            if (media instanceof DigitalVideoDisc || media instanceof CompactDisc) {
                System.out.println("Playing media: " + media.getTitle());
            } else {
                System.out.println("Cannot play this type of media.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void placeOrder() {
   
    }
}