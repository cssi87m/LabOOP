package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Books extends Media {
    private int id;
    private String title;
    private String category; 
    private float cost;
    private List<String> authors = new ArrayList<>();
    public Books(int id, String title, String category, float cost) {
    	super(id,title,category,cost);
    }

    public int getID() {
        return id;
    }
    public void setID(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
        else {
            System.out.println("Author is not in the list");
        }
    }
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        }
        else {
            System.out.println("The author is not in the list");
        }
    }
}
