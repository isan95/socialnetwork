var $ = jQuery.noConflict();
$('document').ready(function()
{    
   
   
   $("#change-pass").validate({
     
    rules:
    {
		old_pass: {
		 required: true,
		 minlength: 4,
		 maxlength: 15
		},
		
		new_pass: {
		 required: true,
		 minlength: 4,
		 maxlength: 15
		},
		
		cnew_pass: {
		 required: true,
		 equalTo: '#new_pass'
		},
     },
	messages:
    {
		old_pass:{
		 required: "Por ingresa la contraseña",
		 minlength: "La contraseña debe contener al menos 4 caracteres"
		 },
		
		new_pass:{
		 required: "Por ingresa la nueva contraseña",
		 minlength: "La contraseña debe contener al menos 4 caracteres"
		 },
		
		cnew_pass:{
		 required: "Por favor ingresa la confirmación de la contraseña",
		 equalTo: "Las contraseñas no coinciden"
		 }
	},
     errorPlacement : function(error, element) {
     $(element).closest('.form-group').find('.help-block').html(error.html());
     },
     highlight : function(element) {
     $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
     },
     unhighlight: function(element, errorClass, validClass) {
     $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
     $(element).closest('.form-group').find('.help-block').html('');
     },
     
     submitHandler: function(form) {
                    form.submit();
     alert('ok');
                }
     }); 
 })

