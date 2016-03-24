package io.pivotal.workshop.questrade.model;

import java.io.Serializable;

public class Order implements Serializable {

	private static final long serialVersionUID = -8215568253720227952L;

    private int id;
    private long customerId;
    private int quantity;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	} 
    
}
