var Brewer = Brewer || {};

Brewer.UploadPhoto = (function() {

	function UploadPhoto() {
		this.inputPhotoName = $('#photoName');
		this.inputContentType = $('#contentType');
		this.uploadDrop = $('#upload-drop');

		this.htmlTemplate = $('#beerPhotoScript').html();
		this.template = Handlebars.compile(this.htmlTemplate);
		this.containerBeerPhoto = $('#photoBeerContainer');
	}

	UploadPhoto.prototype.initialize = function() {
		var settings = {
			type : 'json',
			filelimit : 1,
			allow : '*.(jpg|jpeg|png)',
			action : this.containerBeerPhoto.data('url-photos'),
			complete : onUploadCompleted.bind(this)
		};

		UIkit.uploadSelect($('#upload-select'), settings);
		UIkit.uploadDrop(this.uploadDrop, settings);
	}

	function onUploadCompleted(response) {
		this.inputPhotoName.val(response.name);
		this.inputContentType.val(response.contentType);

		this.uploadDrop.addClass('hidden');
		var htmlBeerPhoto = this.template({
			photoName : response.photoName
		});
		this.containerBeerPhoto.append(htmlBeerPhoto);

		$('#removePhotoButton').on('click', onRemovePhoto.bind(this));
	}

	function onRemovePhoto() {
		this.uploadDrop.removeClass('hidden');
		this.inputPhotoName.val('');
		this.inputContentType.val('');
		$('#beerPhoto').remove();
	}

	return UploadPhoto;
})();

$(function() {
	var uploadPhoto = new Brewer.UploadPhoto();
	uploadPhoto.initialize();
});