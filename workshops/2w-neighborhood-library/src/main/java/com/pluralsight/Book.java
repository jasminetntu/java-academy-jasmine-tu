package com.pluralsight;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    // *** Constructors ***
    public Book() {
        this.id = 0;
        this.isbn = "";
        this.title = "";
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    public Book(int id, String isbn, String title) {
        this();
        this.id = id;
        this.isbn = isbn;
        this.title = title;
    }

    // *** Getters ***
    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    // *** Setters ***
    public void setId(int id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // *** Other ***

    /**
     * Checks out book and adds lendee name. Confirms check out.
     * @param name
     */
    public void checkOut(String name) {
        isCheckedOut = true;
        checkedOutTo = name;
        System.out.printf("%s has been checked out to %s.\n", this.title, name);
    }

    /**
     * Checks in a book and clears lendee name. Confirms check in.
     */
    public void checkIn() {
        isCheckedOut = false;
        checkedOutTo = "";
        System.out.println(this.title + " has been checked in.");
    }

    @Override
    public String toString() {
        //if unavailable
        if (isCheckedOut) {
            return String.format("""
                    %s
                        ID: %d
                        ISBN: %s
                        Checked out to: %s""", title, id, isbn, checkedOutTo);
        }
        //if available
        return String.format("""
                    %s
                        ID: %d
                        ISBN: %s""", title, id, isbn);

    }
}
