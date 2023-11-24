package com.shoppingcart.bus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "details")
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

	@JsonProperty
	@Getter
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonBackReference
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@JsonProperty
	@Getter
	@Setter
	@Column(name = "productId")
	private Long productId;
	
	@JsonProperty
	@Getter
	@Setter
	@Column(name = "quantity")
	private Integer quantity;
	
	@JsonProperty
	@Getter
	@Setter
	@Column(name = "price")
	private Double price;
}
