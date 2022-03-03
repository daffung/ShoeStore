<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<title>Đăng ký</title>
<body>

<div class="container-fluid pt-5">

        <div class="row px-xl-5">
            <div class="col-lg-8">
                <div class="mb-4">
                    <h4 class="font-weight-semi-bold mb-4 ">Billing Address</h4>
                    <form:form action="register" method="post" modelAttribute="account">  
                    <div class="row ">
                    
                        <div class="col-lg-6 form-group">
                            <label>Họ và tên</label>
                            <form:input required="required" class="form-control" type="text" placeholder="John" path="fullname" />  
                        </div>
                       <div class="col-md-6 form-group">
                            <label>Mật khẩu</label>
                            <form:input required="required" class="form-control" type="password" path="password" />  
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Gõ lại mật khẩu</label>
                            <input required="required" name="repeat_password" class="form-control" type="password">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>E-mail</label>
                            <form:input required="required" class="form-control" type="email" path="email" />  
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Điện thoại</label>
                            <form:input required="required" class="form-control"  placeholder="+123 456 789" path="phone" />  
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Địa chỉ</label>
                            <form:input class="form-control"  placeholder="123 Street" path="address" />  
                           
                        </div>
                        
                        <div class="col-md-6 form-group">
                            <label>Thành phố</label>
                         
                            <form:select class="custom-select" path="city">  
                               <form:option value="Hà Nội" label="Hà Nội"/>  
                               <form:option value="Hải Phòng" label="Hải Phòng"/>  
                               <form:option value="Tp Hồ Chí Minh" label="Tp Hồ Chí Minh"/>  
                               
                               
                            </form:select>
                        </div>
                        
                        <div class="col-md-6 form-group">
                        	<button type="submit" class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3">Đăng ký</button>
            			</div>
            			
                    </div>
                    </form:form>
                </div>
                
            </div>
            
            
        </div>
    </div>
    <!-- Checkout End -->





</body>