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
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<c:if test="${insertResult eq SUCCESS}">
		<script>
			alert('지인추가 완료했습니다');
		</script>
	</c:if>
	<c:if test="${insertResult eq FAIL}">
		<script>
			alert('지인추가 실패했습니다');
		</script>
	</c:if>
	<c:if test="${not empty deleteResult }">
		<c:if test="${deleteResult eq SUCCESS}">
			<script>
				alert('지인삭제 완료했습니다');
			</script>
		</c:if>
		<c:if test="${deleteResult eq FAIL}">
			<script>
				alert('지인삭제 실패했습니다');
			</script>
		</c:if>
	</c:if>
	
	<table>
		<tr>
			<td colspan="4">
				<a href="${conPath }/">처음으로</a> &nbsp;
				<a href="${conPath }/insert.do">지인추가</a>
			</td>
		</tr>
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>연락처</th>
			<th>생일</th>
		</tr>
		<c:if test="${empty personList || personList.size() eq 0}">
			<tr>
				<td colspan="7">등록된 친구가 없어</td>
			</tr>
		</c:if>
		<c:forEach var="person" items="${personList }">
			<tr onclick="location.href='${conPath}/info.do?id=${person.id }'">
				<td>${person.id } </td>
				<td>${person.name }</td>
				<td>${person.tel }</td>
				<td><fmt:formatDate value="${person.birth }" pattern="MM월dd일"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>