package com.poly.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name ="order_details")
public class Order_details  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int price;
	private int quanlity;
	private float sum_money;
	private Date create_date;
	private Date update_date;
	private int is_active;
	
	@ManyToOne
	@JoinColumn(name="orders_id")
	Orders orders;
	
	@ManyToOne
	@JoinColumn(name="products_id")
	 Products products;
	

}
