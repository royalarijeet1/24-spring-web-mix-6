<%@page import="com.bean.ProductCartBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CHECKOUT</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
	<%
		List<ProductCartBean> products = (List<ProductCartBean>) request.getAttribute("products");
		Float price = 0.0f;
	%>
	
	
	<div class="container">
		    <div class="py-5 text-center">
		        <h2>Checkout form</h2>
		    </div>
		    <div class="row">
    	        <div class="col-md-4 order-md-2 mb-4">
	    	        <h4 class="d-flex justify-content-between align-items-center mb-3">
		                <span class="text-muted">Your cart</span>
	            	</h4>
	            	<ul class="list-group mb-3 sticky-top">
		            	<li class="list-group-item d-flex justify-content-between lh-condensed">
		                    <div>
		                        <h6 class="my-0">Product name</h6>
		                        <small class="text-muted">Brief description</small>
		                    </div>
		                    <%
								for (ProductCartBean p : products) {
									out.print(p.getProductName()+", ");
									price = price + (p.getPrice()*p.getQty());
								}
							%>
		                    
		                </li>
		                <li class="list-group-item d-flex justify-content-between">
		                    <span>Final Amount (Rs)</span>
		                    <strong>Rs. <%=price%></strong>
	                	</li>
	            	</ul>
            	</div>
            	<div class="col-md-8 order-md-1">
            		<form class="needs-validation" novalidate="">
	            		<hr class="mb-4">
	            		<h4 class="mb-3">Payment</h4>
	            		<div class="row">
	            			<div class="col-md-6 mb-3">
	            				<label for="cc-name">Name on card</label>
	            				<input type="text" class="form-control" id="cc-name" placeholder="" required="">
	            			</div>
	            			<div class="col-md-6 mb-3">
	            				<label for="cc-number">Credit card number</label>
                        		<input type="text" class="form-control" id="cc-number" placeholder="" required="">
	            			</div>
	            			
	            		</div>
	            		<div class="row">
	            			<div class="col-md-6 mb-3">
	            				<label for="cc-ed">Expiry Date</label>
                        		<input type="text" class="form-control" id="cc-ed" placeholder="" required="">
	            			</div>
	            			<div class="col-md-6 mb-3">
	            				<label for="cc-CVV">CVV</label>
                        		<input type="password" class="form-control" id="cc-CVV" placeholder="" required="">
	            			</div>
	            		</div>
	            		<hr class="mb-4">
	            		<button class="btn btn-primary btn-lg btn-block" type="submit">Pay</button>
            		</form>
            	</div>
		    </div>
	</div>        
</body>
</html>