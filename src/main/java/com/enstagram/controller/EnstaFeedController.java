package com.enstagram.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.enstagram.model.EnstaAccount;
import com.enstagram.model.EnstaFeed;
import com.enstagram.service.EnstaService;

@RestController
public class EnstaFeedController {

	@Autowired
	EnstaService enstaService;

	/*
	 * Get Feed List
	 */

	@RequestMapping("/api/feedList")
	public List<EnstaFeed> feedList() {
		return enstaService.feedList();
	}

	/*
	 * Create Feed
	 */

	@RequestMapping(value = "/api/feedUpload", method = { RequestMethod.POST, RequestMethod.GET })
	public void createFeed(@ModelAttribute EnstaFeed enstaFeed, @RequestParam MultipartFile file) {
		enstaFeed.setFile_name("/upload/" + file.getOriginalFilename());
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(new File("./src/main/resources/static/upload/" + file.getOriginalFilename()));
			IOUtils.copy(file.getInputStream(), fos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		enstaService.createFeed(enstaFeed);
	}
	

	/*
	 * Get Feed
	 */

	@RequestMapping(value = "/api/feed/{feed_num}", method = { RequestMethod.POST, RequestMethod.GET })
	public List<EnstaFeed> getFeed(@PathVariable String feed_num) {
        return enstaService.getFeed(feed_num);
	}
	
	/*
	 * Remove Feed
	 */

	@RequestMapping(value = "/api/feed/remove", method = { RequestMethod.POST, RequestMethod.GET })
	public void removeFeed(@RequestParam Integer feed_num) {
		enstaService.removeFeed(feed_num);
	}
}
