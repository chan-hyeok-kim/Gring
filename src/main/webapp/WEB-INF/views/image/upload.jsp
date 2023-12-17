<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/css/image/upload.css">
</head>
<body>
 <div class="site-section"  data-aos="fade">
 
 <form method="post" enctype="multipart/form-data">
   제목<input class="form-control">
   설명<textarea class="form-control"></textarea>
   
   <input class="form-control">
   <input type="file" class="form-control" name="photo">
   <button class="btn btn-primary">등록</button>
  </form>
  </div>
</body>
</html>