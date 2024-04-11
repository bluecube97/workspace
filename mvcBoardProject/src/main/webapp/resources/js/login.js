/**
 * 
 */
function UserCheck(){
	let id = document.getElementById("id").value
	let pw = document.getElementById("password").value
	
	fetch('/user/login',{
		method : 'POST',
		headers : {
			'Content-Type': "application/x-www-form-urlencoded; charset=UTF-8"
		},
		body:`id=${encodeURIComponent(id)}&pw=${encodeURIComponent(pw)}`
	})
	.then(response => response.text())
	.then(resp => {
		console.log(resp);
		if(resp >= 1){
			window.location.href="/board/board";  //여기로 이동
		}else{ 
			document.querySelector("#ment").innerHTML = "ID 와 PASSWORD 를 확인하세요."
		}
	})
	.catch(error => console.log.error('Error : ', error));
}