/**
 * 
 */
function paramChk(brdTitle, brdMemo) {
	if (brdTitle.length > 50) {
		alert("제목은 50자 이내로 입력해주세요.");
		return false;
	}

	if (brdMemo.length > 500) {
		alert("내용은 500자 이내로 입력해주세요.");
		return false;
	}

	return true;
}

function formSubmit() {
	let regForm = document.getElementById("regform");
	let brdTitle = document.getElementById("brdtitle").value;
	let brdMemo = document.getElementById("brdmemo").value;

	if(paramChk(brdTitle, brdMemo)){ // return값이 true면 실행
		regForm.submit();
	}
}