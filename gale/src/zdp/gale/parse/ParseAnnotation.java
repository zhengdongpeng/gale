package zdp.gale.parse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import zdp.gale.interfac.annotation.GetObject;
import zdp.gale.interfac.annotation.ReaderDBSource;

public class ParseAnnotation<T> {
	
	Map<String,String> url;
	
	private  ParseAnnotation(){
		url =new HashMap<String,String>();
	}
	
	@SuppressWarnings("unused")
	public static ParseAnnotation<?> getNewInstance(){
		ParseAnnotation obj=newParseAnnotation.parse_;
		obj.init();
		return obj;
	}
	
	private void init() {
		FileInputStream fis;
		Properties pps = new Properties();
		try {
			fis = new FileInputStream("src/zdp.cfg.properties");
			pps.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		Enumeration enu=pps.propertyNames();
		while(enu.hasMoreElements())
		{
			String key=(String) enu.nextElement();
			url.put(key, (String) pps.get(key));
		}
	}

	private static class newParseAnnotation{
		private static final ParseAnnotation<?> parse_=new ParseAnnotation();
	}
	
	public void annotation(T t) throws Exception{
		
		this.parse(t);
		}
		
	
	
	public void parse(T t) throws Exception{
		
		Class clazz=t.getClass();
		//boolean isExist= clazz.isAnnotationPresent(ReaderDBSource.class);
		Method [] ms=clazz.getMethods();
		Object obj=t;
		for(Method m : ms){
			boolean isExist= m.isAnnotationPresent(ReaderDBSource.class);
			if(isExist){
				ReaderDBSource rs=m.getAnnotation(ReaderDBSource.class);
				if(url.containsKey(rs.value())){
					Field key=clazz.getDeclaredField(getFileName(m.getName()));
					key.setAccessible(true);
					key.set(obj, url.get(rs.value()));
				}
				
			}
		}
	}

	private String getFileName(String name) {
		String key=name;
		if(name.length()>3){
			key= name.substring(3,name.length());
			key=getCapitalName(key);
		}
		return key;
	}
	/**
	 * 
	 * @param name
	 * @return
	 */
	private String getCapitalName(String name) {
		char[] cs = name.toCharArray();
		if (cs[0] >= 'A' && cs[0] <= 'Z') {
			cs[0] = (char) (cs[0] + 32);
		}
		return String.valueOf(cs);
	}

	public void init(Object c) {
		Class clz;
		try {
			clz= c.getClass();
			Field [] field=clz.getDeclaredFields();
				for(Field f : field){
					boolean isExist= f.isAnnotationPresent(GetObject.class);
					if(isExist){
						GetObject gb=(GetObject) f.getAnnotation(GetObject.class)	;
					
					f.setAccessible(true);
					String str=url.get(gb.value());
					if(str!=null || !"".equals(str)){
						Class clz2=Class.forName(str);
						f.set(c, clz2.newInstance());
					}
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
