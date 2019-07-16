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

