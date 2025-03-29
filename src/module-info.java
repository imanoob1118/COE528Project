module Bookstore {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.web;
    requires jdk.jsobject;

    // Allow JavaFX to access classes in the 'bookstore' package
    opens bookstore to javafx.graphics, javafx.fxml;
    exports bookstore;
}
