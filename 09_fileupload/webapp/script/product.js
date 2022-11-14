/**
 * 
 */
 
 /* 상품등록시 유효성 체크 */
 function productCheck() {
	var $name = $("#name");
	var $price = $("#price");
	var $image = $("#prod_image");
	var $description = $("#description");
	
	if ($name.val().length == 0) {
		alert("상품명을 입력해주세요.");
		$name.focus();
		return false;
	}
	
	if ($price.val().length == 0) {
		alert("가격을 입력해 주세요.");
		$price.focus();
		return false;
	}
	
	if (isNaN($price.val())) {
		alert("가격은 숫자를 입력해 주세요.")
		$price.focus();
		return false;
	}
	
	/*
	if ($image.val() == "") {
		alert("상품 이미지를 선택해주세요!");
		$image.focus();
		return false;
	}
	*/
	
	if ($description.val().length == 0) {
		alert("설명을 입력해 주세요.");
		$description.focus();
		return false;
	}
	
	return true;
 }