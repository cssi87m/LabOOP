package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private String director;
	private int length;
    private static int nbDigitalVideoDisc = 0;
    public DigitalVideoDisc(int id,String title) {
        super(nbDigitalVideoDisc++,title);
    }
    public DigitalVideoDisc(int id,String title, String category, float cost) {
        super(nbDigitalVideoDisc++,title, category, cost);
    }
    public DigitalVideoDisc(int id,String title, String category, String director, float cost) {
        super(nbDigitalVideoDisc++,title, category, director,cost);
    }
    public DigitalVideoDisc(int id,String title, String category, String director, int length, float cost) {
        super(nbDigitalVideoDisc++,title, category,director,length,cost);
    }
    public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	@Override
    public String toString() {
        return "DVD-" + getTitle() + "-" + getCategory() + "-" + getDirector() + "-" + getLength() + ":" + getCost() + "$";
    }
    public boolean isMatch(String title) {
        return getTitle().equals(title);
    }
    public void play() {
    	System.out.println("Playing DVD: " + this.getTitle());
    	System.out.println("DVD length: " + this.getLength());
    }
}