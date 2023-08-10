package com.poly.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "histories")
public class Histories implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private Date create_date;
	private Date update_date;
	private int is_active;
	
	//khóa ngoại
	@ManyToOne
	@JoinColumn(name="orders_id")
	Orders orders;
	
	//khóa ngoại
	@ManyToOne
	@JoinColumn(name="users_id")
	Users users;
	
}
