package cg.demo.entitites;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "abes_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "order_amt")
    private double orderAmt;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public int getOrderId() {
        return orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public double getOrderAmt() {
        return orderAmt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderAmt(double orderAmt) {
        this.orderAmt = orderAmt;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}