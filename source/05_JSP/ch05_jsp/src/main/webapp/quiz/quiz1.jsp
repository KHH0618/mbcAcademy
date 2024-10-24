<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	String conPath = request.getContextPath(); //톰캣에 실행되는 프로젝트 이름
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		String name = request.getParameter("name");
		String numberStr = request.getParameter("number");
		int number = 0;
		long result = 0;
		if(name != null && numberStr != null && !numberStr.equals("")){
			name.trim();
			number = Integer.parseInt(numberStr);
			for (int i = 0; i<=number; i++){
				result += i;
			}
		}else if (name == null){
			name = "";
		}
		if(numberStr == null){
			numberStr = "";
		}
	%>
	<form action="">
		<table>
			<caption>입력</caption>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=<%=name %>></td>
			</tr>
			<tr>
				<td>숫자</td>
				<td><input type="number" name="number" value=<%=numberStr %>></td>
			</tr>
			<tr>
				<td><input type="submit" value="누적"></td>
			</tr>
		</table>
		<%
			if(!numberStr.equals("")){
				out.print("<h2>1부터 " + number + "까지 누적합은 " + result + "입니다</h2>");				
			}
		%>
	</form>
</body>
</html>