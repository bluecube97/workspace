let loginSuccess = 'false';

function login() {
    let userId = document.querySelector('#uid').value;
    let userPass = document.querySelector('#upass').value;
    const modalBody = document.querySelector('#modalBody');

    fetch('/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: new URLSearchParams({pid: userId, ppass: userPass})
    })
        .then(responses => responses.json())
        .then(data => {
            modalBody.textContent = data.message;
            $('#idCheckModal').modal('show');
            loginSuccess = data.isSuccess;
        });
}

$('#idCheckModal').on('hidden.bs.modal', function () {
    if (loginSuccess === 'true') { // 로그인이 성공했다면
        location.href = '/board/list'; // /board로 리디렉션
    }
});