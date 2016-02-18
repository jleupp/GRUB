package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetail
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderDeet_id")
	private int orderDeetId;
	private int lineItem;
	private int quantity;

	@OneToOne
	@JoinColumn(name = "menuItems_id", referencedColumnName = "id")
	private MenuItem menuItem;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

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

	public int getOrderDeetId()
	{
		return orderDeetId;
	}

	@Override
	public String toString()
	{
		return "OrderDetail [orderDeetId=" + orderDeetId + ", lineItem=" + lineItem + ", quantity=" + quantity + "]";
	}

	public MenuItem getMenuItem()
	{
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem)
	{
		this.menuItem = menuItem;
	}

	public Order getOrder()
	{
		return order;
	}

	public void setOrder(Order order)
	{
		this.order = order;
	}
}
