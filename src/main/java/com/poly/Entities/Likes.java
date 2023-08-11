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
@Table(name ="likes")
public class Likes implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int is_likes;
	private Date create_like;

	// khóa ngoại
	@ManyToOne
	@JoinColumn(name = "users_id")
	Users users;

	@ManyToOne
	@JoinColumn(name = "products_id")
	Products products;
	
	 @Override
	    public String toString() {
	        return "Likes{" +
	               "id=" + id +'}';
	    }
}
