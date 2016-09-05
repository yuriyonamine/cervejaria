$(function(){
	var modal = $('#styleRegisterModal');
	var saveButton = modal.find('.js-modal-register-style-save-btn');	
	var form = modal.find('form');
	var url = form.attr('action');
	var inputStyleName = $('#styleName');
	var containerErrorMessage = $(".js-fast-register-style-message");
	
	form.on('submit', function(event){
		event.preventDefault();
	});
	
	modal.on('shown.bs.modal', onModalShow);
	modal.on('hide.bs.modal', onModalClose);
	saveButton.on('click', onSaveButtonClick);
	
	function onModalShow(){
		inputStyleName.focus();
	}
	
	function onModalClose(){
		inputStyleName.val('');
		containerErrorMessage.addClass('hidden');
		form.find('.form-group').removeClass('has-error');
	}
	
	function onSaveButtonClick(){
		var styleName = inputStyleName.val().trim();
		
		$.ajax({
			url:url,
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify({'name': styleName}),
			error: onSaveStyleError,
			success: onSaveStyle
		});
	}
	
	function onSaveStyleError(obj){
		var errorMessage = obj.responseText;
		containerErrorMessage.removeClass('hidden');
		containerErrorMessage.html('<span>'+errorMessage + '</span>');
		form.find('.form-group').addClass('has-error');
	}
	
	function onSaveStyle(style){
		var combo = $('#style');
		combo.append('<option value='+style.id+'>'+style.name+'</option>');
		combo.val(style.id);		
		modal.modal('hide');		
	}
});