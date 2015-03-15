package com.ds.accesser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.lc.cache.Cache;

public class CityDiscountAccesserImpl implements Accesser {

	Properties props = null;
	FileInputStream fis = null;

	public Object getData() throws IOException {
		props = new Properties();
		fis = new FileInputStream(
				"G:\\SrimanSir\\Spring\\CoreAdvance\\LoanCalculator001\\WebContent\\WEB-INF\\cityDiscount.properties");
		props.load(fis);

		return props;
	}

	@Override
	public String getKey() {
		return "cityDiscount";
	}

}
