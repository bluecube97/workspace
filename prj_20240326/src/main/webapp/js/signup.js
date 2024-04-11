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
			} else {
				document.getElementById("message").innerHTML = "사용 가능한 ID입니다.";
			}

		})
		.catch(error => console.error('Error: ', error));
}

function nameChk() {
	let name = document.getElementById('name').value;
	let leng = name.length;

	if (name == "" || leng < 1) {
		alert("이름을 입력하세요.");
		document.querySelector('#name').focus();
	} else if (leng > 10) {
		alert("이름은 10글자 이내로 입력하세요.");
		document.querySelector('#name').focus();
	}
}

function pwChk() {
	let pw = document.querySelector('#pw').value;
	let regex = /^(?=.*[!@#$%^&*]).{8,}$/;

	if (!regex.test(pw)) {
		document.getElementById("message").innerHTML = "8자리 이상 특수문자를 사용한 비밀번호만 사용 가능합니다.";
	} else {
		document.getElementById("message").innerHTML = "";
	}
}

function rePwChk() {
	let pw = document.querySelector('#pw').value;
	let pwchk = document.querySelector('#pwchk').value;

	if (pw !== pwchk) {
		document.getElementById("message").innerHTML = "비밀번호와 비밀번호 확인이 다릅니다.";
	} else {
		document.getElementById("message").innerHTML = "";
	}
}

function valChk() {
	let id = document.getElementById('id').value;
	let name = document.getElementById('name').value;
	let pw = document.getElementById('pw').value;
	let pwchk = document.getElementById('pwchk').value;
	let email = document.getElementById('email').value;

	pwChkFn(pw, pwchk);

	console.log(`id 값은 : ${id}`);
	console.log(`name 값은 : ${name}`);
	console.log(`pw 값은 : ${pw}`);
	console.log(`pwchk 값은 : ${pwchk}`);
	console.log(`email 값은 : ${email}`);
}

function pwChkFn(pw, pwchk) {
	let comparePass = (pw === pwchk);
	console.log(comparePass);
}

function loadJobList() {
	//let joblist = document.querySelector('#joblist').value;

	fetch('/joblist', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		}
	})
		.then(response => response.json())
		.then(jList => {
			fillSelectBox(jList);
		})
		.catch(error => console.error('Error: ', error))
}

function fillSelectBox(jList) {
	let selectBox = document.querySelector('#joblist');

	jList.forEach(item => {
		let option = document.createElement('option');
		option.value = item.code;
		option.text = item.codenm;
		selectBox.appendChild(option);
	});

}