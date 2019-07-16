$(function(){
	// $('#btn_add').click(addProduct);
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
	$('.addToCart').click(addToCart);

	function addToCart(){
		// var qty = $(this).attr('product');
		// var qtyVal = parseInt(qty) != 0 ? parseInt(qty) : 1;
		var productId = $(this).attr('id');
		// var href = $(this).attr('href').split('?');
		// var url = href[0];
		// var params = href[1].split('&');
		// var productId = params[0].split('=')[1];
		var qty = $(this).parent().find("input").val();
		// var qtyX = params[1].split('=')[1];
		$.post("shopping-cart", {productId: productId, qty: (qty == 0) ? 1 : qty}, "json")
		.done(function (response) {
			$("#num-of-items").text(response);
			alert("Product was added successfully! Please check the cart for details.");
			// toastr["success"]('Product was added successfully! Please check the cart for details.');
		}).fail(function () {
			// toastr["error"]('Error! Please contact Administrator');
			alert("Error! Please contact Administrator");
		});

		// return false;
		// var productName = $('#product_name').val();
		// var productPrice = $('#product_price').val();
		// var product = {name:productName, price:productPrice};
		// $.post('product',{product: JSON.stringify(product)}, processData, "json")
	}

	function processData(data){
		//data = JSON.parse(data);
		var td0=$('<td>').text(data.id);
		var td1 = $('<td>').text(data.name);
		var td2 = $('<td>').text(data.price);
		var tr = $('<tr>').append(td0).append(td1).append(td2);
		$('#tbl_products>tbody').append(tr);
	}
});

