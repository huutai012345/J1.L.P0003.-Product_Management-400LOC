/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import Model.Category;
import Model.Order;
import Model.OrderDetail;
import Model.Product;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NHT
 */
public class Process {

    private ArrayList<Category> categorys;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;

    public Process() {
        categorys = new ArrayList<>();
        products = new ArrayList<>();
        orders = new ArrayList<>();
        this.loadFileCate();
        this.loadFileProduct();
    }

    public boolean checkContinue() {
        String chose = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want continue(y/n):");
        chose = sc.nextLine();
        return "y".equals(chose);
    }

    public boolean checkContinueOrder() {
        String chose = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to order now(y/n):");
        chose = sc.nextLine();
        return "n".equals(chose);
    }

    public boolean checkDelete() {
        String chose = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want delete (y/n):");
        chose = sc.nextLine();
        return "y".equals(chose);
    }

    public void checkExistCate() {
        Scanner sc = new Scanner(System.in);
        do {
            String cateID;
            Category cate = null;

            System.out.print("Enter Cate ID(-1 to Exit):");
            cateID = sc.nextLine();
            if ("-1".equals(cateID)) {
                return;
            }
            cate = getCate(cateID);
            if (cate == null) {
                System.out.println("“No User Found!");
            } else {
                System.out.println("Exist User");
            }
        } while (this.checkContinue());
    }

    public Category getCate(String id) {
        for (Category cate : categorys) {
            if (cate.getId().equals(id)) {
                return cate;
            }
        }
        return null;
    }

    public Product getProduct(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void addCate() {
        Scanner sc = new Scanner(System.in);
        do {
            Category cate;
            String idCate;
            do {
                System.out.print("Enter ID Category(-1 to Exit): ");
                idCate = sc.nextLine();
                if ("-1".equals(idCate)) {
                    return;
                }
                cate = getCate(idCate);
                if (cate != null) {
                    System.out.println("Cate exist");
                }
            } while (cate != null);

            Category newCate = new Category();
            newCate.input(idCate);

            categorys.add(newCate);

        } while (this.checkContinue());

    }

    public void updateCate() {
        Scanner sc = new Scanner(System.in);
        do {
            Category cate;
            String idCate;

            do {
                System.out.print("Enter ID Category(-1 to Exit): ");
                idCate = sc.nextLine();
                if ("-1".equals(idCate)) {
                    return;
                }
                cate = getCate(idCate);
                if (cate == null) {
                    System.out.println("Cate does not exist");
                }
            } while (cate == null);

            cate.update();

        } while (this.checkContinue());

    }
    
    public boolean checkDeleteCate(String id)
    {
        for (Product product : products) {
            if(product.getIdCate().equals(id))
            {
                return false;
            }
        }
        return true;
    }
    
    public void deleteCate() {
        Scanner sc = new Scanner(System.in);
        do {
            Category cate;
            String idCate;

            do {
                System.out.print("Enter ID Category(-1 to Exit): ");
                idCate = sc.nextLine();
                if ("-1".equals(idCate)) {
                    return;
                }
                cate = getCate(idCate);
                if (cate == null) {
                    System.out.println("Cate does not exist");
                }
                if(!checkDeleteCate(idCate))
                {
                    System.out.println("Cate is referenced in Product List");
                }
            } while (cate == null || !checkDeleteCate(idCate));

            if (this.checkDelete()) {
                this.categorys.remove(cate);
                System.out.println("Succes");
            }
        } while (this.checkContinue());
    }

    public void printCates() {
        if (categorys.isEmpty()) {
            System.out.println("List Category is empty");
        } else {
            System.out.printf("%-20s%-20s\n", "ID", "Name");

            for (Category category : categorys) {
                category.print();
            }
            System.out.println("---------------------------------");
        }
    }

    public void addProduct() {
        Scanner sc = new Scanner(System.in);
        do {
            Product product;
            Category cate;
            String idCate, idProduct;

            do {
                System.out.print("Enter ID Category(-1 to Exit): ");
                idCate = sc.nextLine();
                if ("-1".equals(idCate)) {
                    return;
                }

                cate = getCate(idCate);
                if (cate == null) {
                    System.out.println("Category does not exist");
                }
            } while (cate == null);

            do {
                System.out.print("Enter ID Product(-1 to Exit): ");
                idProduct = sc.nextLine();
                if ("-1".equals(idProduct)) {
                    return;
                }
                product = getProduct(idProduct);
                if (product != null) {
                    System.out.println("Product exist");
                }
            } while (product != null);

            Product newProduct = new Product();
            newProduct.input(idProduct, idCate);

            products.add(newProduct);

        } while (this.checkContinue());
    }

    public void updateProduct() {
        Scanner sc = new Scanner(System.in);
        do {
            Product product;
            String id;
            do {
                System.out.print("Enter ID Product(-1 to Exit): ");
                id = sc.nextLine();
                if ("-1".equals(id)) {
                    return;
                }
                product = getProduct(id);
                if (product == null) {
                    System.out.println("Product does not exist");
                }
            } while (product == null);

            product.update();

        } while (this.checkContinue());
    }

    public void deleteProduct() {
        Scanner sc = new Scanner(System.in);
        do {
            Product product;
            String id;
            do {
                System.out.print("Enter ID Product(-1 to Exit): ");
                id = sc.nextLine();
                if ("-1".equals(id)) {
                    return;
                }
                product = getProduct(id);
                if (product == null) {
                    System.out.println("Product does not exist");
                }
            } while (product == null);

            if (this.checkDelete()) {
                this.products.remove(product);
                System.out.println("Succes");
            }
        } while (this.checkContinue());
    }

    public void printProducts() {
        if (products.isEmpty()) {
            System.out.println("List Product is empty");
        } else {
            System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "ID", "Name", "Price", "Quantity", "ID Cate");
            products.forEach((product) -> {
                product.print();
            });
            System.out.println("---------------------------------");
        }
    }

