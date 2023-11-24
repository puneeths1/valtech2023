package com.valtech.training.invoice.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.valtech.training.invoice.Company;
import com.valtech.training.invoice.Customer;
import com.valtech.training.invoice.Order;
import com.valtech.training.invoice.OrderItems;
import com.valtech.training.invoice.OrderItemId;
import com.valtech.training.invoice.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class InvoiceClient {

 public static void main(String[] args) {
     AnnotationConfiguration cfg = new AnnotationConfiguration();
     cfg.addAnnotatedClass(Customer.class);
     cfg.addAnnotatedClass(Company.class);
     cfg.addAnnotatedClass(Order.class);
     cfg.addAnnotatedClass(Product.class);
     cfg.addAnnotatedClass(OrderItems.class);

     SessionFactory sesFac = cfg.buildSessionFactory();
     Session ses = sesFac.openSession();
     Transaction tx = ses.beginTransaction();

     try {
         // Generate a random date for the order
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         String randomDate = "2023-10-15"; // Replace this with a dynamic date generation logic

         // Create entities
         Customer cus1 = new Customer(101, "ABC", "9090909009", "Bangalore");
         Company com1 = new Company("Fashion", "DELHI");
         Order o1 = new Order(randomDate);
         Product p1 = new Product("Dress", 350, 4500);

         // Persist entities in the correct order
         ses.persist(cus1);
         ses.persist(com1);
         ses.persist(o1);
         ses.persist(p1);

         // Commit the changes so that IDs are generated
         tx.commit();

         // Now, create and persist OrderItems
         ses.beginTransaction(); // Begin a new transaction
         OrderItems oi1 = new OrderItems(o1, p1);
         ses.persist(oi1);

         System.out.println("Loading...");
         ses.getTransaction().commit(); // Commit the second transaction
     } catch (Exception e) {
         if (tx != null) {
             tx.rollback();
         }
         e.printStackTrace();
         System.err.println("Error: " + e.getMessage());
     } finally {
         ses.close();
         sesFac.close();
     }
 }
}

