let isCanId = false;
let isCanName = false;
let isCanPw = false;
let isCanRePw = false;
//let canSignUp = false;

function idChk() {
	let id = document.getElementById('id').value;

	fetch('/signup', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
		},
		body: `id=${encodeURIComponent(id)}`
	})
		.then(respone => respone.text())
		.then(resp => {
			console.log(resp);
			if (resp >= 1) {
				document.getElementById("message").innerHTML = "이미 사용중인 ID입니다.";
				isCanId = false;
			} else {
				document.getElementById("message").innerHTML = "사용 가능한 ID입니다.";
				isCanId = true;
			}

		})
		.catch(error => console.error('Error: ', error));
}

function nameChk() {
	let name = document.getElementById('name').value;
	let leng = name.length;

	if (name == "" || leng < 1) {
		isCanName = false;
		document.querySelector('#name').focus();
		document.getElementById("message").innerHTML = "이름을 입력하세요.";
	} else if (leng > 10) {
		isCanName = false;
		document.querySelector('#name').focus();
		document.getElementById("message").innerHTML = "이름은 10자 미만이어야 합니다.";
	} else {
		document.getElementById("message").innerHTML = "사용 가능한 이름입니다.";
		isCanName = true;
	}
}

function pwChk() {
	let pw = document.querySelector('#pw').value;
	let regex = /^(?=.*[!@#$%^&*]).{8,}$/;

	if (!regex.test(pw)) {
		document.getElementById("message").innerHTML = "8자리 이상 특수문자를 사용한 비밀번호만 사용 가능합니다.";
		isCanPw = false;
	} else {
		document.getElementById("message").innerHTML = "사용 가능한 비밀번호 입니다.";
		isCanPw = true;
	}
}

function rePwChk() {
	let pw = document.querySelector('#pw').value;
	let pwchk = document.querySelector('#pwchk').value;

	if (pw !== pwchk) {
		document.getElementById("message").innerHTML = "비밀번호와 비밀번호 확인이 다릅니다.";
		isCanRePw = false;
	} else {
		document.getElementById("message").innerHTML = "비밀번호가 일치합니다.";
		isCanRePw = true;
	}
}

function valChk() {
	let id = document.getElementById('id').value;
	let name = document.getElementById('name').value;
	let gender = document.getElementById('gender').value;
	let pw = document.getElementById('pw').value;
	let pwchk = document.getElementById('pwchk').value;
	let email = document.getElementById('email').value;
	let canSignUp = false;

	pwChkFn(pw, pwchk);

	console.log(`id 값은 : ${id}`);
	console.log(`name 값은 : ${name}`);
	console.log(`성별 값은 : ${gender}`);
	console.log(`pw 값은 : ${pw}`);
	console.log(`pwchk 값은 : ${pwchk}`);
	console.log(`email 값은 : ${email}`);

	if (isCanId && isCanName && isCanPw && isCanRePw) {
		console.log("회원가입 성공");
		canSignUp = true;

		fetch('/signup', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
			},
			body: `canSignUp=${encodeURIComponent(canSignUp)}&id=${encodeURIComponent(id)}&name=${encodeURIComponent(name)}&gender=${encodeURIComponent(gender)}&pw=${encodeURIComponent(pw)}&email=${encodeURIComponent(email)}`
		})
			.then(respone => respone.text())
			.then(resp => {
				console.log(resp);
			})
			.catch(error => console.error('Error: ', error));
	} else {
		console.log("회원가입 실패");
	}
}

function pwChkFn(pw, pwchk) {
	let comparePass = (pw === pwchk);
	console.log(comparePass);
}
