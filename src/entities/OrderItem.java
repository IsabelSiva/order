package entities;

public class OrderItem {
    private int quantity;
    private Product product;

    public OrderItem(){}

    public OrderItem(int quantity,Product product){
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double subTotal(){
        return quantity * product.getPrice();
    }

    @Override
    public String toString() {
        StringBuilder orderItem = new StringBuilder();
        orderItem.append(quantity);
        orderItem.append(product);
        return orderItem.toString();
    }
}
