<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
  <title>인사관리 시스템</title>

  <style>
    .pagination {
      justify-content: center;
    }
    .table td, .table th {
      vertical-align: middle;
      text-align: center;
    }
    .custom-control {
      padding-right: 0
    }
  </style>
</head>

<body>
  <div class="container">
	<h2 class="pt-3"> 인사관리시스템 </h2>
	<hr>
	    <ul class="nav">
	      <li class="nav-item">
	        <a class="nav-link active" href="/board/list">사원목록</a>
	      </li>
	    </ul>
	<hr>

    <div class="card border-0">
      <div class="card-body">

        <!-- Search form -->
        <form class="form-inline d-flex justify-content-center md-form form-sm active-cyan-2 mt-2"
        		action="/board/list" method="get">

          <!-- Material inline 1 -->
          <div class="form-check form-check-inline">
            <input type="radio" class="form-check-input" value="all" name="searchType"
            	<c:out value="${param.searchType eq 'all' ? 'checked' : ''}"/> >
            <label class="form-check-label" for="materialInline1">전체</label>
          </div>

          <!-- Material inline 2 -->
          <div class="form-check form-check-inline">
            <input type="radio" class="form-check-input" value="noLeave" name="searchType"
            	<c:out value="${param.searchType eq 'noLeave' ? 'checked' : ''}"/> >
            <label class="form-check-label" for="materialInline2">근무자</label>
          </div>

          <!-- Material inline 3 -->
          <div class="form-check form-check-inline">
            <input type="radio" class="form-check-input" value="leave" name="searchType"
            	<c:out value="${param.searchType eq 'leave' ? 'checked' : ''}"/> >
            <label class="form-check-label" for="materialInline3">퇴사자</label>
          </div>

          <input class="form-control form-control-sm mr-3 ml-3" type="text" 
          	id="searchKeyword" value="${param.searchKeyword}" name="searchKeyword" placeholder="성명" aria-label="Search">
          <button type="submit"><i class="fas fa-search" aria-hidden="true"></i></button>
        </form>
      </div>
    </div>
    
    <div class="table-responsive-xl">
      <table class="table table-hover table-striped table-bordered">
        <thead class="thead-dark">
          <tr>
            <th scope="col">선택</th>
            <th scope="col">사원번호</th>
            <th scope="col">성명</th>
            <th scope="col">주민번호</th>
            <th scope="col">부서명</th>
            <th scope="col">직위</th>
            <th scope="col">입사일</th>
            <th scope="col">퇴사일</th>
            <th scope="col">Email</th>

          </tr>
        </thead>
        <tbody>
          	<c:forEach var="e" items="${list}">
          	<tr>
          		<td><input type="checkbox"></td>
          		<td>${e.employee_id}</td>
	            <td>${e.name}</td>
	            <td>${e.reg_no}</td>
	            <td>${e.department_name}</td>
	            <td>${e.position_name}</td>
	            <td>${e.hire_date}</td>
	            <td>${e.leave_date}</td>
	            <td>${e.email}</td>
	        </tr>
          	</c:forEach>
          
        </tbody>
      </table>

    </div>

    <div class="card border-0">
      <div class="card-body">
        <nav aria-label="Page navigation">
          <ul class="pagination pagination-circle pg-blue">
          
          	<!-- 이전 페이지 -->
            <li class="page-item">
            	<c:if test="${pageMaker.startPage != 1}">
	            	<a class="page-link" href="list${pageMaker.makeQuery(pageMaker.startPage - 1)}" aria-label="Previous">
		                <span aria-hidden="true">&laquo;</span>
		                <span class="sr-only">Previous</span>
	              	</a>
            	</c:if>
            	<c:if test="${pageMaker.startPage == 1}">
	            	<a class="page-link" aria-label="Previous">
		                <span aria-hidden="true">&laquo;</span>
		                <span class="sr-only">Previous</span>
	              	</a>
            	</c:if>
            </li>
            
            <!-- 페이지 목록 -->
            <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
				<c:if test="${param.page == idx}">
					<li class="page-item active">
						<a class="page-link" href="list${pageMaker.makeQuery(idx)}&searchkeyword=${param.searchKeyword}&=${param.searchType}">${idx}</a>
					</li>
				</c:if>
				<c:if test="${param.page != idx}">
					<li class="page-item">
						<a class="page-link" href="list${pageMaker.makeQuery(idx)}">${idx}</a>
					</li>
				</c:if>
			</c:forEach>
            
            <!-- 다음 페이지 -->
            <li class="page-item">
            	<c:if test="${pageMaker.next}">
	            	<a class="page-link" href="list${pageMaker.makeQuery(pageMaker.endPage + 1)}" aria-label="Next">
		                <span aria-hidden="true">&raquo;</span>
		                <span class="sr-only">Next</span>
	            	</a>
            	</c:if>
            	<c:if test="${!pageMaker.next}">
	            	<a class="page-link" aria-label="Next">
		                <span aria-hidden="true">&raquo;</span>
		                <span class="sr-only">Next</span>
	            	</a>
            	</c:if>
            </li>
          </ul>
        </nav>
      </div>
    </div>
    
    

    <div class="card border-0">
      <div class="card-body pl-0 pt-0">
        <!-- <div class="btn-group" role="group" aria-label="buttons"> -->
        <a href="/board/writeView"><button type="button" class="btn btn-dark mr-3">추가</button></a>
        <button type="button" class="btn btn-dark">삭제</button>
        <!-- </div> -->
      </div>
    </div>

  </div>

  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

</html>