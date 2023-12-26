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
 

   
   이미지 생성기 사용 규칙
   <div>
   Karlo API는 영문만 지원합니다.<br>
   Karlo는 단순한 단어의 나열부터 장문의 묘사까지 구체적으로 이해할 수 있으므로,<br>
   영어가 유창하지 않아도 누구나 쉽게 사용해 볼 수 있습니다.<br>
   </div>
   <div>예시
   </div>
   * 제시어를 입력해주세요 *
   <textarea class="form-control" name="prompt"></textarea>
   <button type="button" id="prompt-btn"></button>
   
  
  </div>
  
  <script type="text/javascript">
  
  $('#prompt-btn').click(function(){
	  const prompt=$('textarea[name=prompt]').val();
	  
	  $.ajax({
		  type:'POST',
		  url:'',
		  data:{
			  prompt:prompt
		  },success:function(result){
			  console.log(result)
		  }
			  
	  })
  })
  </script>
</body>
</html>