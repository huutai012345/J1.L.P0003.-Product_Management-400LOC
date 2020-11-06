/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author NHT
 */
public class OrderDetail {
   
    private Product product;
    private int quantity;
    private float amount;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
   
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public OrderDetail() {
    }

    public OrderDetail(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.amount = product.getPrice()*quantity;
    }
    
    public void print()
    {
        System.out.printf("%-20s%-20d%-20f%-20f\n",product.getName(),quantity,product.getPrice(),amount);
    }
}
