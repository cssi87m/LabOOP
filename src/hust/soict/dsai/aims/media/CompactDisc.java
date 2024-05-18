package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;
public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<>();
    public CompactDisc() {
    	super();
    }
    public CompactDisc(int id,String title) {
        super(id,title);
    }
    public CompactDisc(int id,String title, String category, float cost) {
        super(id,title, category, cost);
    }
    public CompactDisc(int id,String title, String category, String director, float cost) {
        super(id,title, category, director,cost);
    }
    public CompactDisc(int id,String title, String category, String director, int length, float cost) {
        super(id,title, category,director,length,cost);
    }
    public String getArtist() {
        return artist;
    }
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("The track is already in the list.");
        }
    }
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("The track is not in the list.");
        }
    }
    public int getLength() {
        int length = 0;
        for (Track track : tracks) {
            length += track.getLength();
        }
        return length;
    }
    public void play() {
    	System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD artist: " + this.getArtist());
        for(Track track:tracks) {
        	track.play();
        	System.out.println("-------------------------");
        }
    }
    public String toString() {
    	return "CD-" + getTitle() + "-" + getCategory() + "-" + getDirector() + "-" + getLength() + ":" + getCost() + "$";
    }
}