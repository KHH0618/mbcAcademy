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
	<form action="${conPath }/empSch" method="get">
		<p>
			이름 <input type="text" name="schName" value="${empty schName? "" : schName.trim().toUpperCase() }"> 
			직책 <input type="text" name="schJob" value="${empty schJob? "" : schJob.trim().toUpperCase() }">
			<input type="submit">
		</p>
	</form>
	<table>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>직책</th>
			<th>상사사번</th>
			<th>입사일</th>
			<th>급여</th>
			<th>상여</th>
			<th>부서번호</th>
		</tr>
		<c:if test="${empList.size() eq 0 }"><tr><td colspan="8"> 사원이 없습니다</td></tr></c:if>
		<c:forEach var="emp" items="${empList }">
			<tr>
				<td>${emp.empno }</td>
				<td>
				<c:if test="${emp.sal>=3000 }"><img src="${conPath }/img/hot.gif"/></c:if>
				<c:if test="${empty emp.mgr }"><b style="color:red;">${emp.ename }</b></c:if>
				<c:if test="${not empty emp.mgr }">${emp.ename }</c:if>
				</td>
				<td>${emp.job }</td>
				<td>${empty emp.mgr? "CEO" : emp.mgr }</td>
				<td><fmt:formatDate value="${emp.hiredate }" pattern="YYYY년MM월dd일(E) hh:mm:ss(a)" /> </td>
				<td><fmt:formatNumber value="${emp.sal }" pattern="##,###"/></td>
				<td>
				<c:if test="${emp.comm <= 0}">-</c:if>
				<c:if test="${emp.comm > 0}">
					<fmt:formatNumber value="${emp.comm }" pattern="##,###"/>
				</c:if>
				</td>
				<td>${emp.deptno }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>