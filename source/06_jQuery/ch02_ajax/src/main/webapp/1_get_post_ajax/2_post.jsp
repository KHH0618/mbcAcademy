<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script>
		$(document).ready(function(){
			/* $.post(요청경로, 요청파라미터 값을 객체, callback){
				data : 요청경로로 수행한 결과(중복된 id입니다/ 사용 가능한 id입니다)
				status : success/fail
			})*/
			$('button').click(function() {
				var id = $('input[name="id"]').val();
				$.post('midConfirm.jsp', {id : id}, function(data, status) {
					$('span#idConfirm').html(data);
				});
			});
			$('input[name="id"]').keyup(function() {
				var id = $(this).val();
				if(id.length < 3){
					$('span#idConfirm').text("id는 3글자 이상");
				}else{
					$.post('midConfirm.jsp', {id : id}, function(data, status) {
						$('span#idConfirm').html(data);
					});					
				}
			});
			
		});
		
	</script>
</head>
<body>
	아이디 <input type="text" name="id"> <button>중복체크</button><br>
	<span id="idConfirm"></span>
</body>
</html>