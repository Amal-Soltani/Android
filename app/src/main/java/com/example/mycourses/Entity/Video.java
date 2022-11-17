package com.example.mycourses.Entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Video  implements  Parcelable{
    private String title;

    private String url;

    public Video() {
        this.title="";
        this.url="";
    }

    public Video(String title, String url) {
        this.title = title;
        this.url = url;
    }

    protected Video(Parcel in) {
        title = in.readString();
        url = in.readString();
    }

    public static final Parcelable.Creator<Video> CREATOR = new Parcelable.Creator<Video>() {
        @Override
        public Video createFromParcel(Parcel in) {
            return new Video(in);
        }

        @Override
        public Video[] newArray(int size) {
            return new Video[size];
        }
    };

    public boolean isEmpty(){
        return this.title.isEmpty() && this.url.isEmpty();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(url);
    }
}
