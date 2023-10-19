package org.cashregister;

import java.util.ArrayList;

public class Receipt {

    public Customer customer;
    public ArrayList<Product> products = new ArrayList<Product>();
    public double value;
    public String tag;

    public Receipt(String tag){
        this.tag = tag;
    }

    public Receipt(double value, String tag){
        this.value = value;
        this.tag = tag;
    }

    public double getValue(){

        return value;
    }

    public void setValue(Double newValue){

        value = newValue;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
        value = value + product.getPrice();
    }

    public void removeProduct(Product product){
        products.remove(product);
        value = value - product.getPrice();
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Product product: products){
            stringBuilder.append(product.toString());
        }

        return stringBuilder.toString();
    }


    //
    public String toString(){
        return "Total cost: " + getValue();
    }

}
