var Brewer = Brewer || {};

Brewer.FastStyleRegister = (function() {

	function FastStyleRegister() {
		this.modal = $('#styleRegisterModal');
		this.saveButton = this.modal.find('.js-modal-register-style-save-btn');
		this.form = this.modal.find('form');
		this.url = this.form.attr('action');
		this.inputStyleName = $('#styleName');
		this.containerErrorMessage = $(".js-fast-register-style-message");
	}

	FastStyleRegister.prototype.begin = function() {
		this.form.on('submit', function(event) {event.preventDefault();});
		this.modal.on('shown.bs.modal', onModalShow.bind(this));
		this.modal.on('hide.bs.modal', onModalClose.bind(this));
		this.saveButton.on('click', onSaveButtonClick.bind(this));
	}

	function onModalShow() {
		this.inputStyleName.focus();
	}

	function onModalClose() {
		this.inputStyleName.val('');
		this.containerErrorMessage.addClass('hidden');
		this.form.find('.form-group').removeClass('has-error');
	}

	function onSaveButtonClick() {
		var styleName = this.inputStyleName.val().trim();

		$.ajax({
			url : this.url,
			method : 'POST',
			contentType : 'application/json',
			data : JSON.stringify({
				'name' : styleName
			}),
			error : onSavedStyleError.bind(this),
			success : onSavedStyle.bind(this)
		});
	}

	function onSavedStyleError(obj) {
		var errorMessage = obj.responseText;
		this.containerErrorMessage.removeClass('hidden');
		this.containerErrorMessage.html('<span>' + errorMessage + '</span>');
		this.form.find('.form-group').addClass('has-error');
	}

	function onSavedStyle(style) {
		var combo = $('#style');
		combo.append('<option value=' + style.id + '>' + style.name
				+ '</option>');
		combo.val(style.id);
		this.modal.modal('hide');
	}

	return FastStyleRegister;
}());

$(function() {
	var fastStyleRegister = new Brewer.FastStyleRegister();
	fastStyleRegister.begin();
});