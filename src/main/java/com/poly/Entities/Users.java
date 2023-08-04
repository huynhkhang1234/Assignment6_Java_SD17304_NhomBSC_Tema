	package com.poly.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "users")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String user_names;
	private String first_names;
	private String last_names;
	private String email;
	private String pass_words;
	private String images;
	private String phones;
	private String address;

	private Date create_date;
	private Date update_date;
	private int is_active;
	// khóa chính
	@JsonIgnore
	@OneToMany(mappedBy = "users")
	List<News> news;
	
	@JsonIgnore
	@OneToMany(mappedBy = "users")
	List<Likes> likes;

	@JsonIgnore
	@OneToMany(mappedBy = "users")
	List<Products_reviews> product_reviews;

	@JsonIgnore
	@OneToMany(mappedBy = "users")
	List<Orders> orders;

	@JsonIgnore
	@OneToMany(mappedBy = "users")
	List<Histories> histories;
	// khóa ngoại
	@ManyToOne
	@JoinColumn(name = "roles_id")
	Roles roles;

	@Override
	public String toString() {
		return "Users{" + "user_names=" + id + '}';
	}

}
