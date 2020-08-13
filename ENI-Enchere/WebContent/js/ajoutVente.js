//affichage de l'image upload
function readURL(input) {
	  if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    
	    reader.onload = function(e) {
	      $('#preview').attr('src', e.target.result);
	    }
	    
	    reader.readAsDataURL(input.files[0]); // convert to base64 string
	  }
	}
	
	$('input#photoAUploader').on('change', function() {
		readURL(this);
	});

	$( document ).ready(function() {
		//set la valeur et le min pour les input de date et début et fin
		var today = new Date().toISOString().split('T')[0];
		var temp = new Date();
		temp.setDate(temp.getDate() + 1);
		var tomorrow = temp.toISOString().split('T')[0];
		
		document.getElementsByName("date_deb")[0].setAttribute('min', today);
		document.getElementsByName("date_deb")[0].setAttribute('value', today);
		
		document.getElementsByName("date_fin")[0].setAttribute('min', tomorrow);
		document.getElementsByName("date_fin")[0].setAttribute('value', tomorrow);
	});