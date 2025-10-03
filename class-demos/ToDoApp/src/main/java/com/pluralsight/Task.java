package com.pluralsight;

import java.time.LocalDate;

public class Task {
    private String title;
    private LocalDate dueDate;
    private boolean isComplete;
    private String urgency; // (A list of default values => ENUM)
    private String notificationMessage;
    private boolean reminder;

    // *** Constructors ***
    public Task() {
        this.title = "";
        this.isComplete = false;
        this.urgency = "";
        this.notificationMessage = "";
        this.reminder = false;
    }

    public Task(String title) {
        this();
        this.title = title;
    }

    public void markCompleted() {
        this.isComplete = true;
    }

    @Override
    public String toString() {
        if (isComplete) {
            return "[✓] " + title;
        } else {
            return "[ ] " + title;
        }
    }

}
