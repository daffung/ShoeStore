<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>VNPAY Response - Payment Result</title>



    <body>
        
        <!--Begin display -->
        <div class="container">
        <br><hr>
        	<h1 class='text-center ${vnp_ResponseCode.equals("00") ? "text-success":"text-danger" }'>${message}</h1>
        	<br><hr>
            <table class="table table-dark table-hover">
             <tbody>
                <tr>
                    <td>Mã đơn hàng:</td>
                    <td>${vnp_TxnRef }</td>
                  </tr>
                  <tr>
                    <td>Số tiền:</td>
                    <td>${vnp_Amount} VND</td>
                  </tr>
                  <tr>
                    <td>Nội dung thanh toán:</td>
                    <td>${vnp_OrderInfo}</td>
                  </tr>
                  <tr>
                    <td>Mã phản hồi (vnp_ResponseCode):</td>
                    <td>${vnp_ResponseCode}</td>
                  </tr>
                  <tr>
                    <td>Mã GD Tại VNPAY</td>
                    <td>${vnp_TransactionNo}</td>
                  </tr>
                  <tr>
                    <td>Mã Ngân hàng</td>
                    <td>${vnp_BankCode}</td>
                  </tr>
                  <tr>
                    <td>Thời gian thanh toán</td>
                    <td>${vnp_PayDate}</td>
                  </tr>        
                </tbody>
            </table>
            
        </div>  
    </body>


