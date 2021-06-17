package com.jp.proyecto_api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Book  {

    @SerializedName("url")
    private String idBook;

    @SerializedName("name")
    private String nameBook;

    @SerializedName("authors")
    private String [] authorsBook;

    @SerializedName("numberOfPages")
    private int pagesBook;

    @SerializedName("publisher")
    private String publisherBook;


    public String getIdBook() {
        if (idBook.substring(idBook.length()-1).equals("0")){
            return "1"+idBook.substring(idBook.length()-1);

        }
        return idBook.substring(idBook.length()-1);
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String[] getAuthorsBook() {
        return authorsBook;
    }

    public void setAuthorsBook(String[] authorsBook) {
        this.authorsBook = authorsBook;
    }

    public int getPagesBook() {
        return pagesBook;
    }

    public void setPagesBook(int pagesBook) {
        this.pagesBook = pagesBook;
    }

    public String getPublisherBook() {
        return publisherBook;
    }

    public void setPublisherBook(String publisherBook) {
        this.publisherBook = publisherBook;
    }
}
