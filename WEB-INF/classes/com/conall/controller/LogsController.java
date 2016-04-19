package com.conall.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.conall.dao.Log;
import com.conall.service.LogsService;

@Controller
public class LogsController {

	private LogsService logsService;

	@Autowired
	public void setLogsService(LogsService logsService) {
		this.logsService = logsService;
	}

	@RequestMapping(value = { "/", "/logs", "/home", "/conallsite" })
	public String showLogs(Model model) {

		List<Log> logs = logsService.getCurrent();

		model.addAttribute("logs", logs);

		Collections.reverse(logs);

		return "home";
	}

	@RequestMapping("/createlog")
	public String createLog(Model model) {
		model.addAttribute("log", new Log());
		return "createlog";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam("id") int id) {

		Log currentLog = logsService.getLogEdit(id);
		model.addAttribute("log", currentLog);
		return "edit";
	}

	@RequestMapping(value = "/editlogsubmit", method = RequestMethod.POST)
	public String editLog(Model model, Log log, @RequestParam(value = "delete", required = false) String delete) {

		if (delete == null) {
			logsService.saveOrUpdate(log);
		} else {
			logsService.delete(log.getId());
		}

		return "redirect:home";
	}

	@RequestMapping(value = "/createlogsubmit", method = RequestMethod.POST)
	public String doCreate(Model model, Log log) {

		logsService.create(log);

		List<Log> logs = logsService.getCurrent();

		model.addAttribute("logs", logs);

		Collections.reverse(logs);

		return "redirect:home";
	}

}