<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>Trạng thái đăng kí</title>
<body>

<div class="container-fluid bg-secondary mb-5">
        <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
            <h1 class="font-weight-semi-bold text-uppercase mb-3">${status }</h1>
            <div class="d-inline-flex">
                <p class="m-0"><a href="<c:url value="/register"/>">Trở về trang đăng ký</a></p>
                <p class="m-0 px-2">-</p>
                <p class="m-0"><a href="<c:url value="/"/>">Trang chủ</a></p>
                
            </div>
        </div>
    </div>

</body>