<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- sample main -->
     <div class="site-section"  data-aos="fade">
      <div class="container-fluid">

        <div class="row justify-content-center">

          <div class="col-md-7">
            <div class="row mb-5">
              <div class="col-12 ">
                <h2 class="site-section-heading text-center">메인 페이지(샘플)</h2>
              </div>
            </div>
          </div>

<script type="text/javascript">
console.log('${images[0].hits}');
</script>



        </div>
        <div class="row" id="lightgallery">
          <c:forEach items="${images[0].hits}" var="images">
          <div class="col-sm-6 col-md-4 col-lg-3 col-xl-3 item" data-aos="fade" data-src="images/big-images/nature_big_1.jpg" data-sub-html="<h4>Fading Light</h4><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolor doloremque hic excepturi fugit, sunt impedit fuga tempora, ad amet aliquid?</p>">
            <a href="#"><img src="${images.webformatURL}" alt="IMage" class="img-fluid"></a>
          </div>
          </c:forEach>

        </div>
      </div>
    </div>
    
      <!-- jQuery 스크립트 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
    <script src="/js/main/main.js"></script>
</body>
</html>