package com.poly.Entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
	@Temporal(TemporalType.TIMESTAMP)
	private Date create_date;
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_date;
	private int is_active;
	
	@ManyToOne
	@JoinColumn(name="orders_id")
	Orders orders;
	
	@ManyToOne
	@JoinColumn(name="products_id")
	 Products products;
	

}