    public void printProductOrder() {

        int id = 1;
        System.out.printf("%-20s%-20s%-20s\n", "No", "Product name", "Price");
        for (Product product : products) {
            product.print1(id);
            id++;
        }
        System.out.println("---------------------------------");

    }

    private Product getProductByNo(int no) {
        int tempNo = 1;
        for (Product product : products) {
            if (tempNo == no) {
                return product;
            }
            tempNo++;
        }
        return null;
    }

    public void printAllOrder() {
        orders.forEach((order) -> {
            order.printAllOrderDetail();
        });
    }

    public void orderProduct() {
        Scanner sc = new Scanner(System.in);
        do {
            int chose = 0;
            String name;
            int quantity;
            ArrayList<OrderDetail> orderDetails = new ArrayList<>();

            do {
                printProductOrder();
                do {
                    System.out.print("Chose:");
                    chose = sc.nextInt();
                    if (chose < 1 || chose > products.size() ) {
                        System.out.println("Input invalid");
                    }
                } while (chose < 1 || chose > products.size() );

                Product product = getProductByNo(chose);

                System.out.println("You selected: " + product.getName());
                System.out.print("Please input quantity: ");
                quantity = sc.nextInt();

                if (product.getQuantity() < quantity) {
                    System.out.println("Quantity not enough");
                } else {
                    product.setQuantity(product.getQuantity() - quantity);
                    OrderDetail orderDetail = new OrderDetail(product, quantity);
                    orderDetails.add(orderDetail);
                }

            } while (this.checkContinueOrder());

            sc.nextLine();
            System.out.print("Input your name: ");
            name = sc.nextLine();

            System.out.printf("%-20s%-20s%-20s%-20s\n", "Product", "Quantity", "Price", "Amount");
            Order order = new Order(name, orderDetails);
            order.printAllOrderDetail();
            System.out.println("Total: " + order.getTotalAmount() + " $");

            orders.add(order);

        } while (this.checkContinue());
    }

    public void printOrders() {
        if (orders.isEmpty()) {
            System.out.println("List Order Is Empty");
        } else {
            orders.forEach((orther) -> {
                orther.printOrders();
            });
        }

    }

    public Category getDataCate(String str) {
        String[] words = str.split("\\s");
        return new Category(words[0], words[1]);
    }

    public Product getDataProduct(String str) {
        String[] words = str.split("\\s");
        return new Product(words[0], words[1], Float.parseFloat(words[2]), Integer.parseInt(words[3]), words[4]);
    }

    private void loadFileCate() {
        try {
            File myObj = new File("D:\\Code\\Java\\NetBeansProjects\\J1.L.P0003.-Product_Management-400LOC\\src\\Database\\category.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                categorys.add(getDataCate(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    private void loadFileProduct() {
        try {
            File myObj = new File("D:\\Code\\Java\\NetBeansProjects\\J1.L.P0003.-Product_Management-400LOC\\src\\Database\\product.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                products.add(getDataProduct(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public void saveFileCate() {
        try {
            try (FileWriter myWriter = new FileWriter("D:\\Code\\Java\\NetBeansProjects\\J1.L.P0003.-Product_Management-400LOC\\src\\Database\\product.txt")) {
                for (Category cate : categorys) {
                    myWriter.write(cate.getId() + " " + cate.getName() + "\n");
                }
            }
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void saveFileProduct() {
        try {
            try (FileWriter myWriter = new FileWriter("D:\\Code\\Java\\NetBeansProjects\\J1.L.P0003.-Product_Management-400LOC\\src\\Database\\product.txt")) {
                for (Product product : products) {
                    myWriter.write(product.getId() + " " + product.getName() + " " + product.getPrice() + " " + product.getQuantity() + " " + product.getIdCate() + " " + "\n");
                }
            }
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
