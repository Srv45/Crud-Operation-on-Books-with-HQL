package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.entity.Books;

public class InsertData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Books.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "insert into Books(title,author,genre,price)values(:title,:author,:genre,:price)";
		MutationQuery mtquery = ss.createMutationQuery(hqlQuery);
		mtquery.setParameter("title", "The Hidden Hindu");
		mtquery.setParameter("author", "Akshat Gupta");
		mtquery.setParameter("genre", "Hindu Mythology, Sci-fi");
		mtquery.setParameter("price", 468);
		mtquery.executeUpdate();
		tr.commit();

		System.out.println("Data inserted successufully...");
		ss.close();

	}

}
