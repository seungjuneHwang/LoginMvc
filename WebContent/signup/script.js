
$('.form-action').click(function(){
 
    var form_id = $('.grop-from').attr('id');
      $('.icon-action').addClass('back');
  
    if($('#control-' + form_id).val() != ''){
    	console.log(form_id);
      switch (form_id) {
          case 'name':
              form_id = "phone";
              break;
          case "phone":
        	    var phone_chk = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
        	    var phone = $('#control-' + form_id).val();
        	    console.log(phone);
        	    if (!phone_chk.test(phone)) {
        	    	alert("전화번호를 확인 하세요.");
//        	    	 $('#err-text').html('전화번호 확인');
//        	    	 $('#control-' + form_id).val('번호 확인');
        	    	form_id = "phone";
        	    } else {
        	    	form_id = "email";
        	    }
              break;
          case "email":
              form_id = "password";
              break;
          case "password":
              form_id = "password-repeat";
              break;
          case "password-repeat":
              form_id = "success";
              break;   
        case "success":
              form_id = "signup";
              break; 
      }
       $('.icon-action').addClass('back');
      
  }
  
  else{
    
     switch (form_id) {
     	
          case 'name':
        	  console.log("name 빈값?");
        	  form_id = "signup";
              $('.icon-action').removeClass('back');
              
              break;
          case "phone":
              form_id = "name";
              break;
          case "email":
              form_id = "phone";
              break;
          case "password":
              form_id = "email";
              break;
          case "password-repeat":
              form_id = "password";
              break; 
         case "success":
              form_id = "signup";
              break; 
      }
     $('.icon-action').removeClass('back');
  }
 
  $('.grop-from').attr('id' , form_id);
  
});

$('input').keyup(function() {
	$('.grop-from').removeClass('error');
	$('.error-text').fadeOut();

	if ($(this).val() != '') {
		console.log("입력" + $(this).val());
		$('.icon-action').removeClass('back');
	} else {
		console.log("no 입력");
		$('.icon-action').addClass('back');
	}

})