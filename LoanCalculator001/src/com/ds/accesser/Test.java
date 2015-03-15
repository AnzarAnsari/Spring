package com.ds.accesser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import com.lc.cache.Cache;
import com.lc.util.CacheManager;

public class Test {

	public static void main(String[] args) throws IOException {
		Properties props= new Properties();
		Cache cache = Cache.getInstance();
		ArrayList<Accesser> accesser = new ArrayList<Accesser>();
        accesser.add(new CityDiscountAccesserImpl());
        accesser.add(new CityRIImpl());
        CacheManager cm = new CacheManager(cache, accesser);
        props=(Properties) cache.get("cityRI");
        System.out.println(props.getProperty("Delhi"));
		

	}

}
