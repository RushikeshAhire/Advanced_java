package example.hibernate.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import example.hibernate.entity.Movie;

public class Main_Utilities {
	
public static SessionFactory buidSessionFactory() {
	
	Configuration cnf=new Configuration().configure();
	Class<Movie> movieType=Movie.class;
	cnf.addAnnotatedClass(movieType);
	SessionFactory sf=cnf.buildSessionFactory();
	
	
	
	return sf;
	
}
}
