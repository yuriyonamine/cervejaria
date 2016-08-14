package br.com.yuri.cerveja.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import br.com.yuri.cerveja.model.Style;

public class StyleConverter implements Converter<String, Style>{
	@Override
	public Style convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			Style style = new Style();
			style.setId(Long.valueOf(codigo));
			return style;
		}
		
		return null;
	}

}
