package de.bsautermeister.snegg.text;

public class StatusText {
    private final String text;
    private final float x;
    private final float y;

    public StatusText(String text, float x, float y) {
        this.text = text;
        this.x = x;
        this.y = y;
    }

    public String getText() {
        return text;
    }


    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "StatusText{" +
                "text='" + text + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
