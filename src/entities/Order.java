package entities;

import entities.enums.OrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;

    private Client client;

    private List<OrderItem> items = new ArrayList<>();

    public Order(){}

    public Order(Date moment, OrderStatus status, Client client){
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public double total(){
        double sum = 0;
        for (OrderItem item : items){
            sum += item.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        double sum = 0;
        StringBuilder order = new StringBuilder();
        order.append("order moment: " + moment + "\n");
        order.append("order status: " + status+ "\n");
        order.append("client data: " + client+ "\n");
        order.append("order intems: " + items+ "\n");
        for (OrderItem item : items){
            order.append(item);
            sum += sum + item.subTotal();
        }
        order.append("total value: " + sum);

        return order.toString();
    }
}
