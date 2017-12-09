package org.com.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.client.model.geojson.Point;

@Document(collection = "shops")
public class Shop {
	@Id
	private ObjectId _id;
	private String picture;
	private String name;
	private String email;
	private Long timeDislike;
	private String city;
	private int liked=0;
	private org.com.models.Point location;
	public Shop() {
		
	}
	
	public Shop(ObjectId _id, String picture, String name, String email, String city, int liked, org.com.models.Point location) {
		super();
		this._id = _id;
		this.picture = picture;
		this.name = name;
		this.email = email;
		this.city = city;
		this.liked = liked;
		this.location = location;
		
	}

	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public org.com.models.Point getLocation() {
		return location;
	}

	public void setLocation(org.com.models.Point location) {
		this.location = location;
	}

	public int getLiked() {
		return liked;
	}
	public void setLiked(int liked) {
		this.liked = liked;
	}

	public Long getTimeDislike() {
		return timeDislike;
	}

	public void setTimeDislike(Long timeDislike) {
		this.timeDislike = timeDislike;
	}
	
	
}
