<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<title>Đăng nhập</title>
<body id="login-body">
    <div id="login">
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                    <form:form id="login-form" class="form" action="login" method="post" modelAttribute="account">  
                       
                            <h3 class="text-center text-white">Đăng nhập</h3>
                            <span class="text-danger">${login_status }</span>
                            <div class="form-group">
                                <label for="email" class="text-white">E-mail:</label><br>
                                <form:input path="email" required="required" type="email" name="email" id="username" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-white">Password:</label><br>
                                <form:input path="password" required="required" type="password" name="password" id="password" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <label for="remember-me" class="text-white"><span>Remember me</span> <span><input id="remember-me" name="remember-me" type="checkbox"></span></label><br>
                                <button type="submit" class="btn btn-md btn-block btn-primary font-weight-bold my-3 py-3">Đăng nhập</button>
                            </div>
                            
                        
                       </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>