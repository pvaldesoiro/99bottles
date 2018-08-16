import java.util.ArrayList;

public class Bottles {
    public String verse(int bottles) {
        return new Round(bottles).toString();
    }

    public String verses(final int bottlesAtStart, int bottlesAtEnd) {
        var verses = new ArrayList<String>();

        for (var i = bottlesAtStart; i >= bottlesAtEnd; i -= 1) {
            verses.add(verse(i));
        }

        return String.join("\n", verses);
    }

    public String song() {
        return verses(99, 0);
    }

    private class Round {
        private int bottles;

        Round(int bottles) {
            this.bottles = bottles;
        }

        @Override
        public String toString() {
            return challenge() + response();
        }

        private String challenge() {
            return capitalizedBottlesOfBeer() + " " + onWall() + ", " + bottlesOfBeer() + ".\n";
        }

        private String response() {
            return goToTheStoreOrTakeOneDown() + ", " + bottlesOfBeer() + " " + onWall() + ".\n";
        }

        private String bottlesOfBeer() {
            return anglicizedBottleCount() + " " + pluralizedBottleForm() + " of " + beer();
        }

        private String capitalizedBottlesOfBeer() {
            var bottlesOfBeer = bottlesOfBeer();

            return Character.toUpperCase(bottlesOfBeer.charAt(0)) + bottlesOfBeer.substring(1);
        }

        private String beer() {
            return "beer";
        }

        private String onWall() {
            return "on the wall";
        }

        private String pluralizedBottleForm() {
            return isLastBeer() ? "bottle" : "bottles";
        }

        private String anglicizedBottleCount() {
            return isAllOut() ? "no more" : String.valueOf(bottles);
        }

        private String goToTheStoreOrTakeOneDown() {
            if (isAllOut()) {
                this.bottles = 99;
                return buyNewBeer();
            } else {
                String lyrics = drinkBeer();
                this.bottles -= 1;
                return lyrics;
            }
        }

        private String buyNewBeer() {
            return "Go to the store and buy some more";
        }

        private String drinkBeer() {
            return "Take " + itOrOne() + " down and pass it around";
        }

        private String itOrOne() {
            return isLastBeer() ? "it" : "one";
        }

        private boolean isAllOut() {
            return bottles == 0;
        }

        private boolean isLastBeer() {
            return bottles == 1;
        }
    }
}
