package com.lc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.accesser.Accesser;
import com.ds.accesser.CityDiscountAccesserImpl;
import com.ds.accesser.CityRIImpl;
import com.lc.cache.Cache;
import com.lc.util.CacheManager;

public class LoanCalServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		int principle = 0;
		int month = 0;
		String city = null;
		float ri = 0;
		double interest = 0;
		int discount = 0;
		Properties props = null;
		Properties prop = null;
		List<Accesser> accesser=null;
		CacheManager cm=null;
		Cache cache=null;

		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		principle = Integer.parseInt(req.getParameter("principle"));
		month = Integer.parseInt(req.getParameter("month"));
		city = req.getParameter("city");
		
		cache = Cache.getInstance();
		accesser=new ArrayList<Accesser>();
        accesser.add(new CityDiscountAccesserImpl());
        accesser.add(new CityRIImpl());
        cm=new CacheManager(cache, accesser);
        
		
		props = new Properties();
		props = (Properties) cache.get("cityRI");
		prop = new Properties();
		prop = (Properties) cache.get("cityDiscount");
		ri = Float.parseFloat(props.getProperty(city));
		discount = Integer.parseInt(prop.getProperty(city));

		interest = (principle * month * ri) / 100;
		pw.println("Priciple : " + principle + "<br>");
		pw.println("Rate : " + ri + "<br>");
		pw.println("Month : " + month + "<br>");
		pw.println("City : " + city + "<br>");
		pw.println("Ammount to pay : " + interest);
		pw.println("Discount : " + discount);

	}

}
