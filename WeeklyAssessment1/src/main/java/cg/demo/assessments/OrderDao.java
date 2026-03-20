package cg.demo.assessments;

import java.util.List;

import cg.demo.entitites.Order;

public interface OrderDao {
	public boolean addOrder(Order order,int custid);
	public Order getOrder(int orderId);
	public List<Order> getOrders(String custName);
}
