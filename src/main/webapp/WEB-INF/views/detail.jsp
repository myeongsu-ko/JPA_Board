<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp" %>


<main>
	<h1>계시글 상세보기</h1>
	<hr />
	
	<table border="1">
	<tr>
		<td>ID</td>
		<td>TITLE</td>
		<td>CONTENT</td>
		<td>READCOUNT</td>
		<td>CREATECOUNT</td>
	</tr>
	<tr>
		<td><input id="id" type="text" value="${board.id}" readonly="readonly"/></td>
		<td><input id="title" type="text" value="${board.title}"/></td>
		<td><input id="content" type="text" value="${board.content}"/></td>
		<td>${board.readCount}</td>
		<td>${board.createDate}</td>
	</tr>
	</table>
	<button onclick="deleteBoard(${board.id})">삭제</button>
	<button onclick="updateBoard(${board.id})">수정</button>
	</main>
	
	<script type="text/javascript">
	function updateBoard(id){
		//id, title, content
		//이렇게 하면 아이디값 찾을 수 있음
		let title_el=document.querySelector("#title").value;
		let content_el=document.querySelector("#content").value;
		
		let title = title_el;
		let content = content_el;
		
		console.log("id",id)
		console.log("content",content)
		console.log("title",title)

		let board={
			title:title,
			content:content
			}

		fetch("/board/"+id,{
				method:"put",
				headers:{
				  'Content-Type':'application/json; charset=utf-8',	
				},
				body:JSON.stringify(board)
			}).then(res=>res.text())
			.then(res=>{
			  if(res=="ok"){
				alert("수정완료");
				location.reload();
				}else{
					alert("수정실패");
					}
			});
		console.log(board)
		}
	
	function deleteBoard(id){
		fetch("/board/"+id,{
			method: "delete"
			}).then(res=>res.text())
			.then(res=>{
					if(res=="ok"){
						alert("삭제성공");
						location.href="/list"
					}else{
						alert("삭제실패");
						}
				});
		}

	</script>
	
<%@ include file="layout/footer.jsp" %>	