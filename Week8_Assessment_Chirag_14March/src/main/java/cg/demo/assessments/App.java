package cg.demo.assessments;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import cg.demo.entitites.Order;

public class App {

    static OrderDao dao = new OrderDaoImpl();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String opt;

        do {

            System.out.println("1-ADD");
            System.out.println("2-VIEW BY ORDER ID");
            System.out.println("3-VIEW BY CUSTOMER NAME");

            int choice = sc.nextInt();

            processMenu(choice);

            System.out.println("press y to continue");
            opt = sc.next();

        } while(opt.equalsIgnoreCase("y"));
    }

    public static void processMenu(int mtype) {

        switch(mtype) {

            case 1:
                addOrder();
                break;

            case 2:
                viewOrderByOrderID();
                break;

            case 3:
                viewOrdersByCustName();
                break;

            default:
                System.out.println("Invalid option");
        }
    }

    public static void addOrder() {

        Order order = new Order();

        System.out.println("Enter Customer ID");
        int custId = sc.nextInt();

        System.out.println("Enter Order Amount");
        order.setOrderAmt(sc.nextDouble());

        order.setOrderDate(LocalDateTime.now());

        boolean status = dao.addOrder(order, custId);

        if(status)
            System.out.println("Order Added Successfully");
        else
            System.out.println("Failed to Add Order");
    }

    public static void viewOrderByOrderID() {

        System.out.println("Enter Order ID");

        int id = sc.nextInt();

        Order order = dao.getOrder(id);

        if(order != null)
            System.out.println("Order ID: " + order.getOrderId()
                    + " Amount: " + order.getOrderAmt()
                    + " Date: " + order.getOrderDate());
        else
            System.out.println("Order Not Found");
    }

    public static void viewOrdersByCustName() {

        System.out.println("Enter Customer Name");

        String name = sc.next();

        List<Order> list = dao.getOrders(name);

        if(list.isEmpty())
            System.out.println("No Orders Found");

        for(Order o : list)
            System.out.println("Order ID: "+o.getOrderId()
                    +" Amount: "+o.getOrderAmt());
    }
}