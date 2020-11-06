/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author NHT
 */
public class Order {

    private String nameCustomer;
    private ArrayList<OrderDetail> orderDetials;

    public Order(String nameCustomer, ArrayList<OrderDetail> orderDetials) {
        this.nameCustomer = nameCustomer;
        this.orderDetials = orderDetials;
    }

    public Order() {
    }

    public void printAllOrderDetail() {
        orderDetials.forEach((orderDetial) -> {
            Product product = orderDetial.getProduct();
            System.out.printf("%-20s%-20d%-20f%-20f\n", product.getName(), orderDetial.getQuantity(), product.getPrice(), orderDetial.getAmount());
        });
    }

    public void printOrders() {
        float sum = 0;
        System.out.println("Customer: " + this.nameCustomer);

        System.out.printf("%-20s%-20s%-20s%-20s\n", "Product", "Quantity", "Price", "Amout");

        for (OrderDetail orderDetial : orderDetials) {
            sum += orderDetial.getAmount();
            orderDetial.print();
        }

        System.out.println("Total: " + sum);
        System.out.println("-------------------------------------------------------------------------------------------------------------");
    }
    
    public float getTotalAmount()
    {
        float sum=0;
        
        for (OrderDetail orderDetial : orderDetials) {
            sum += orderDetial.getAmount();
        }
        
        return sum;
    }

}
