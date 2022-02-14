<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    	<div class="col-lg-12 well">
    	<div class="row">
    				<form action="/board/write" method="post" style="width:100%">
    					<div class="col-sm-12">
    						<div class="row">
    							<div class="col-sm-6 form-group">
							<label>성명</label>
							<input type="text" id="name" name="name" placeholder="성명" class="form-control">
						</div>
						<div class="col-sm-6 form-group">
							<label>주민번호</label>
							<input type="text" id="reg_no" name="reg_no" placeholder="주민번호" class="form-control">
						</div>
					</div>
						
					<div class="form-group">
						<label>주소</label>
						<textarea placeholder="주소" id="address" name="address" rows="3" class="form-control"></textarea>
					</div>
						
					<div class="row">
						<div class="col-sm-6 form-group">
			                <label>부서명</label>
			                <select class="form-control" id="department_id" name="department_id">
			                	<option value="10">관리부</option>
			                	<option value="20">영업부</option>
			                	<option value="30">구매부</option>
			                	<option value="40">인사부</option>
			                	<option value="50">구매부</option>
			                	<option value="60">IT사업부</option>
			                </select>
		                </div>
		                <div class="col-sm-6 form-group">
			                <label>직급</label>
			                <select class="form-control" id="position_id" name="position_id">
			                	<option value="10">사원</option>
			                	<option value="20">대리</option>
			                	<option value="30">과장</option>
			                	<option value="40">부장</option>
			                </select>
		                </div>
		            </div>
		            
		            <div class="row">
						<div class="col-sm-6 form-group">
							<label>입사일</label>
							<input type="text" placeholder="입사일" id="hire_date" name="hire_date" class="form-control">
						</div>
						
						<div class="col-sm-6 form-group">
							<label>퇴사일</label>
							<input type="text" placeholder="퇴사일" id="leave_date" name="leave_date" class="form-control">
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-4 form-group">
			                <label>급여은행</label>
			                <select class="form-control" id="bank_id" name="bank_id">
				                <option value="10">국민은행</option>
				                <option value="11">기업은행</option>
				                <option value="12">우리은행</option>
				                <option value="13">농협은행</option>
			                </select>
						</div>

						<div class="col-sm-8 form-group">
							<label>급여계좌</label>
							<input type="text" placeholder="급여계좌" id="bank_account" name="bank_account" class="form-control">
						</div>
					</div>
					
					<div class="form-group">
						<label>전화번호</label>
						<input type="text" placeholder="전화번호" id="phone_number" name="phone_number" class="form-control">
					</div>
					
					<div class="form-group">
						<label>Email </label>
						<input type="text" placeholder="Email" id="email" name="email" class="form-control">
					</div>
					
					<button type="submit" class="btn btn btn-dark mt-3">저장</button>
				</div>
			</form>
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