package org.cashregister;


import java.util.ArrayList;
import java.util.Date;

public class Customer {

    private String name;
    private String socialSecurityNumber;
    private Membership membership;
    //Sparar alla kundens kvitton
    private final ArrayList<Receipt> receipts = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void becomeMember() {
        membership = new Membership(this);
    }

    public boolean isMember() {
        return membership != null;
    }

    public Membership getMembership() {
        return membership;
    }

    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
    }

    public void returnProduct(Product product, Receipt receipt) {
        receipt.removeProduct(product);
        if(receipt.getProducts().isEmpty()) {
            receipts.remove(receipt);
        }
    }

    public ArrayList<Receipt> getReceipts() {
        return receipts;
    }

    public Receipt getReceipt(Receipt receipt) {
        if(receipts.contains(receipt)) {
            return receipt;
        }
        return null;
    }

}
