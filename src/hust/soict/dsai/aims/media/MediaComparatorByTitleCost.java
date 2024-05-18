
package hust.soict.dsai.aims.media;
import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        String title1= media1.getTitle();
        String title2= media2.getTitle();
        if (title1.compareTo(title2) != 0) {
            return title1.compareTo(title2);
        } else {
            return Float.compare(media1.getCost(), media2.getCost());
        }
    }
}
