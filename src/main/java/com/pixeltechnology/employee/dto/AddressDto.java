package com.pixeltechnology.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    public AddressDto() {
		super();
	}
	private Long id;
    private String street;
    @Override
	public String toString() {
		return "AddressDto [id=" + id + ", street=" + street + ", city=" + city + ", zipcode=" + zipcode + ", state="
				+ state + "]";
	}
	public AddressDto(Long id, String street, String city, String zipcode, String state) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	private String city;
    private String zipcode;
    private String state;

}