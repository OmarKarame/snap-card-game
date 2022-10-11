public class Main {
    public static void main(String[] args) {
        final Snap snap = new Snap();
        System.out.println( "Shuffled cards:");
        System.out.println(snap.getDeck());
        System.out.println("Sorted by order:");
        snap.sortDeckByNumberOrder();
        System.out.println("Sorted by suits:");
        snap.sortDeckBySuits();
        snap.play();
    }
}