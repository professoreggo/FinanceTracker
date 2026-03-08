package com.financetracker;

import com.financetracker.exceptions.InvalidAmountException;
import com.financetracker.models.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Transaction> transactions = new ArrayList<>();



    public static void main(String[] args) {
        System.out.println("Finance tracker Starting to work............");
        System.out.println("Welcome to Finance Tracker App! ");

        boolean running = true;

        while(running){
            printMenu(); //print menu option to choose operation type
            int choice = getMenuChoice();

            switch(choice){
                case 1 :
                    addTransaction("income");
                    break;
                case 2 :
                    addTransaction("expense");
                    break;
                case 3 :
                    viewAllTransaction();
                    break;
                case 4 :
                    viewSummary();
                    break;
                case 5 : {
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                }
                default : System.out.println("Invalid option please select an option from 1-5");
            }
        }
        scanner.close();
    }

    private static void printMenu(){
        System.out.println("\n===== Finance Tracker =====");
        System.out.println("1. Add Income");
        System.out.println("2. Add Expense");
        System.out.println("3. View All Transactions");
        System.out.println("4. View Summary");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static int getMenuChoice(){
        try{
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        } catch(InvalidAmountException e){
            //to do when exception caught
            scanner.nextLine();
            return -1;
        }
    }

    private static String getCategoryOptions(){
        StringBuilder sb = new StringBuilder("[");
        Transaction.Category[] cat = Transaction.Category.values();
        for (int i = 0 ; i< cat.length; i++){
            sb.append(cat[i].name());
            if (i<cat.length-1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    private static void addTransaction(String type){
        try{
            System.out.println("please enter Category"+ getCategoryOptions()+"\n");
            String category = scanner.nextLine().trim().toUpperCase();

            Transaction.Category cat = Transaction.Category.valueOf(category);
            System.out.println("please enter amount: ");
            double amount = Double.parseDouble(scanner.nextLine().trim());

            if (amount <= 0){
                throw new InvalidAmountException("please enter a valid amount!");
            }
            System.out.print("Enter date (YYYY-MM-DD): ");
            String date = scanner.nextLine().trim();

            System.out.print("Enter description: ");
            String description = scanner.nextLine().trim();

            Transaction t = new Transaction(type, cat.name(), amount, date, description);
            transactions.add(t);
            System.out.println("Transaction added!"+t);



        }catch (InvalidAmountException e){
            System.out.println("Invalid amount: " + e.getMessage());

        }catch (IllegalArgumentException e){
            System.out.println("Invalid category. Please use one of: " + getCategoryOptions());

        }

    }

    private static void viewAllTransaction(){
        if(transactions.isEmpty()){
            System.out.println("No transactions made yet");
            return;
        }else{
            System.out.println("List of all transactions:\n");
            for(Transaction t:transactions){
                System.out.println(t);
            }
        }
    }

    private static void viewSummary(){
        double income = 0, expenses=0;
        for(Transaction t: transactions){
            if(t.getType().equals("income")){
                income+=t.getAmount();
            }else{
                expenses+=t.getAmount();
            }
        }

        System.out.println("\n--- Summary ---");
        System.out.println("Total Income:"+ income);
        System.out.println("Total Expenses:"+ expenses);
        System.out.println("Balance:"+ (income - expenses));
    }


}