function login() {
	let userId = document.querySelector('#uid').value;
	let userPass = document.querySelector('#upass').value;
	const modalBody = document.querySelector('#modalBody');

	console.log('1111111111111111');
	console.log(userId)
	console.log(userPass)
	fetch('/login', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded',
		},
		body: new URLSearchParams({ pid: userId, ppass: userPass })
	})
		.then(responses => responses.json())
		.then(data => {
			modalBody.textContent = data.message;
			$('#idCheckModal').modal('show');
		});
}

function closeModal() {
	$('#idCheckModal').modal('hide');
}