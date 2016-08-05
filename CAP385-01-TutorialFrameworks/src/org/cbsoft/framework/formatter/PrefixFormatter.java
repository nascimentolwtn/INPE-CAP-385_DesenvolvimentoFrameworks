package org.cbsoft.framework.formatter;

import java.lang.annotation.Annotation;

import org.cbsoft.framework.annotation.Prefix;

public class PrefixFormatter implements ValueFormatter {

	private String prefix;
	
	@Override
	public Object formatValue(Object value) {
		return prefix + value.toString();
	}
	
	@Override
	public void readAnnotation(Annotation an) {
		Prefix p = (Prefix) an;
		this.prefix = p.value();
	}

}
