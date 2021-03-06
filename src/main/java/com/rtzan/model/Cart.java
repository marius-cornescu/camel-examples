/** Free */
package com.rtzan.model;

import java.util.ArrayList;
import java.util.List;


public class Cart {

    private Customer customer;
    private List<CartItem> cartItems = new ArrayList<>();
    private double discount;

    public Cart(Customer customer) {
        this.customer = customer;
    }

    public void addItem(Product p, int qty) {
        CartItem cartItem = new CartItem(this, p, qty);
        cartItems.add(cartItem);
    }

    public double getDiscount() {
        return discount;
    }

    public void addDiscount(double discount) {
        this.discount += discount;
    }

    public int getTotalPrice() {
        int total = 0;
        for (CartItem item : cartItems) {
            total += item.getProduct().getPrice() * item.getQty();
        }
        return total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getFinalPrice() {
        return getTotalPrice() - (int) getDiscount();
    }

    @Override
    public String toString() {
        return "Cart{" +
            "cartItems=" + cartItems +
            ", discount=" + discount + '}';
    }

}
