package com.poly.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

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
@Table(name = "news")
public class News implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titles;
	private String contents;
	private String video_href;
	private String images;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date create_date;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_date;
	
	private int is_active;

	// khóa ngoại
	@ManyToOne
	@JoinColumn(name = "categories_id")
	Categories_news categories_news;

	@ManyToOne
	@JoinColumn(name = "users_id")
	Users users;

	@Override
	public String toString() {
		return "News{" + "id=" + id + '}';
	}

}
