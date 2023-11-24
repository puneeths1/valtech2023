package com.valtech.training.invoice;

import javax.persistence.*;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @Column(name = "company_name")
    private String companyName;

    private String location;

    // Add any other necessary fields and methods

    public Company() {
        // Default constructor required by Hibernate
    }

    public Company(String companyName, String location) {
        this.companyName = companyName;
        this.location = location;
    }

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
    
}