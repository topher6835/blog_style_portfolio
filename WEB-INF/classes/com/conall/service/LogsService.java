package com.conall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conall.dao.Log;
import com.conall.dao.LogsDao;

@Service("logsService")
public class LogsService {

	private LogsDao logsDao;
	
	@Autowired
	public void setLogsDao(LogsDao logsDao) {
		this.logsDao = logsDao;
	}
	
	public List<Log> getCurrent() {
		return logsDao.getLogs();
	}

	public void create(Log log) {
		logsDao.create(log);
	}
	
	public Log getLogEdit(int id) {
		Log logs = logsDao.getLogEdit(id);
		return logs;
	}
	
	public void saveOrUpdate(Log log) {
		if(log.getId() != 0) {
			logsDao.update(log);
		}
	}

	public void delete(int id) {
		logsDao.delete(id);
	}
}