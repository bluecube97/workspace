let result = 0;

function formSubmit() {
    let val1 = document.querySelector('#js_val1').value;

    console.log("formSubmit" + val1);

    goJava(val1);
    result += parseInt(val1);
    document.querySelector("#result").innerHTML = result;
}

function goJava(val1) {
    console.log("goJava" + val1);
    fetch('/jstest', {
        method: 'POST',
        headers: {
            'Content-Type': "application/x-www-form-urlencoded; charset=UTF-8"
        },
        body: `val1=${encodeURIComponent(val1)}`
    })
        .then(respone => respone.text())
        .then(resp => {
            console.log(resp);
        })
        .catch(error => console.log('Error', error));
}

document.querySelector('#js_val1').addEventListener('keydown', (e)=>{
	if(e.key==='Enter'){
		formSubmit();
	}
})