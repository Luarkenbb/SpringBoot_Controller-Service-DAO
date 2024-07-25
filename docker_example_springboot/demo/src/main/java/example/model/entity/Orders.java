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
@Table(name = "orders")
public class Orders {
	@Id
	@Column(name = "order_number", nullable = false)
	private int orderNumber;
	
	@Column(name = "order_date", nullable = false)
	private Date orderDate;
	
	@Column(name = "required_date", nullable = false)
	private Date requiredDate;
	
	@Column(name = "shipped_date")
	private Date shippedDate;
	
	@Column(name = "status", length = 15 ,nullable = false)
	private String status;
	
	@Column(name = "comments")
	private String comments;
	
	@ManyToOne
	@JoinColumn(name = "customer_number", nullable = false)
	private Customers customerNumber;
}
