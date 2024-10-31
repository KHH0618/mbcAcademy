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
	<c:if test="${joinResult eq SUCCESS }">
		<script>alert('${memberJoinResult }');</script>
	</c:if>
	<c:if test="${joinResult eq FAIL }">
		<script>
			alert('${memberJoinResult }');
			history.back();
		</script>
	</c:if>
	<table>
		<tr>
			<th>순번</th>
			<th>ID</th>
			<th>PW</th>
			<th>이름</th>
			<th>생일</th>
			<th>가입일</th>
		</tr>
		<c:if test="${empty memberList || memberList.isEmpty() }">
			<tr><td colspan="6">가입한 회원이 없습니다.</td></tr>
		</c:if>
		<c:set var="no" value="1"/>
		<c:forEach var="member" items="${memberList }">
			<tr>
				<td>${no }</td>
				<td>${member.id }</td>
				<td>${member.pw }</td>
				<td>${member.name }</td>
				<td><fmt:formatDate value="${member.birth }" pattern="MM월dd일"/></td>
				<td><fmt:formatDate value="${member.rdate }" pattern="YY-MM-dd(E) hh:mm(a)"/></td>
			</tr>
			<c:set var="no" value="${no+1 }"/>
		</c:forEach>
	</table>
	<p>
		<button onclick="location.href='${conPath}/memberJoin.do'">회원가입</button>
		<button onclick="location.href='${conPath}/'">처음으로</button>
	</p>
</body>
</html>