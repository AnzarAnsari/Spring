package com.lc.cache;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.ds.accesser.Accesser;
import com.ds.accesser.CityDiscountAccesserImpl;
import com.ds.accesser.CityRIImpl;

public class Cache {
	private static Cache cache = null;
	public Map<String, Object> mapData = null;

	private Cache() throws IOException {
		mapData = new ConcurrentHashMap<String, Object>();		
	}
	

	public static synchronized Cache getInstance() throws IOException {
		if (cache == null) {
			cache = new Cache();
		}
		return cache;
	}
	
	public void init(Map<String,Object> map){
		mapData.clear();
		mapData.putAll(map);
	}

	public synchronized void put(String key, Object object) {
		mapData.put(key, object);
	}

	public synchronized Object get(String key) {
		return mapData.get(key);
	}

	public synchronized Boolean isContainsKey(String key) {
		return mapData.containsKey(key);
	}

}
