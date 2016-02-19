package entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer_order")
public class Order
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;

	@OneToMany(mappedBy = "order")//, cascade = CascadeType.PERSIST)
	private List<OrderDetail> orderDetails;

	@ManyToOne
	@JoinColumn(name = "customer_email")
	private Customer customer;
	

	private Timestamp dateOrdered;

	private String status;

	public Timestamp getDateOrdered()
	{
		return dateOrdered;
	}
	
	public void setOrderId(int id) {
		this.orderId = id;
	}
	public void setDateOrdered(Timestamp dateOrdered)
	{
		this.dateOrdered = dateOrdered;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public int getOrderId()
	{
		return orderId;
	}

	@Override
	public String toString()
	{
		return "Order [orderId=" + orderId + ", customerEmail=" + customer.getEmail() + ", dateOrdered=" + dateOrdered
				+ ", status=" + status + "]";
	}

	public List<OrderDetail> getOrderDetails()
	{
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails)
	{
		this.orderDetails = orderDetails;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
}
