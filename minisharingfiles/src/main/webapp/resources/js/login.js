$(document).ready(function() {
	$("#btn_update").click(function(event){
		$("#file_form").removeClass("hide_form_update");
	});
	
	/*
	$("#btn_delete").click(function(event){
		
		$.ajax({
			url:"/minisharingfiles/home/delete",
		    type:"GET",
		    data:{
		    	email:ten,
		    	matkhau:password
		    },
			success: function(value){
				if(value == "true"){
					duongDanHienTai = window.location.href;
					duongDan = duongDanHienTai.replace("dangnhap/","");
					window.location = duongDan;
					
				}else{
					$("#ketqua").text("dang nhap that bai !")
				}
				
			}
		})
		
	});
	*/
});