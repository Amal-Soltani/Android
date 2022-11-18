package com.example.mycourses.Entity;

import androidx.room.Entity;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cours")
public class Cours {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "email")
    private String email;


    @ColumnInfo(name = "descreption")
    private String descreption;

    public Cours() {

    }

    public Cours(String title, String email, String descreption) {
        this.title = title;
        this.email = email;
        this.descreption = descreption;
    }

    public Cours(int id, String title, String email, String descreption) {
        this.id = id;
        this.title = title;
        this.email = email;
        this.descreption = descreption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", descreption='" + descreption + '\'' +
                '}';
    }
}
