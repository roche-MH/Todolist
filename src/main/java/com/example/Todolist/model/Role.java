"ackage com.example.Todolist.model;



import java.util.Date;



import javax.persistence.Entity;

import javax.persistence.GenerationType;

import javax.persistence.Table;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.Column;



@Entity

@Table(name="dolist")



public class Dolist implements Serializable{



	@Id

	@GeneratedValue(strategy=GenerationType.AUTO)

	@Column(name="id")

	private Long id;

	@Column(name="title")

	private String title;

	@Column(name="Describe")

	private String Describe;

	@Column(name="created_Date")

	private Date createdDate;

	@Column(name="updated_Date")

	private Date updatedDate;

	

	public Long getId() {

		return id;

	}

	public void setId(Long id) {

		this.id = id;

	}

	

	public String getTitle() {

		return title;

	}

	public void setTitle(String title) {

		this.title = title;

	}

	public String getDescribe() {

		return Describe;

	}

	public void setDescribe(String describe) {

		Describe = describe;

	}

	public Date getCreatedDate() {

		return createdDate;

	}

	public void setCreatedDate(Date createdDate) {

		this.createdDate = createdDate;

	}

	public Date getUpdatedDate() {

		return updatedDate;

	}

	public void setUpdatedDate(Date updatedDate) {

		this.updatedDate = updatedDate;

	}

	

	

}


