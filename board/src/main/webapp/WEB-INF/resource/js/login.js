function idCheck() {
    let userid = document.querySelector("#uid").value;
    const pids = ['user1', 'user2', 'user3'];
    const modal = document.querySelector(".modalBody");

    if (pids.includes(userid)) {
        modal.textContent = "이미 존재하는 ID입니다.";
    } else if (userid === "" || userid === null) {
        modal.textContent = "ID를 입력해주세요.";
    } else {
        modal.textContent = "사용 가능한 ID입니다.";
    }
    document.querySelector('.modal').style.display = 'flex';
}

function closeModal() {
    document.querySelector('.modal').style.display = 'none';
}