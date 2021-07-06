package com.dokidoki;

import android.os.Parcel;
import android.os.Parcelable;

public class Cherry2_Collection_Item implements Parcelable {

    int id, number, image, text;
    String charactor, isLock;

    public Cherry2_Collection_Item(int id, String charactor, int number, String isLock, int image, int text) {
        this.id = id;
        this.charactor = charactor;
        this.number = number;
        this.isLock = isLock;
        this.image = image;
        this.text = text;
    }

    protected Cherry2_Collection_Item(Parcel in) {
        id = in.readInt();
        charactor = in.readString();
        number = in.readInt();
        isLock = in.readString();
        image = in.readInt();
        text = in.readInt();
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getCharactor(){
        return this.charactor;
    }

    public void setCharactor(String charactor){
        this.charactor = charactor;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public String getIsLock(){
        return this.isLock;
    }

    public void setIsLock(String isLock){
        this.isLock = isLock;
    }


    public int getImageId(){
        return this.image;
    }

    public void setImageId(int image){
        this.image = image;
    }

    public int getTextId(){
        return this.text;
    }

    public void setTextId(int text){
        this.text = text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Cherry2_Collection_Item> CREATOR = new Creator<Cherry2_Collection_Item>() {
        @Override
        public Cherry2_Collection_Item createFromParcel(Parcel in) {
            return new Cherry2_Collection_Item(in);
        }

        @Override
        public Cherry2_Collection_Item[] newArray(int size) {
            return new Cherry2_Collection_Item[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(charactor);
        dest.writeInt(number);
        dest.writeString(isLock);
        dest.writeInt(image);
        dest.writeInt(text);
    }
}