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
	<table>
		<caption>${person.name }님 상세보기</caption>
		<tr>
			<td colspan="7">
				<a href="${conPath }/">처음으로</a> &nbsp;
				<a href="${conPath }/insert.do">지인추가</a>
			</td>
		</tr>
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>연락처</th>
			<th>주소</th>
			<th>생일</th>
			<th>메모</th>
			<th>등록일</th>
		</tr>
		<tr>
			<td>${person.id } </td>
			<td>${person.name }</td>
			<td>${person.tel }</td>
			<td>${person.address }</td>
			<td><fmt:formatDate value="${person.birth }" pattern="YY년MM월dd일"/> </td>
			<td><pre>${person.memo }</pre></td>
			<td><fmt:formatDate value="${person.rdate }" pattern="YY년MM월dd일 E요일 hh시 mm분 (a)"/></td>
		</tr>
		<tr>
			<td colspan="7">
				<button onclick="location='${conPath}/update.do?id=${person.id }'">수정</button>
				<button onclick="location='${conPath}/update2.do?id=${person.id }'">수정2</button>
				<button onclick="location='${conPath}/delete.do?id=${person.id }'">삭제</button>
				<button onclick="location='${conPath}/list.do'">목록</button>
				<button onclick="location='${conPath}/insert.do'">추가</button>
			</td>
		</tr>
	</table>
</body>
</html>