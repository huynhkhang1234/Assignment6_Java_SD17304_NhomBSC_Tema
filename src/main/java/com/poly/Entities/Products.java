package com.poly.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name ="products")
public class Products implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titles;
	private int price;
	private String images;
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")	
	private Date create_date;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	private Date update_date;
	private int is_active;
	private int is_status;
	private int original_price;

	// khóa chính
	@JsonIgnore
	@OneToMany(mappedBy = "products")
	List<Likes> likes;

	// khóa chính
	@JsonIgnore
	@OneToMany(mappedBy = "products")
	List<Order_details> order_details;

	// khóa chính
	@JsonIgnore
	@OneToMany(mappedBy = "products")
	List<Galleries> galleries;
	// khóa ngoại
	@ManyToOne
	@JoinColumn(name = "categories_id")
	Categories categories;

	// khóa ngoại
	@ManyToOne
	@JoinColumn(name = "suppliers_id")
	Suppliers suppliers;
	// khóa ngoại
	@ManyToOne
	@JoinColumn(name = "discounts_id")
	Discounts discounts;
	
	@Override
	public String toString() {
		return "Products{" + "titles" + titles+'}';
	}

}
