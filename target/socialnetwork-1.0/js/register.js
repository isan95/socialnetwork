var $ = jQuery.noConflict();
$('document').ready(function()
{    
   
   
   $("#register-form").validate({
     
    rules:
    {
		ndoc: {
			required:true,
			minlength: 4,
			
		},
		
		name: {
		 required: true,
		 minlength: 3,
		},
		
		lname: {
			required: true,
			minlength: 3,
		},
		
		pass: {
		 required: true,
		 minlength: 4,
		 maxlength: 15
		},
		
		cpass: {
		 required: true,
		 equalTo: '#pass'
		},
     },
	messages:
    {
		ndoc: {
			required: "Por favor ingrese su número de documento",
			minlength: "Tu número de documento debe ser de minimo 4 caracteres"
		},
		
		name: {
		 required: "Por favor ingrese su nombre",
		 minlength: "Tu nombre debe ser de minimo 3 caracteres"
		   },
		
		lname: {
		 required: "Por favor ingrese su apellido",
		 minlength: "Tu apellido debe ser de minimo 3 caracteres"
		   },
		
		pass:{
		 required: "Por ingresa la contraseña",
		 minlength: "La contraseña debe contener al menos 4 caracteres"
		 },
		
		cpass:{
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
