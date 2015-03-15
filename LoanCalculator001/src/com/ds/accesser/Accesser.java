package com.ds.accesser;

import java.io.IOException;

public interface Accesser {
	String getKey();
	Object getData() throws IOException;

}
