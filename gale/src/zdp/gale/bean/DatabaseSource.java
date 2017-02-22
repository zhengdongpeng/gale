package zdp.gale.bean;

import zdp.gale.interfac.annotation.ReaderDBSource;

public class DatabaseSource {
	private String  password;
	private String username;
	
	@ReaderDBSource("db.pwd")
	public String getPassword(){
		return password;
	}
	
	@ReaderDBSource("db.user")
	public String getUsername(){
		return username;
	}

}
