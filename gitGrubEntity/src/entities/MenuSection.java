package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="menu_section")
public class MenuSection implements Comparable<MenuSection> {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	private String section;
	
	@OneToMany(mappedBy="section")
	private List<MenuItem> items;
	
	public int getId() {
		return id;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
	public List<MenuItem> getSectionItems() {
		return this.items;
	}
	
	public void addItemToSection(MenuItem item) {
		this.items.add(item);
	}
	
	public int compareTo(MenuSection section) {
		return this.id.compareTo(section.getId());
	}
}
