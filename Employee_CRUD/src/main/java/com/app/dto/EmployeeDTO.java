package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
public class EmployeeDTO {
	private Long id;
	@NotBlank(message="First must not be blank")
	private String firstName;
	@Size(min = 5,max = 10)
	@NotBlank(message = "must be filled")
	private String lastName;
	@Email
	private String email;
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message = "must provided")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@NotNull
	private double salary;
	@NotBlank
	private String department;
}
