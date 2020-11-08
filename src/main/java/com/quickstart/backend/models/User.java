package com.quickstart.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;

@Table(name="USER")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	
	@Column(name="USERNAME")
	@NotBlank(message="The username is required")
	@Getter @Setter private String username;
	
	@Column(name="PASSWORD")
	@NotBlank(message="The password is required")
	@Getter @Setter private String password;
	
	@Transient
	@Getter @Setter private String token;
}
