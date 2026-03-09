package com.financetracker.services;

import com.financetracker.models.Transaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TransactionService {

    private final List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction t){
        transactions.add(t);
    }

    public List<Transaction> getAllTransactions(){
        return transactions;
    }


    public double getTotalIncome() {
        double total = 0;
        for(Transaction t:transactions){
            if(t.getType().equals("income")){
                total+=t.getAmount();
            }
        }
        return total;
    }


    public double getTotalExpenses() {
        double total = 0;
        for(Transaction t:transactions){
            if(t.getType().equals("expense")){
                total+=t.getAmount();
            }
        }
        return total;
    }

    public List<Transaction> filterByCategory(String category) {
        List<Transaction> filtered = new ArrayList<>();
        for(Transaction t:transactions){
            if(t.getCategory().equalsIgnoreCase(category)){
                filtered.add(t);
            }
        }
        return filtered;

    }

    public List<Transaction> getSortByAmount(){
        List<Transaction> sorted = new ArrayList<>(transactions);
        Collections.sort(sorted);
        return sorted;
    }
}
