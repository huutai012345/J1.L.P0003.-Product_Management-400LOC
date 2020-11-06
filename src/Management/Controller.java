/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import java.util.Scanner;

/**
 *
 * @author NHT
 */
public class Controller {

    private Process process;

    public Controller(Process process) {
        this.process = process;
    }

    public void menu() {
        System.out.println("\n\t\t MENU \n");
        System.out.println("1.  Add Category");
        System.out.println("2.  Update Cateogry");
        System.out.println("3.  Delete Category");
        System.out.println("4.  Add Product");
        System.out.println("5.  Update Product");
        System.out.println("6.  Delete Product");
        System.out.println("7.  Order Product");
        System.out.println("8.  Print All Category");
        System.out.println("9.  View Order List");
        System.out.println("10. Show Order List Report");
        System.out.println("0.  Exit");
        System.out.print("Chose: ");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int luaChon = 0;
        while (true) {
            menu();
            luaChon = sc.nextInt();
            System.out.println("");
            switch (luaChon) {
                case 1:
                    this.process.addCate();
                    break;
                case 2: {
                    this.process.updateCate();
                    break;
                }
                case 3:
                    this.process.deleteCate();
                    break;
                case 4: {
                    this.process.addProduct();
                    break;
                }
                case 5: {
                    this.process.updateProduct();
                    break;
                }
                case 6: {
                    this.process.deleteProduct();
                    break;
                }
                case 7: {
                    this.process.orderProduct();
                    break;
                }
                case 8: {
                    this.process.printCates();
                    break;
                }
                case 9: {
                    this.process.printOrders();
                    break;
                }
                case 10: {
                    this.process.printProducts();
                    break;
                }
                case 0:
                    this.process.saveFileCate();
                    this.process.saveFileProduct();
                    return;

                default:
                    System.out.println("Input invail");
                    break;
            }
        }
    }
}
