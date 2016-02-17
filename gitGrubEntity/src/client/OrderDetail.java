package client;

import javax.persistence.*;

@Entity 
@Table(name="order_detail")
public class OrderDetail
{
	@Id 
	@Column(name="orders_id")
	private int ordersId;
	@Column(name="menuItems_id")
	private int menuItemsId;
	private int lineItem;
	private int quantity;
	
//	@OneToOne
//	@JoinColumn(name="menuItems_id")
//	private 
	
	
	public int getLineItem()
	{
		return lineItem;
	}
	public void setLineItem(int lineItem)
	{
		this.lineItem = lineItem;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public int getOrdersId()
	{
		return ordersId;
	}
	public int getMenuItemsId()
	{
		return menuItemsId;
	}
	@Override
	public String toString()
	{
		return "OrderDetail [ordersId=" + ordersId + ", menuItemsId=" + menuItemsId + ", lineItem=" + lineItem
				+ ", quantity=" + quantity + "]";
	}
}
