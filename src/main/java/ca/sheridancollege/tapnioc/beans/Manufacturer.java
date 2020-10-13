/*
 * Created by: Christian Tapnio
 * Date: 10-12-2020
 * Spring-Boot Application with SQL Database
 * */
package ca.sheridancollege.tapnioc.beans;

import java.io.Serializable;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manufacturer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3932313967928529007L;
	private int manufacturerID;
	private String manufacturer;

}
