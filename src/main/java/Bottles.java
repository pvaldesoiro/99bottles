import java.util.ArrayList;
import java.util.function.Function;

public class Bottles {
    public String verse(int number) {
        return verseFor(number).text();
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

    private Verse verseFor(int number) {
        switch (number) {
            case 0:
                return new Verse(number, this::noMoreLyrics);
            case 1:
                return new Verse(number, this::lastOneLyrics);
            case 2:
                return new Verse(number, this::penultimateLyrics);
            default:
                return new Verse(number, this::defaultLyrics);
        }
    }

    private String noMoreLyrics(Verse _verse) {
        return "No more bottles of beer on the wall, no more bottles of beer.\n" +
                "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
    }

    private String lastOneLyrics(Verse _verse) {
        return "1 bottle of beer on the wall, 1 bottle of beer.\n" +
                "Take it down and pass it around, no more bottles of beer on the wall.\n";
    }

    private String penultimateLyrics(Verse _verse) {
        return "2 bottles of beer on the wall, 2 bottles of beer.\n" +
                "Take one down and pass it around, 1 bottle of beer on the wall.\n";
    }

    private String defaultLyrics(Verse verse) {
        return verse.number + " bottles of beer on the wall, " +
                verse.number + " bottles of beer.\n" +
                "Take one down and pass it around, " +
                (verse.number - 1) + " bottles of beer on the wall.\n";
    }

    private class Verse {
        private int number;
        private Function<Verse, String> lyrics;

        Verse(int number, Function<Verse, String> lyrics) {
            this.number = number;
            this.lyrics = lyrics;
        }

        String text() {
            return lyrics.apply(this);
        }
    }
}
