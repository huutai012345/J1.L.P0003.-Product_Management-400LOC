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
public class Category {
    private String id;
    private String name;

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

    public Category() {
    }

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public void input(String id)
    {
        Scanner sc =new Scanner(System.in);
        this.id=id;
        System.out.print("Enter Category Name:");
        this.name=sc.nextLine();
    }
    
    public void update()
    {
        String nameCate;
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter Category Name:");
        nameCate=sc.nextLine();
        if(!nameCate.isEmpty())
        {
            this.name=nameCate;
        }
        else
        {
            System.out.println("Fail");
            return ;
        }
        
        System.out.println("Succes");
    }
    
    public void print()
    {
        System.out.printf("%-20s%-20s\n",this.id,this.name);
    }
    
}
