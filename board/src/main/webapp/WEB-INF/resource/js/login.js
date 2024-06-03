function idCheck() {
    let userId = document.querySelector('#uid').value;
    let userPass = document.querySelector('#upass').value;
    const modalBody = document.querySelector('#modalBody');

    fetch('/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: new URLSearchParams({ id: userId, pass: userPass })
    })
        .then(response => response.json())
        .then(data => {
            modalBody.textContent = data.message;
            $('#idCheckModal').modal('show');
        });
}

function closeModal() {
    $('#idCheckModal').modal('hide');
}