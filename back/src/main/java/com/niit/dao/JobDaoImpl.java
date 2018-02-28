package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Job;
@Repository
@Transactional
public class JobDaoImpl implements JobDao {
@Autowired
private SessionFactory sessionFactory;
	@Override
	public void addJob(Job job) {
		// TODO Auto-generated method stub
    Session session = sessionFactory.getCurrentSession();
    session.save(job);
	}
	@Override
	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
	Session session = sessionFactory.getCurrentSession();
	Query query=session.createQuery("from Job");
	return query.list();
	}
	@Override
	public Job getJob(int id) {
		// TODO Auto-generated method stub
	Session session = sessionFactory.getCurrentSession();
	Job job=(Job)session.get(Job.class,id);	
		return job;
	}

}
