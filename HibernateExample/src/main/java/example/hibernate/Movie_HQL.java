package example.hibernate;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;
import org.hibernate.sql.ordering.antlr.Factory;

import example.hibernate.entity.Movie;
import example.hibernate.utilities.Main_Utilities;

public class Movie_HQL {
	
	private static void create(){
	      
	    Configuration conf =new Configuration();//Looks for hibernate properties
	    conf=conf.configure();//Looks for hibernate.cfg.xml
	    
	    //Building a SessionFactory
	    SessionFactory factory =Main_Utilities.buidSessionFactory();
	    
	    //Building a Session
	    Session session=factory.openSession();
	      Movie currentMovie=new Movie("M3","FastnFurious","Thriller",2016);   
	    Transaction tx =session.beginTransaction();
	      session.save(currentMovie);
	      tx.commit();//Committing the Transaction
	      session.close();
	      factory.close();
	      System.out.println("Its created Succefully");
	  }
	    
	
	private static void hqlSelectQuery(){
	      
	    Configuration conf =new Configuration();
	    conf=conf.configure();
	    SessionFactory factory =Main_Utilities.buidSessionFactory();
	    Session session=factory.openSession();
	    
	    
	    String hqlQuery="select m.title , m.year from Movie m";
	    
	    Query<Object[]> qrMovie=session.createQuery(hqlQuery);
	    List<Object[]> MovieList=qrMovie.list();
	    System.out.println("Print Tile And Year of that movie");
	    
	    for(Object[] Mdata:MovieList) {
	    	System.out.println("Tile:-"+Mdata[0]+", Year:-"+Mdata[1]);
	    	
	    	
	    }
	}
	  
	private static void hqlFormQuery() {
		 SessionFactory factory=Main_Utilities.buidSessionFactory();
		 Session session=factory.openSession();
		 String hqlQuery="From Movie m";
		 Query<Movie> qrMovie=session.createQuery(hqlQuery);
		   
		 List<Movie> allMovie=qrMovie.list();
		 System.out.println("The using FORM Query is exicuted");
		 
		 for(Movie Mlist:allMovie) {
			 System.out.println(Mlist);
		 }
		 
	}


	private static void hqlConstructorQuery() {
	SessionFactory factory=Main_Utilities.buidSessionFactory();
	Session session=factory.openSession();
	//select new example.hibernate.beans.MovieTitleAndYear(m.title,m.year) from Movie m";
	String hqlQuery="select new example.hibernate.beans.MovieTitleAndYear(m.title,m.year) from Movie m";
		
	}


	public static void main(String[] args) {
		//create();
		//hqlSelectQuery();
	hqlFormQuery();
	}

}
