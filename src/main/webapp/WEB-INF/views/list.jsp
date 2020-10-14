<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp" %>


<main >
	<h1 class="bg-dark text-white">계시글 목록</h1>
	<hr />
	<table class="table table-dark table-striped" >
	<tr>
		<td>ID</td>
		<td>TITLE</td>
		<td>CONTENT</td>
		<td>READCOUNT</td>
		<td>CREATECOUNT</td>
	</tr>
	<c:forEach var="board" items="${boards}">
	<tr>
		<td>${board.id}</td>
		<td><a href="/board/${board.id}"/>${board.title}</td>
		<td>${board.content}</td>
		<td>${board.readCount}</td>
		<td>${board.createDate}</td>
	</tr>
	</c:forEach>
	</table>
	</main>
<%@ include file="layout/footer.jsp" %>	