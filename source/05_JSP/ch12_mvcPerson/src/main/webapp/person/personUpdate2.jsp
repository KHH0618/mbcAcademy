<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath}"/><!-- 톰캣에 실행되는 프로젝트 이름 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="${conPath }/update.do" method="post">
		<input type="hidden" name="id" value="${person.id }">
		<table>
			<caption>${person.name }님 정보 수정 페이지</caption>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" placeholder="${person.name }"> </td>
			</tr>
			<tr>
				<th>전화</th>
				<td><input type="text" name="tel" placeholder="${person.tel }"> </td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address" placeholder="${person.address }"> </td>
			</tr>
			<tr>
				<th>생일</th>
				<td><input type="date" name="birth" value="${person.birth }"> </td>
			</tr>
			<tr>
				<th>메모</th>
				<td><textarea rows="3" cols="" name="memo" placeholder="${person.memo }"></textarea> </td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정하기" class="btn">
					<input type="button" value="목록" class="btn" onclick="location=${conPath}/">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>