package MoteurGraphique.Events;

public class MenuEvent {

    public enum ItemType {
        menu, play, credits, scores, playSolo, playMulti
    }

    public interface Listener {
        void onMenuEvent(ItemType itemType);
    }

}