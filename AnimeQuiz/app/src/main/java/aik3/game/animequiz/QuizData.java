package aik3.game.animequiz;

import android.net.Uri;

/**
 * Репозиторий данных
 */
public final class QuizData {

    private Title[] titles = {
            new Title(0, 0, "", "android.resource://aik3.game.animequiz/raw/file_example", "Ayaya"),
            new Title(1, 0, "", "", ""),
            new Title(2, 0, "", "", ""),
            new Title(3, 0, "", "", ""),
            new Title(4, 0, "", "", ""),
            new Title(5, 0, "", "", ""),
            new Title(6, 0, "", "", ""),
            new Title(7, 0, "", "", ""),
            new Title(8, 0, "", "", ""),
            new Title(9, 0, "", "", ""),
            new Title(10, 0, "", "", ""),
            new Title(11, 0, "", "", ""),
            new Title(12, 0, "", "", "")
    };

    private final int max = titles.length -1;

    Title getByIndex(int index) {
        return titles[index];
    }

    int getSize() {
        return max;
    }

    static class Title {

        private int id, image;
        private String title, opening,description;

        Title(int id, int image, String title, String opening,String description) {
            this.id = id;
            this.image = image;
            this.title = title;
            this.description = description;
            this.opening = opening;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getOpening() {
            return opening;
        }

        public int getImage() {
            return image;
        }
    }

}
