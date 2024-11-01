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
			//p태그와 input태그에 내용을 넣기
			$('p#msg').html('<b>중복된 아이디 입니다</b>');
			//$('p#msg').text('사용가능한 아이디 입니다');
			$('input[name="msg"]').val('안녕, 제이쿼리');
			//button클릭시 : p태그 내용과 input태그의 value를 가져와서 alert창에 출력
			$('button').click(function() {
				var pMsgTeg = $('p#msg').html();
				var pMsgText = $('p#msg').text();
				var inputMsg = $('input[name="msg"]').val();
				alert(inputMsg + '\n'+pMsgText + '\n'+pMsgTeg + '\n');
			});
		});
		
	</script>
</head>
<body>
	<p id="msg"></p>
	<p> 정보 : <input type="text" name="msg"></p>
	<button>msg 내용 경고!</button>
</body>
</html>