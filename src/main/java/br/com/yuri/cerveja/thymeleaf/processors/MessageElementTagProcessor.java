package br.com.yuri.cerveja.thymeleaf.processors;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class MessageElementTagProcessor extends AbstractElementTagProcessor {
	private static final String TAG_NAME = "message";
	private static final int PRECEDENCE = 1000;

	public MessageElementTagProcessor(String dialectPrefix) {
		super(TemplateMode.HTML, dialectPrefix, TAG_NAME, true, null, false, PRECEDENCE);
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
			IElementTagStructureHandler structureHandler) {
		IModelFactory modelFactory = context.getModelFactory();
		IModel model = modelFactory.createModel();

		model.add(modelFactory.createStandaloneElementTag("th:block", "th:replace", "fragments/SuccessMessage :: success"));
		model.add(modelFactory.createStandaloneElementTag("th:block", "th:replace", "fragments/ValidationErrorMessage :: validationError"));

		structureHandler.replaceWith(model, true);
	}

}
