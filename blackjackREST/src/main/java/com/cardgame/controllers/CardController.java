package com.cardgame.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4200" })
public class CardController {

	@Autowired
	// private ElectricBillService ebSI;

	// DONE
	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	// @RequestMapping(path = "electricbills", method = RequestMethod.GET)

	// @RequestMapping(path = "electricbills/{id}", method = RequestMethod.GET)

	// @RequestMapping(path = "electricbills", method = RequestMethod.POST)

	// @RequestMapping(path = "electricbills/{id}", method = RequestMethod.PUT)

	// @RequestMapping(path = "electricbills/{id}", method = RequestMethod.PATCH)

	// @RequestMapping(path = "electricbills/{id}", method = RequestMethod.DELETE)

	// @RequestMapping(path = "electricbills/search/manager/{lastName}", method =
	// RequestMethod.GET)

	// @RequestMapping(path = "electricbills/search/price/{low}/{high}", method =
	// RequestMethod.GET)

	// @RequestMapping(path = "electricbills/search/wattage/{low}/{high}", method =
	// RequestMethod.GET)

	// @RequestMapping(path = "electricbills/search/year/{low}/{high}", method =
	// RequestMethod.GET)
}
