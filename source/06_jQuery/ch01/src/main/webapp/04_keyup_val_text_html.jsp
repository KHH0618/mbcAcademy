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
			//jQuery 문법 : $('선택자').함수();
			$('input[name="pw"], input[name="pwChk"]').keyup(function() {
				var pw = $('input[name="pw"]').val().trim();
				var pwchk = $('input[name="pwChk"]').val().trim();
				if(pw && pw == pwchk){
					$('p.pwConfirm').text('두 비밀번호가 일치합니다');
				}else if(pw && pw != pwchk){
					$('p.pwConfirm').html('<b>두 비밀번호가 일치하지 않습니다</b>');
				} 
			});
		});
		
	</script>
</head>
<body>
	<p>PW <input type="password" name="pw"></p>
	<p>PW <input type="password" name="pwChk"></p>
	<p class="pwConfirm"></p>
</body>
</html>