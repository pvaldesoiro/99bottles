import java.util.ArrayList;

public class Bottles {
    public String verse(int n) {
        return (n > 0 ? n : "No more") + " bottle" + (n != 1 ? "s" : "") + " of beer on the wall, " +
                (n > 0 ? n : "no more") + " bottle" + (n != 1 ? "s" : "") + " of beer.\n" +
                (n == 0 ? "Go to the store and buy some more" : "Take " + (n == 1 ? "it" : "one") + " down and pass it around") +
                ", " + ((n - 1) > 0 ? (n - 1) : (n == 0 ? 99 : "no more")) + " " +
                "bottle" + (n - 1 != 1 ? "s" : "") + " of beer on the wall.\n";
    }

    public String verses(final int hi, int lo) {
        var verses = new ArrayList<String>();

        for (var i = hi; i >= lo; i -= 1) {
            verses.add(verse(i));
        }

        return String.join("\n", verses);
    }

    public String song() {
        return verses(99, 0);
    }
}
