package com.financetracker.models;

public class Transaction implements Comparable<Transaction>{

    private String type;
    private String category;
    private double amount;
    private String date;
    private String description;

    public Transaction(String type, String category, double amount, String date, String description) {
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public String getCategory() {return category;}

    public void setCategory(String category) {this.category = category;}

    public double getAmount() {return amount;}

    public void setAmount(double amount) {this.amount = amount;}

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int compareTo(Transaction other) {
        return Double.compare(this.amount, other.amount);
    }

    public enum Category{
        FOOD,
        RENT,
        SALARY,
        OTHER
    }

}
