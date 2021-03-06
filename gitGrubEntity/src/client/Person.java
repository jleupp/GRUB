package client;

import entities.Access;
import entities.Order;

public interface Person {
	public String getEmail();
	public String getPassword();
	public String getPhone();
	public Access getAccess();
	public void setEmail(String email);
	public void setPassword(String pw);
	public void setPhone(String phone);
	public void setAccess(Access access);
	public Order getPendingOrder();
	

}
