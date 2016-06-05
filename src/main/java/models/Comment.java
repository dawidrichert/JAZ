package models;

import java.util.Date;

public class Comment {

    private static int idCounter = 1;

    private int id;
    private String content;
    private Date date;
    private String author;

    public Comment() { }

    public Comment(String content, Date date, String author) {
        this.id = getNextId();
        this.content = content;
        this.date = date;
        this.author = author;
    }

    public static int getNextId() {
        return idCounter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
