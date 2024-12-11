package com.example.demo1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


// A public class named "IceCreamStoreDemo" is extending to JavaFx Application.
public class IceCreamStoreDemo extends Application
{
    //Variables consists 0f TextFields, Label, Button and a class.
    private TextField username;
    private TextField password;
    private TextField amount;
    private TextField products;
    ;
    private Label output;
    private Button logIn;
    private IceCreamStore myStore;


    // This method named main launches the javafx application.
    // important for other javafx imports to function.
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    //The "start" method will start the window of the javafx application.
    public void start(Stage primaryStage)
    {
        //Intializes the variables for TextFields, label, button, and instance of class,
        //where information gets stored.
        username = new TextField();
        password = new TextField();
        output = new Label();
        logIn = new Button();
        myStore = new IceCreamStore();


        //Created labels for the username and password prompt where user have to enter.
        Label user = new Label("Please Enter username: ");
        Label pword = new Label("Please Enter password: ");


        //Created a logIn button which upon pressing it will start the Login event handler.
        Button logIn = new Button("Log in");
        logIn.setOnAction(new Login());


        //The GridPane format named "gp" will have rows and columns.
        GridPane gp = new GridPane();
        // The rows and columns will position the Labels, TextFields, and buttons
        // in specific locations.
        gp.add(user, 0, 0);
        gp.add(username, 1, 0);
        gp.add(pword, 0, 1);
        gp.add(password, 1, 1);
        gp.add(logIn, 1, 2);
        gp.add(output, 1, 5);


        //This would set the contents of GridPane in the center
        // and includes padding around it.
        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(10.0));


        //Created a scene named "display" with the GridPane.
        // The scene will be used for the primary stage.
        //The title of the scene is called the "Trio's IceCreamStore".
        //It'll be displayed on the screen.
        Scene display = new Scene(gp, 300, 200);
        primaryStage.setScene(display);
        primaryStage.setTitle("Trio's IceCreamStore");
        primaryStage.show();
    }


    //A class named "Login" that'll implement the event handler
    //so it can make "logIn" button functional.
    class Login implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
            //The getText will obtain the inputs from username and password for string "user"
            //and "pWord" respectively.
            String user = username.getText();
            String pWord = password.getText();


            //An If statement that checks if the inputs match with the "myStore.username"
            // and "myStore.Password".
            //&& means And, which combines these two conditions.
            if (user.equals(myStore.Username()) && pWord.equals(myStore.Password()))
            {
                //If their conditions are true, it'll proceed to the "Menu" method.
                Menu();


            } else {


                //If their conditions are false, It'll output "Incorrect".
                output.setText("Incorrect.");
            }
        }
    }


    //A method called "Menu" will appear after the login was successful.
    private void Menu() {
        // A GridPane called "gp".
        GridPane gp = new GridPane();


        //Created a Label named "menu", containing an argument in its parameter.
        Label menu = new Label("menu: ");


        // Displays the "menu" in its location by row and column.
        gp.add(menu, 0, 0);


        //the "items" will get the array list of items from the Item method
        //in the IceCreamStore by using "myStore".
        //"items" will be used in the For Loop.
        String[] items = myStore.Item();


        // The For Loop will start at 0 until it reaches the end of the "Item" arraylist
        //from IceCreamStore.
        // Retrieve the list of items from the store
        for (int i = 0; i < items.length; i++)
        {


            // Created a variable named "names" for items array.
            String names = items[i];


            // Created a variable named "fee" for the Price method,
            // containing the array list of items from the Item method.
            double fee = myStore.Price(names);


            // Created a label named "item" with items and prices.
            Label item = new Label(names + ": $" + fee);


            // The rows and columns will position the item ins its specific location.
            gp.add(item, 0, i + 1);
        }


        //Intializes the variables for TextFields and Button,
        //where information gets stored.
        products = new TextField();
        amount = new TextField();
        Button order = new Button("Order");


        //Created an order button which upon pressing it will start the Order event handler.
        order.setOnAction(new Order());


        //Created a label for "quantity", containing argument in its parameter.
        // Created a label for "goods", containing argument in its parameter.
        //Added the quantity, amount, products, order, and output to the GridPane.
        //The items.length + 1, 2, 3, and 4 will be located in its row along with the columns.
        Label quantity = new Label("How much do you want:");
        gp.add(quantity, 0, items.length + 1);
        gp.add(amount, 1, items.length + 1);
        Label goods = new Label("Product:");
        gp.add(goods, 0, items.length + 2);
        gp.add(products, 1, items.length + 2);
        gp.add(order, 1, items.length + 3);
        gp.add(output, 0, items.length + 4, 2, 1);




        //Created a scene named "displayTwo" with the GridPane.
        // The "stage" will get retrieve the scene and window that has the username TextField.
        // The "stage" will display the scene named "displayTwo".
        Scene displayTwo = new Scene(gp, 300, 200);
        Stage stage = (Stage) username.getScene().getWindow();
        stage.setScene(displayTwo);
    }


    //A class named "Order" that'll implement the event handler
    class Order implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
            // The variable "productsName" will obtain the names of each item
            // from "products" TextField by having "products.getText();.
            String productsName = products.getText();


            // The variable "quantity" will obtain the amount of item from "amount" TextField,
            //by having "amount.getText();.
            //However, the input from the "amount" TextField will be converted to integer.
            int quantity = Integer.parseInt(amount.getText());


            // Variable "cost" will retrieve the calculation from "Cost" with the items'name
            //from "productsName" variable and the amount of that specific item
            // "quantity" variable.
            double cost = myStore.Cost(productsName, quantity);


            //Variable "taxes" will calculate the 0.08 from "Taxes" method with the
            // calculated cost from "cost" variable.
            double taxes = myStore.Taxes(cost);


            //Variable "totalCost" will calculate the converted cost and taxes from
            //the "cost" and "taxes" variables.
            double totalCost = myStore.TotalCost(cost, taxes);


            //The "output" label will print out the results stored in cost, taxes,
            //totalCost variables.
            output.setText("Precost: " + cost + " Tax: " + taxes + " Cost: " +totalCost);
        }


    }
}

