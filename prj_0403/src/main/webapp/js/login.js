function loginSubmit() {
	let id = document.querySelector('#id').value;
	let pw = document.querySelector('#pw').value;

	goJava(id, pw);
}

function goJava(val1, val2) {
	fetch('/login', {
		method: 'POST',
		headers: {
			'Content-Type': "application/x-www-form-urlencoded; charset=UTF-8"
		},
		body: `id=${encodeURIComponent(val1)}&pw=${encodeURIComponent(val2)}`
	})
		.then(respone => respone.text())
		.then(resp => {
			if (resp.length < 10) {
				alert(resp + " ID로 접속하셨습니다.");
				document.getElementById("userid").innerHTML = resp;
				window.location.href = "/board";
			} else {
				alert("로그인 실패");
			}
		})
		.catch(error => console.log('Error', error));
}

addEventListener('keydown', (e) => {
	if (e.key === 'Enter') {
		loginSubmit();
	}
})