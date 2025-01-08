package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.entity.Books;

public class UpdateData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Books.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "update Books set price =:newprice where book_id =:id";
		MutationQuery mtquery = ss.createMutationQuery(hqlQuery);
		mtquery.setParameter("newprice", 2500);
		mtquery.setParameter("id", 1);
		mtquery.executeUpdate();
		tr.commit();

		System.out.println("Data updated successufully...");
		ss.clear();

	}

}
