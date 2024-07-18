package com.java;

public class Data {
	
	private int id;
    private String name;
    private double price;
    private String author;
    private String publication;

    public Data(int id, String name, double price, String author, String publication) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.publication = publication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: " + price + ", Author: " + author + ", Publication: " + publication;
    }

}
