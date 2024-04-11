function submitForm() {
	let input1 = document.getElementById("input1").value;
	let input2 = document.getElementById("input2").value;
	
	fetch('/', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
		},
		body: `input1=${encodeURIComponent(input1)}&input2=${encodeURIComponent(input2)}`
	})
		.then(respone => respone.text())
		.catch(error => console.error('Error: ', error));
	
	console.log(input1 + ", " + input2);
}