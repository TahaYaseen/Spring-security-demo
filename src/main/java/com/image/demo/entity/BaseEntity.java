package com.image.demo.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.image.demo.util.AppUtils;

@MappedSuperclass
public class BaseEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column(name = "created_by")
	protected Long createdBy;

	@Column(name = "created_on")
	protected Long createdOn;

	@Column(name = "updated_by")
	protected Long updatedBy;

	@Column(name = "updated_on")
	protected Long updatedOn;

//  public BaseEntity() {
//  super();
//  if(id == null) {
//      this.createdOn = AppUtils.currentMillis();
//      this.createdBy = AppUtils.currentUser();
//      
//  }
//  this.updatedOn = AppUtils.currentMillis();
//  this.updatedBy = AppUtils.currentUser();
//  
//  
//  
//}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Long createdOn) {
		this.createdOn = createdOn;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Long getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Long updatedOn) {
		this.updatedOn = updatedOn;
	}

}
