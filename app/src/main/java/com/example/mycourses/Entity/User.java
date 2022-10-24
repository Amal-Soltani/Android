package com.example.mycourses.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "login")
    private String login;

    @ColumnInfo(name = "pwd")
    private String pwd;

    @ColumnInfo(name = "fullName")
    private String fullName;


    public User() {
    }

    public User(String login, String pwd, String fullName) {
        this.login = login;
        this.pwd = pwd;
        this.fullName = fullName;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
