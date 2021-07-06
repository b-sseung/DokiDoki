package com.dokidoki;

public class Cherry3_Episode_Item {

    int id, number, background, thumnail, text, story;
    String charactor, isLock;

    public Cherry3_Episode_Item(int id, String charactor, int number, String isLock, int background, int thumnail, int text, int story){
        this.id = id;
        this.charactor = charactor;
        this.number = number;
        this.isLock = isLock;
        this.background = background;
        this.thumnail = thumnail;
        this.text = text;
        this.story = story;
    }

    public int getId(){
        return this.id;
    }

    public String getCharactor(){
        return this.charactor;
    }

    public int getNumber(){
        return this.number;
    }

    public String getLock(){
        return this.isLock;
    }

    public void setLock(String lock){
        this.isLock = lock;
    }

    public int getBackground(){
        return this.background;
    }

    public int getThumnail(){
        return this.thumnail;
    }

    public int getText(){
        return this.text;
    }

    public int getStory(){
        return this.story;
    }

    public interface OnAdachiEpisodeClickLisner {
        public void OnAdachiEpisodeClickLisner(boolean value, Cherry3_Episode_Item item, int position);
    }
}
