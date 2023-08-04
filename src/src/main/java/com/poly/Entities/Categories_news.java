
package com.poly.Entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name ="categories_news")
public class Categories_news implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titles;
	private int is_active;

	// khóa chính
	@JsonIgnore
	@OneToMany(mappedBy ="categories_news")
	List<News> news;

	 @Override
	    public String toString() {
		 return "Categories_news{" +
		           "id=" + id +
		           ", name='" + titles +
		           ", news count='" + news.size() +
		           '}';
	   }
}
