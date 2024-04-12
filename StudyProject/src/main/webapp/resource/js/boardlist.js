// 버튼 태그 등록
let signup = document.getElementById('signup');
let login = document.getElementById('login');
let logout = document.getElementById('logout');
let regedit = document.getElementById('regedit');

// 이벤트 리스너 등록
if (signup != null) {
    signup.addEventListener('click', function() {
        window.location.href = '/user/signup';
    });
}

if (login != null) {
    login.addEventListener('click', function() {
        window.location.href = '/user/login';
    });
}

if (logout != null) {
    logout.addEventListener('click', function() {
        window.location.href = '/user/logout';
    });
}

if (regedit != null) {
    regedit.addEventListener('click', function() {
        window.location.href = '/board/regedit';
    });
}
