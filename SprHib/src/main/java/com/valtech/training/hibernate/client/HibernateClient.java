package com.valtech.training.hibernate.client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.valtech.training.hibernate.Account;
import com.valtech.training.hibernate.Address;
import com.valtech.training.hibernate.AtmTx;
import com.valtech.training.hibernate.BankAccount;
import com.valtech.training.hibernate.BankAccountID;
import com.valtech.training.hibernate.ChequeTx;
import com.valtech.training.hibernate.Customer;
import com.valtech.training.hibernate.Employee;
import com.valtech.training.hibernate.Registration;
import com.valtech.training.hibernate.TellerTx;
import com.valtech.training.hibernate.Tx;

import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
//		cfg.addAnnotatedClass(Employee.class);
//		
//		cfg.addAnnotatedClass(Tx.class).addAnnotatedClass(ChequeTx.class)
//			.addAnnotatedClass(TellerTx.class).addAnnotatedClass(AtmTx.class);
////		
//		cfg.addAnnotatedClass(Account.class);
//		cfg.addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class);
		
		cfg.addAnnotatedClass(Registration.class);
		cfg.addAnnotatedClass(BankAccount.class);
		
		SessionFactory sesFac = cfg.buildSessionFactory();
		Session ses = sesFac.openSession();
//		org.hibernate.Transaction tx =ses.beginTransaction();
		
		ses.persist(new BankAccount(new BankAccountID("SB",1),3000));
		
		BankAccountID id = new BankAccountID("SB",1);
		BankAccount ba = (BankAccount) ses.load(BankAccount.class, id);
		
//		Customer cus = new Customer("ABC",23);
//		ses.save(cus);
//		Address add = new Address("JayaNagar","BLR",560070);
//		add.setCustomer(cus);
//		ses.save(add);
//		
//		
//		Account acc= new Account(10000,"SB");
//		
//		Account acc1 = new Account(20000,"CA");
//		Tx tx5 = new ChequeTx(20000,456378,345123);
//		
//		Customer cus1 = new Customer("DEF",25);
//		Address add1  = new Address("JP Nagar","BLR",560080);
//		Customer cus2 = new Customer("PQR",27);
//		Address add2 = new Address("MG Road","Chennai",670056);
//		
//		Tx tx1 = new Tx(1000);
//		Tx tx2  =new ChequeTx(2000,123123,543215);
//		Tx tx3 = new TellerTx(3000,123,453);
//		Tx tx4 = new AtmTx(50000,780);
//		
//		ses.persist(acc);
//		ses.persist(tx1);
//		ses.persist(tx2);
//		ses.persist(tx3);
//		ses.persist(tx4);
//		
//		cus1.setAddress(add1);
//		add1.setCustomer(cus1);
//		cus2.setAddress(add2);
//		add2.setCustomer(cus2);
//		
//		ses.persist(acc1);
//		ses.persist(tx5);
//		ses.persist(cus1);
//		ses.persist(cus2);
//		
//		acc.addTx(tx1);acc.addTx(tx2);acc.addTx(tx3);acc.addTx(tx4);
//		
//		acc1.addTx(tx5);
//		acc1.addCustomer(cus1);acc1.addCustomer(cus2);
//		
//		ses.save(add1);
//		ses.save(add2);
		
//		ses.save(new Tx(100));
//		ses.save(new ChequeTx(2000,123123,543215));
//		ses.save(new TellerTx(3000,123,543));
//		ses.save(new AtmTx(5000,789));
//		
//		ses.createQuery("select distinct tx.account from Tx tx").list().forEach(t->System.out.println(t));
		
//		Query query = ses.createQuery("SELECT DISTINCT c FROM Customer c join c.accounts a join a.txs t where t.amount>?");
//		query.setFloat(0, 3000);
//		query.list().forEach(t->System.out.println(t));	
//		
//		Query query = ses.createQuery("SELECT t FROM Tx t JOIN t.account.customers c WHERE c.address.city=? AND t.amount>?");
//		query.setString(0, "BLR");
//		query.setFloat(1, 3000);
//		query.list().forEach(t->System.out.println(t));
//		
		
		
//		ses.persist(new Employee("ABC",LocalDate.of(1999, 9, 23),200000,'M',false));
//		ses.persist(new Employee("PQR",LocalDate.of(2010, 12, 3),40000,'F',false));
//		ses.persist(new Employee("XYZ",Date(2015, 3, 30),70000,'M',false));
		
//		int id = (Integer)ses.save(new Employee("XYZ",df.parse("30-04-2016"),70000,'M',false));
//		System.out.println(id);
//		Employee e = (Employee)ses.get(Employee.class, 1);
//		System.out.println(e.getClass().getName());
//		e.setName("ZYX");
		System.out.println("Loaded,open mysql commandline");
//		tx.commit();
		ses.close();
		sesFac.close();
	}

}
