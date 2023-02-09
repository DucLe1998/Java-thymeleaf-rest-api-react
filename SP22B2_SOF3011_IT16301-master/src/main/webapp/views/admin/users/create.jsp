<%@ page language="java" 
contentType="text/html; 
charset=UTF-8"
session="true"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <c:if test="${ !empty sessionScope.error }" >
     <div class="alert alert-danger">
           ${ sessionScope.error }
     </div>
     <c:remove var = "error" scope="session"/>
 </c:if>
 
<form method="POST"
	action="/SP22B2_SOF3011_IT16301/admin/users/store">
	<div>
		<label>Họ tên</label>
		<input type="text" name="hoTen" />
	</div>
	<div>
		<label>Địa chỉ</label>
		<input type="text" name="diaChi" />
	</div>
	<div>
		<label>SĐT</label>
		<input type="text" name="sdt" />
	</div>
	<div>
		<label>Email</label>
		<input type="email" name="email" />
	</div>
	<div>
		<label>Password</label>
		<input type="password" name="password" />
	</div>
	<div>
		<label>Giới tính</label>
		<input type="radio" name="gioiTinh" value="1" />
		<label>Nam</label>
		<input type="radio" name="gioiTinh" value="0" />
		<label>Nữ</label>
	</div>
	<div>
		<button type = "submit">Thêm mới</button>
	</div>
</form>