package zdp.gale.test;

import zdp.gale.bean.DatabaseSource;
import zdp.gale.interfac.annotation.GetObject;
import zdp.gale.parse.ParseAnnotation;


public class TestMain {
	@GetObject(value = "databaseSource")
	DatabaseSource db ;

	public static void main(String[] args) {
		TestMain tm=new TestMain();
		ParseAnnotation<DatabaseSource> ps=((ParseAnnotation<DatabaseSource>)ParseAnnotation.getNewInstance());
		ps.init( tm.getClass().getName());
		try {
			ps.annotation(tm.db);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(tm.db.getPassword()+" : "+ tm.db.getUsername());
	}

}
