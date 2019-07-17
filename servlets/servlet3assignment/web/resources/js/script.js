$(function(){
	$(".icon-reduce").click(function (e) {
		var qty = $(this).parent().find("input");
		qty.val(function (i, old) {
			return parseInt(old) - 1;
		});
	});
	$(".icon-add").click(function (e) {
		var qty = $(this).parent().find("input");
		qty.val(function (i, old) {
			return parseInt(old) + 1;
		});
	});
	$(".addToCart").click(addToCart);

	$("#btnCheckout").click(checkout);

	// $("#btnLogin").click(login);

	$("#btnRegister").click(register);

	function register() {
		var newusername = $("input[name='newUsername']").val();
		var newpass = $("input[name='newPassword']").val();
		var cfpass = $("input[name='cfPassword']").val();
		if (newpass !== cfpass) {
			$("#registerErrMsg").text("Password confirmation is wrong.");
			$("#registerErrMsg").parent().removeClass("display-none");
			return false;
		}
		$.post("register", {username: newusername, password: newpass}, "json")
			.done(function (response) {
				console.log("Register new account successful.");
			}).fail(function () {
			console.log("Failt to create new account.");

		});
	}
	// $("input[name='newPassword']").onchange = validatePassword;
	// $("input[name='cfPassword']").onkeyup = validatePassword;
	// function validatePassword() {
	// 	var newpass = $("input[name='newPassword']");
	// 	var cfpass = $("input[name='cfPassword']");
	// 	if(newpass.val() !== cfpass.val()) {
	// 		cfpass.setCustomValidity("Passwords Don't Match");
	// 	} else {
	// 		cfpass.setCustomValidity('');
	// 	}
	// }

	// function login() {
	// 	// var username =
	// }
	function checkout() {
		// console.log("checkout click");
		if ($(".item").length > 0) {
			$(location).attr("href", "checkout");
			$("#num-of-items").text(0);
		} else {
			// $("#alertBody").html("Please add item in your cart before doing checkout.");
			// $("#myModal").modal("show");
			alert("Please add item in your cart before doing checkout.");
		}
	}
	function addToCart(){
		var productId = $(this).attr('id');
		var qty = $(this).parent().find("input").val();
		$.post("shopping-cart", {productId: productId, qty: (qty == 0) ? 1 : qty}, "json")
		.done(function (response) {
			$("#num-of-items").text(response);
			alert("Product was added successfully! Please check the cart for details.");
		}).fail(function () {
			alert("Error! Please contact Administrator");
		});
	}

});

