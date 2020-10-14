<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>
<script>
$(document).ready(function() {
	  $('#summernote').summernote({
 	    	placeholder: 'content',
	        minHeight: 370,
	        maxHeight: null,
	        focus: true, 
	        lang : 'ko-KR'
	  });
	});
</script>

<main>
	<h1>글쓰기 페이지</h1>
	<hr />
		<input id="title" type="text" placeholder="제목"/>
		<textarea id="summernote" name="text" ></textarea>
		<button onclick="writeBoard()">글쓰기 완료</button>
</main>

<script type="text/javascript">
function writeBoard(){
	let title=document.querySelector("#title").value;
	let content=document.querySelector("#summernote").value;

	console.log("content",content)
	console.log("title",title)

	let board={
			title:title,
			content:content
			}
	
	fetch("/save",{
		method:"post",
		headers:{
			  'Content-Type':'application/json; charset=utf-8',	
			},
			body:JSON.stringify(board)
		}).then(res=>res.text())
		.then(res=>{
		if(res=="ok"){
		alert("글쓰기 성공");
		console.log(res);
		location.href="/list";
		}else{
			alert("글쓰기 실패")
		}
		})
}
</script>

<%@ include file="layout/footer.jsp"%>