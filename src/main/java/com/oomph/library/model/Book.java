package com.oomph.library.model;

public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private int totalCopies;
    private int availableCopies;

    public Book(String isbn, String title, String author, int totalCopies) {
        this.isbn = validate(isbn, "ISBN");
        this.title = validate(title, "Title");
        this.author = validate(author, "Author");
        this.totalCopies = validateTotalCopies(totalCopies);
        this.availableCopies= totalCopies;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setTotalCopies(int totalCopies) {
        if(totalCopies < 1 || totalCopies < availableCopies) {
            throw new IllegalArgumentException("Total copies can not be less than one or less than available copies");
        }
        this.totalCopies = totalCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        if(availableCopies < 0 || availableCopies > totalCopies) {
            throw new IllegalArgumentException("Available copies can only be >= 0 or <= total copies");
        }
        this.availableCopies = availableCopies;
    }

    private String validate(String field, String fieldName) {
        if(field == null || field.isBlank()) {
            throw new IllegalArgumentException( fieldName + " can not be empty");
        }
        return field;
    }

    private int validateTotalCopies(int totalCopies) {
        if(totalCopies < 1) {
            throw new IllegalArgumentException("Total copies can not be less than one");
        }
        return totalCopies;
    }
}
