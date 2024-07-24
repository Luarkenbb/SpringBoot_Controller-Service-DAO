package example.model.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Orders")
public class Orders {
	@Id
	@Column(name = "orderNumber", nullable = false)
	private int orderNumber;
	
	@Column(name = "orderDate", nullable = false)
	private Date orderDate;
	
	@Column(name = "requiredDate", nullable = false)
	private Date requiredDate;
	
	@Column(name = "shippedDate")
	private Date shippedDate;
	
	@Column(name = "status", length = 15 ,nullable = false)
	private String status;
	
	@Column(name = "comments")
	private String comments;
	
	@ManyToOne
	@JoinColumn(name = "customerNumber", nullable = false)
	private Customers customerNumber;
}
