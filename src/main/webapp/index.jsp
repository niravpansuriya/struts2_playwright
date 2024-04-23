<!-- counter.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Counter</title>
		<script>
			function incrementCounter() {
				var counterElement = document.getElementById('counter');
				var counterValue = parseInt(counterElement.innerHTML);
				counterElement.innerHTML = counterValue + 1;
			}

			function decrementCounter() {
				var counterElement = document.getElementById('counter');
				var counterValue = parseInt(counterElement.innerHTML);
				counterElement.innerHTML = counterValue - 1;
			}
		</script>
	</head>
	<body>
		<h1>Counter: <span id="counter">0</span></h1>
		<button id="increase_button" onclick="incrementCounter()">
			Increase
		</button>
		<button id="decrease_button" onclick="decrementCounter()">
			Decrease
		</button>
	</body>
</html>
