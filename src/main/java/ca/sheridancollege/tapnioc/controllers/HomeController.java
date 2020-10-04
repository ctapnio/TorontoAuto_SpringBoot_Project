/*
 * Christian Tapnio
 * 991359879
 * Assignment 3
 * */
package ca.sheridancollege.tapnioc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.tapnioc.beans.Car;
import ca.sheridancollege.tapnioc.beans.Manufacturer;
import ca.sheridancollege.tapnioc.database.DatabaseAccess;

@Controller
public class HomeController {

	@Autowired
	private DatabaseAccess da;

	@GetMapping("/")
	public String goHome(Model m) {
		m.addAttribute("car", new Car());
		m.addAttribute("carList", da.getCars());
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/user/insert")
	public String secureIsert(Model m) {
		m.addAttribute("car", new Car());
		m.addAttribute("carList", da.getCars());
		m.addAttribute("manufacturer", new Manufacturer());
		m.addAttribute("manufacturerList", da.getManufacturers());
		return "/user/insert";
	}
	
	@GetMapping("/user/update")
	public String secureUpdate(Model m) {
		m.addAttribute("car", new Car());
		m.addAttribute("carList", da.getCars());
		m.addAttribute("manufacturer", new Manufacturer());
		m.addAttribute("manufacturerList", da.getManufacturers());
		return "/user/update";
	}
	
	@GetMapping("/admin/delete")
	public String secureDelete(Model m) {
		m.addAttribute("car", new Car());
		m.addAttribute("carList", da.getCars());
		m.addAttribute("manufacturer", new Manufacturer());
		m.addAttribute("manufacturerList", da.getManufacturers());
		return "/admin/delete";
	}
	
	@GetMapping("/insert")
	public String insert(Model m) {
		m.addAttribute("car", new Car());
		m.addAttribute("manufacturer", new Manufacturer());
		m.addAttribute("manufacturerList", da.getManufacturers());
		// m.addAttribute("carList", da.getCars());
		return "/user/insert";
	}

	@PostMapping("/insertCar")
	public String insertCar(Model m, @RequestParam int manufacturerID, @RequestParam String model,
			@RequestParam Long year, @RequestParam String color, @RequestParam Double price) {
		da.insertCar(manufacturerID, model, year, color, price);
		m.addAttribute("car", new Car());
		m.addAttribute("carList", da.getCars());
		return "/user/insert";
	}

	@GetMapping("/update")
	public String update(Model m) {
		m.addAttribute("car", new Car());
		m.addAttribute("carList", da.getCars());
		return "/user/update";
	}

	@GetMapping("/editCar/{carID}")
	public String editCar(Model m, @PathVariable int carID) {
		Car car = da.getCarByCarID(carID).get(0);
		m.addAttribute("car", car);
		m.addAttribute("carList", da.getCars());
		return "/user/update";
	}

	@PostMapping("/updateCar")
	public String updateCar(Model m, @ModelAttribute Car car) {
		da.updateCar(car.getCarID(), car.getModel(), car.getPrice());
		m.addAttribute("Car", new Car());
		m.addAttribute("carList", da.getCars());
		return "/user/update";
	}

	@GetMapping("/delete")
	public String delete(Model m) {
		m.addAttribute("car", new Car());
		m.addAttribute("carList", da.getCars());
		return "/admin/delete";
	}

	@PostMapping("/deleteCar")
	public String deleteCar(Model m, @RequestParam int carID) {
		da.deleteCar(carID);
		m.addAttribute("car", new Car());
		m.addAttribute("carList", da.getCars());
		return "/admin/delete";
	}
	
	@GetMapping("/permission-denied")
	public String permissionDenied() {
		return "/error/permission-denied";
	}

}



