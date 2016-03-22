package Interfaces;

/**
 * Created by asusss on 22.03.2016.
 */
public class MenuEvent {
    public enum ItemType {
        menu, play, credits, scores;
    }

    ItemType itemType;

    public interface Listener {
        void onMenuEvent(ItemType itemType);
    }

}