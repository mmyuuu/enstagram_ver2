package com.enstagram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.enstagram.model.EnstaAccount;
import com.enstagram.service.EnstaService;

@RestController
public class EnstaController {
	/*
	 * Get board_account Table DB
	 */
	@Autowired EnstaService enstaService;

	@RequestMapping("/list")
    public List<EnstaAccount> list() throws Exception{
        return enstaService.list();
    }

	/*
	 * Create Account
	 */
	@RequestMapping(value="/account", method=RequestMethod.POST)
	public String create(EnstaAccount enstaAccount) {
		return enstaService.create(enstaAccount);
	}
}