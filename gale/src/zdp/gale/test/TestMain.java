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
		ps.init(tm);
		try {
			ps.annotation(tm.db);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println(tm.db.getPassword()+" : "+ tm.db.getUsername());
	}

}
