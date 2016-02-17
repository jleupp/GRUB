package client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import entities.Menu;

@Entity 
@Table(name="menu_item")
public class MenuItem
{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private Double price;
	private String description;
	
	@Column(name="rest_id")
	private int restId;
	
	@ManyToOne
	@JoinColumn(name="menu_id", referencedColumnName="menu_id")
	private Menu menu;
	
	@ManyToOne
	@JoinColumn(name="menusection_id", referencedColumnName="id")
	private MenuSection section;
	
	 public enum TEMP
	 {
		 NORMAL,R,MR,M,MW,W
	    }
	    @Enumerated(EnumType.STRING)
	    @Column(name="temp_id")
	    private TEMP temp;
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Double getPrice()
	{
		return price;
	}
	public void setPrice(Double price)
	{
		this.price = price;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public int getRestId()
	{
		return restId;
	}
	public void setRestId(int restId)
	{
		this.restId = restId;
	}
	public TEMP getTemp()
	{
		return temp;
	}
	public void setTemp(TEMP temp)
	{
		this.temp = temp;
	}
	
	public Menu getMenu()
	{
		return this.menu;
	}
	public void setMenu(Menu menu)
	{
		this.menu = menu;
	}
	public int getId()
	{
		return id;
	}
	public MenuSection getSection() {
		return section;
	}
	public void setSection(MenuSection section) {
		this.section = section;
	}
	@Override
	public String toString()
	{
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", restId=" + restId + ", temp=" + temp.toString() + ", menuSection=" + section.getSection() + ", menuTyep="
				+ menu.getType() + "]";
	}
}
