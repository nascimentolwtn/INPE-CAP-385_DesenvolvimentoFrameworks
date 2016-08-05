package org.cbsoft.framework.formatter;

import java.util.Map;

public interface DataFormatter {

	byte[] formatData(Map<String, Object> props);
	
}
