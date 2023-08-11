package com.poly.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name ="orders")
public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String notes;
	private String status;
	private Float sum_money;
	@Temporal(TemporalType.TIMESTAMP)
	private Date create_date;
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_date;
	private float money_received;
	private int is_active;

	// khóa chính
	@JsonIgnore
	@OneToMany(mappedBy = "orders")
	List<Products_reviews> products_reviews;

	// khóa chính
	@JsonIgnore
	@OneToMany(mappedBy = "orders")
	List<Order_details> order_details;

	// khóa chính
	@JsonIgnore
	@OneToMany(mappedBy = "orders")
	List<Histories> histories;
	// khóa ngoại
	@ManyToOne
	@JoinColumn(name ="users_id")
	Users users;
	
	@Override
	public String toString() {
		return "Orders{" +"id"+id+'}';
	}
}
