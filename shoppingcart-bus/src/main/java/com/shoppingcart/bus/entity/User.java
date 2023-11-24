package com.shoppingcart.bus.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@JsonProperty
	@Getter
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty
	@Getter
	@Setter
	@Column(name = "user")
	private String user;
	
	@JsonProperty
	@Getter
	@Setter
	@Column(name = "password")
	private String password;
	
	@JsonProperty
	@Getter
	@Setter
	@Column(name = "token")
	private String token;
	
	@JsonManagedReference
	@Getter
	@Setter
	@OneToMany(mappedBy = "user")
	private List<Order> ordersList = new ArrayList<>();
}
