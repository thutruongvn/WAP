$(function(){
	$(".icon-reduce").click(function (e) {
		let qty = $(this).parent().find("input");
		qty.val(function (i, old) {
			return parseInt(old) - 1;
		});
		// const trParents = $(this).parentsUntil("tbody");
        // 		// if(trParents != null && trParents.length > 1) {
        //         //     updateTotal(trParents[1]);
        //         // }
	});
	$(".icon-add").click(function (e) {
		let qty = $(this).parent().find("input");
		qty.val(function (i, old) {
			return parseInt(old) + 1;
		});
        // const trParents = $(this).parentsUntil("tbody");
        // if(trParents != null && trParents.length > 1) {
        //     updateTotal(trParents[1]);
        // }
	});
    $("input[id^='quantity_']").change(function () {
        let qty = $(this).val();
        // let oldVal = $(this).default();
        const trParents = $(this).parentsUntil("tbody");
        if(trParents != null && trParents.length > 1) {
            updateTotal(trParents[1], qty);
        }
    });
    function updateTotal(eTR, qty, oldQty) {
        // const qty = $(eTR).find("input[id^='quantity_']").val();
        const price = $($(eTR).find("span").filter(".price")[0]).text();
        const total = $(eTR).find("span").filter(".total")[0];
        $(total).text(qty*price);
        if(oldQty) {
            const change = qty*price - oldQty*price;
            const sumTotal = $(eTR).parent().find("span").filter("#sum");
            const sum = $(sumTotal).text();
            $(sumTotal).text(sum + change);
        }
    }
	$('#btnRemove, #btnUpdate').click(updateShoppingCart);

    function updateShoppingCart() {

        let action = $(this).val();
        let productIds = "";
        let updateIds = "";
        let product = {};
        let data = {"product": product};
        $('input[type=checkbox]').each(function () {
            let productId = $(this).val();
            updateIds += productId + ",";
            product[""+productId] = $("#quantity_"+productId).val();
            if (this.checked) {
                productIds += productId + ",";
                product[""+productId] = $("#quantity_"+productId).val();

            }
        });
        let url = "shopping-cart?ids=";
        url += (action === "remove") ? productIds : updateIds;
        url += "&action=" + action;

        if(productIds !== "" || updateIds !== "") {
            $.ajax({
                url: url,
                type: 'put',
                async: false,
                data: JSON.stringify(product),
                success: reloadPage,
                contentType: 'json'
            });
        }
    }
    function reloadPage(){
        location.reload();
    }
	$(".addToCart").click(addToCart);

	$("#btnCheckout").click(checkout);

	$("#btnRegister").click(register);

	function register() {
		let newusername = $("input[name='newUsername']").val();
		let newpass = $("input[name='newPassword']").val();
		let cfpass = $("input[name='cfPassword']").val();
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
		let productId = $(this).attr('id');
		let qty = $(this).parent().find("input").val();
		$.post("shopping-cart", {productId: productId, qty: (qty == 0) ? 1 : qty}, "json")
		.done(function (response) {
			$("#num-of-items").text(response);
			alert("Product was added successfully! Please check the cart for details.");
		}).fail(function () {
			alert("Error! Please contact Administrator");
		});
	}

    // let success = false;
    $(".payment-form").submit(function (e) {
        e.preventDefault();
        let order = {};
        order.fullName = $("#fullName").val();
        order.shippingAddress = $("#address").val();
        order.paymentMethod = $("[name='payment']:checked").val();
        order.comment = $("#comment").val();

        // console.log("order", order);

        $.post("checkout", {
            order: JSON.stringify(order)
        }).done(orderSuccess).fail(function () {
            alert("Error! Please contact Administrator");
        });
    });

    function orderSuccess(data) {
        if (data.indexOf("success") > -1) {
            alert(data)
            $(location).attr("href", "/");
        } else {
            alert("Error! Please contact Administrator");
            $(location).attr("href", "/");
        }
        // console.log(data);
    }
    // $(".close").click(function () {
    //     $("#myModal").css("display", "none");
    // });
    // function error(err) {
    //     // console.log(err);
    //     success = false;
    // };

    // $('#myModal').on('hidden.bs.modal', function (e) {
    //     // console.log("Hide");
    //     if(success) {
    //         $(location).attr("href", "/");
    //     }
    // });

});

