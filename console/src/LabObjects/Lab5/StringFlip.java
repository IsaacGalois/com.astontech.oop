package LabObjects.Lab5;

import java.util.stream.IntStream;

public class StringFlip implements CharSequence {

    private String Content;

    public StringFlip () {}
    public StringFlip (String content) {
        this.Content = content;
    }

    public String Flip() {
        StringBuilder flipped = new StringBuilder();

        for(int i=this.Content.length()-1;i!=-1;i--) {
            flipped.append(this.Content.charAt(i));
        }

        return flipped.toString();
    }

    @Override
    public int length() {
        return this.Content.length();
    }

    @Override
    public char charAt(int i) {
        return this.Content.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return this.Content.subSequence(i,i1);
    }

    @Override
    public IntStream chars() {
        return this.Content.chars();
    }

    @Override
    public IntStream codePoints() {
        return this.Content.codePoints();
    }
}
