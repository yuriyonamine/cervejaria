package br.com.yuri.cerveja.thymeleaf.dialect;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import br.com.yuri.cerveja.thymeleaf.processors.ClassForErrorAttributeTagProcessor;

public class BrewerDialect extends AbstractProcessorDialect{

	public BrewerDialect() {
		super("Brewer custom", "brewer", StandardDialect.PROCESSOR_PRECEDENCE);
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor>processors = new HashSet<>();
		processors.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
		return processors;
	}

}
