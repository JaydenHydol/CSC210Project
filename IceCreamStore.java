package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

// A public class named IceCreamStore three string type arrays, one double type array, and a double type field.
public class IceCreamStore {
    String[] username = {"Wendy"};
    String[] password = {"1120 Flatbush"};
    String[] items = {"Vanilla", "Chocolate", "Mint", "Strawberry"};
    double[] prices = {10.99, 11.24, 5.24, 7.00};
    double taxRate = 0.08;


    // A string method named Username that retrieves a name,"Wendy",
    // from the String username array by returning 0.
    public String Username()
    {
        return username[0];
    }


    // A string method named Password that retrieves a name,"1120 Flatbush",
    // from the String pasword array by returning 0.
    public String Password()
    {
        return password[0];
    }


    // A string method named Item that retrives all the items'names from the String items array.
    // Created a For Loop to print out the names for each item from the array.
    //Since I want to return the items' names, i must have [] besides the "String" Keyword,
    // Without it, it'll cause an error.
    public String[] Item()
    {
        // Continues to loop four times from the double items array list.
        for (int i = 0; i < items.length; i++)
        {
            // Prints the items' names.
            System.out.println(items[i]);
        }
        // returns the names for each item.
        return items;
    }


    // A method named Price that retrives the prices for all items from the Double prices array.
    public double Price(String item) {
        //Created a For Loop to print out the prices for each item from the array.
        for (int i = 0; i < items.length; i++) {
            //"equalsIgnoreCase" would verify if the items names matches the names
            // from the array list, despite if they are uppercased or lowercased.
            if (items[i].equalsIgnoreCase(item))
            {
                // Once it finds the names from the items'array list,
                //It'll give the prices of each item.
                return prices[i];
            }
        }
        //If it doesn't find the names from items' array list, it'll give -1, or not found.
        return -1;
    }


    // This double method "Cost" contains a For Loop that sums up the items' prices
    // with the amount of that item.
    // The "Cost" method contains the "String item" and "int quantity" in its parameter.
    public double Cost(String item, int quantity)
    {
        //The varaible "price" will obtain the price of each item from "Price" method.
        double price = Price(item);
        //If the item wasn't found, it'll equal to -1, meaning not found.
        if (price == -1) {
            return -1;
        }
        //if the item was found, it'll multiply the price of the item and its amount.
        return price * quantity;
    }


    // This method will multiply the cost, from the Cost method, with the tax rate, w
    // hich is equal to 0.08.
    public double Taxes(double cost) {
        return cost * taxRate;
    }


    // The TotalCost method will add the newCost from the Cost method and taxes
    // from the Taxes method.
    public double TotalCost(double cost, double taxes) {
        return cost + taxes;
    }
}

