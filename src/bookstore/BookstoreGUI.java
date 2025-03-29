package bookstore;

import javafx.application.*;   // For Application, Platform, etc.
import javafx.scene.*;         // For Scene, Node, etc.
import javafx.scene.control.*; // For Button, Label, TextField, etc.
import javafx.scene.layout.*;  // For VBox, HBox, GridPane, etc.
import javafx.stage.*;         // For Stage, Window, etc.
import javafx.geometry.*;      // For Insets, Pos, etc.

public class BookstoreGUI extends Application { 
    Stage applicationWindow; // initialize the window for the application

    // Declare all screens
    Scene loginScreen; // initialize the login screen
    Scene ownerStartScreen, ownerCustomerScreen, customerCostScreen; // initialize the owner screens 
    Scene customerStartScreen, customerCostScreenBuy, customerCostScreenRedeem; // initialize the customer screens
    
    PasswordField passwordField; // input field for password
    Label errorLabel; // label for login error messages

    @Override
    public void start(Stage stage) {
        applicationWindow = stage; // Sets up the application window

        // Initialize all screens
        loginScreen = createLoginScreen();
        ownerStartScreen = createOwnerStartScreen();
        ownerCustomerScreen = createOwnerCustomerScreen();
        customerCostScreen = createCustomerCostScreen();
        customerStartScreen = createCustomerStartScreen();
        customerCostScreenBuy = createCustomerCostScreenBuy();
        customerCostScreenRedeem = createCustomerCostScreenRedeem();

        // Set Initial Scene
        applicationWindow.setScene(loginScreen);
        applicationWindow.setTitle("Bookstore");
        applicationWindow.show();
    }

    /** Method to create the login screen */
    private Scene createLoginScreen() {
        
        // Welcome Label
        Label welcomeLabel = new Label("Welcome to BK");
        welcomeLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Username Field
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");


        // Password field
        passwordField = new PasswordField();
        passwordField.setPromptText("Your password");

        // Error label for incorrect login attempts
        errorLabel = new Label("");
        errorLabel.setStyle("-fx-text-fill: red;");

        // Login button
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> handleLogin());

        // Create layout for login page
        VBox loginLayout = new VBox(10);
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.setPadding(new Insets(20));
        loginLayout.getChildren().addAll(passwordField, loginButton, errorLabel);

        return new Scene(loginLayout, 600, 400); // Creates the login screen page
    }
    

    /** Method to create the owner start screen */
    private Scene createOwnerStartScreen() {
        // Button to go to next screen
        Button nextButton = new Button("Next (Owner -> Customer)");
        nextButton.setOnAction(e -> applicationWindow.setScene(ownerCustomerScreen));

        return createSceneWithButton(nextButton);
    }

    /** Method to create the owner customer screen */
    private Scene createOwnerCustomerScreen() {
        // Button to go to next screen
        Button nextButton = new Button("Next (Owner -> Cost)");
        nextButton.setOnAction(e -> applicationWindow.setScene(customerCostScreen));

        return createSceneWithButton(nextButton);
    }

    /** Method to create the customer cost screen */
    private Scene createCustomerCostScreen() {
        // Button to go to next screen
        Button nextButton = new Button("Next (Customer -> Start)");
        nextButton.setOnAction(e -> applicationWindow.setScene(customerStartScreen));

        return createSceneWithButton(nextButton);
    }

    /** Method to create the customer start screen */
    private Scene createCustomerStartScreen() {
        // Button to go to next screen
        Button nextButton = new Button("Next (Customer Start -> Buy)");
        nextButton.setOnAction(e -> applicationWindow.setScene(customerCostScreenBuy));

        return createSceneWithButton(nextButton);
    }

    /** Method to create the customer cost screen (Buy) */
    private Scene createCustomerCostScreenBuy() {
        // Button to go to next screen
        Button nextButton = new Button("Next (Buy -> Redeem)");
        nextButton.setOnAction(e -> applicationWindow.setScene(customerCostScreenRedeem));

        return createSceneWithButton(nextButton);
    }

    /** Method to create the customer cost screen (Redeem) */
    private Scene createCustomerCostScreenRedeem() {
        // Button to go back to login screen
        Button nextButton = new Button("Back to Login");
        nextButton.setOnAction(e -> applicationWindow.setScene(loginScreen));

        return createSceneWithButton(nextButton);
    }

    /** Method to handle login authentication */
    private void handleLogin() {
        String correctPassword = "admin123"; // predefined password
        String enteredPassword = passwordField.getText();

        if (enteredPassword.equals(correctPassword)) {
            errorLabel.setText(""); // clears error message
            applicationWindow.setScene(ownerStartScreen); // proceeds to the next screen
        } else {
            errorLabel.setText("Incorrect password! Please try again."); // displays error message
        }
    }

    /** Helper method to create a scene with a centered button */
    private Scene createSceneWithButton(Button button) {
        StackPane layout = new StackPane(button);
        layout.setAlignment(Pos.CENTER);
        return new Scene(layout, 600, 400);
    }

    public static void main(String args[]){          
        launch(args);     
    }         
}

