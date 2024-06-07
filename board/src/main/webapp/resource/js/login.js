function idcheck() {
	const uid = document.getElementById('uid').value;
	const upass = document.getElementById('upass').value;

	const data = {
		pid: uid,
		ppass: upass
	};

	fetch('/user/login', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(data)
	})
		.then(response => response.json())
		.then(data => {
			if (data.redirect != null){
				window.location.href = data.redirect;
			} else {
				alert(data.message);
			}
		});
}