package com.lc.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.ds.accesser.Accesser;
import com.lc.cache.Cache;

public class CacheManager {
	Accesser iaccesser=null;
	Cache cache=null;
	Map<String,Object> map=null;	
	List<Accesser> accesser=null;
	Properties props=null;
	
	public CacheManager(Cache cache,List<Accesser> accesser) throws IOException{
		this.accesser=accesser;
		this.cache=cache;
		load();
	}
	
	public void load() throws IOException{
		map=new HashMap<String, Object>();
		
		for(Accesser iaccesser:accesser){
			String key=iaccesser.getKey();
			//System.out.println(key);
			props=(Properties)iaccesser.getData();
			//System.out.println(props.getProperty("Delhi"));
			map.put(key, props);
		}
		
		cache.init(map);
	}

}
