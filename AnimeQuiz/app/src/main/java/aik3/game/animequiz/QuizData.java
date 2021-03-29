package aik3.game.animequiz;

import android.net.Uri;

public final class QuizData {

    private Title[] titles = {
            new Title(0, 0, "", "android.resource://aik3.game.animequiz/raw/file_example", ""),
            new Title(0, 0, "", "", ""),
            new Title(0, 0, "", "", "")
    };


    private int index = 0;
    private final int max = titles.length -1;

    Title getCurrent() {
        return titles[index];
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
