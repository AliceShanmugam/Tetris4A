package MoteurGraphique.Events;

public class MenuEvent {

    public enum ItemType {
        menu, play, credits, scores, playSolo, playMulti, back, sendInvitation, acceptInvitation
    }

    public interface Listener {
        void onMenuEvent(ItemType itemType);
    }

}