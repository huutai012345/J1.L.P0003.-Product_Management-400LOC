/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Scanner;

/**
 *
 * @author NHT
 */
public class Product {

    private String id;
    private String name;
    private float price;
    private int quantity;
    private String idCate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getIdCate() {
        return idCate;
    }

    public void setIdCate(String idCate) {
        this.idCate = idCate;
    }

    public Product() {
    }

    public Product(String id, String name, float price, int quantity, String idCate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.idCate = idCate;
    }
    
    
    public void input(String idProduct,String idCate) {
        Scanner sc = new Scanner(System.in);

        this.id = idProduct;
        this.idCate=idCate;
        
        System.out.print("Enter Name Product: ");
        this.name = sc.nextLine();
        System.out.print("Enter Price Product: ");
        this.price = sc.nextFloat();
        System.out.print("Enter Quantity Product: ");
        this.quantity = sc.nextInt();
    }

    public void update() {
        String namePro, idCatePro;
        float pricePro = (float) -1.0;
        int quantityPro = -1;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name Product: ");
        namePro = sc.nextLine();
        if (!namePro.isEmpty()) {
            this.name = namePro;
        } else {
            System.out.println("Fail");
            return;
        }

        System.out.print("Enter Price Product: ");
        this.price = sc.nextFloat();
        if (pricePro > 0) {
            this.price = pricePro;
        } else {
            System.out.println("Fail");
            return;
        }

        System.out.print("Enter Quantity Product: ");
        quantityPro = sc.nextInt();
        if (quantityPro > 0) {
            this.quantity = quantityPro;
        } else {
            System.out.println("Fail");
            return;
        }

        System.out.print("Enter ID Cate: ");
        idCatePro = sc.nextLine();
        if (!idCatePro.isEmpty()) {
            this.idCate = idCatePro;
        } else {
            System.out.println("Fail");
            return;
        }

        System.out.println("Sucess");
    }

    public void print() {
        System.out.printf("%-20s%-20s%-20f%-20d%-20s\n", this.id, this.name, this.price, this.quantity, this.idCate);
    }
    
    public int print1(int id) {
        System.out.printf("%-20d%-20s%-20f\n", id, this.name, this.price);
        id++;
        return id;
    }
}
