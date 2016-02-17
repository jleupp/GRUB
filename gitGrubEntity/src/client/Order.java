package client;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cutomer_order")
public class Order
{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	
	@OneToMany(mappedBy= "order")
	private List <OrderDetail> orderDetails;
	
	@Column(name="customer_email")
	private String customerEmail;
	
	private Date dateOrdered;
	
	private String status;

	public String getCustomerEmail()
	{
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail)
	{
		this.customerEmail = customerEmail;
	}

	public Date getDateOrdered()
	{
		return dateOrdered;
	}

	public void setDateOrdered(Date dateOrdered)
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
		return "Order [orderId=" + orderId + ", customerEmail=" + customerEmail + ", dateOrdered=" + dateOrdered
				+ ", status=" + status + "]";
	}
}
