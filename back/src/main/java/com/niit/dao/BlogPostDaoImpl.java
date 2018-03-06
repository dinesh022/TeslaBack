package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.BlogPost;
@Repository
@Transactional
public class BlogPostDaoImpl implements BlogPostDao {
@Autowired
private SessionFactory sessionFactory;
	@Override
	public void addBlogPost(BlogPost blogPost) {
		// TODO Auto-generated method stub
    Session session=sessionFactory.getCurrentSession();
    session.save(blogPost);
	}
	@Override
	public List<BlogPost> listOfBlogs(int approved) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from blogPost where approved="+approved);
		List<BlogPost> blogs=query.list();
		return blogs;
	}
	@Override
	public BlogPost getBlog(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		BlogPost blogPost=(BlogPost)session.get(BlogPost.class,id);
		return blogPost;
	}

}
