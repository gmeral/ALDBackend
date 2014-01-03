package org.rest.service.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Embeddable
public class Dimensions {
	
	@Column
	private double x;
	@Column
	private double y;
	@Column
	private double z;
	
	public Dimensions() {
		x = 0;
		y = 0;
		z = 0;
	}
	
	public Dimensions(int xdim, int ydim, int zdim){
		x = xdim;
		y = ydim;
		z = zdim;
	}
	
	
	@XmlElement
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	@XmlElement
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	@XmlElement
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	
}
