<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
          integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="/resource/js/login.js" defer></script>
    <title>Login Page</title>
</head>
<body>
    <!-- 로그인 폼 -->
    <div class="container">
        <h1>Login</h1>
        <i class="fa-solid fa-heart"></i>
        <form id="loginForm">
            <div class="form-group">
                <label for="uid">User ID</label> <input type="text"
                                                        class="form-control" id="uid" placeholder="Please your ID!">
            </div>
            <div class="form-group">
                <label for="upass">User Password</label> <input type="password"
                                                                class="form-control" id="upass"
                                                                placeholder="Please your PASSWORD!">
            </div>
            <button type="button" class="btn btn-primary" onclick="login()">Login</button>
        </form>
    </div>
    <!-- 로그인 폼 끝-->
    <!-- 모달  -->
    <div class="modal fade" id="idCheckModal" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">ID Check Result</h5>
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body" id="modalBody"></div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary"
                            data-dismiss="modal"> <!--onclick="gotoBoard()"-->Close
                    </button>
                </div>
            </div>
        </div>
    </div>
    <!-- 모달 끝 -->
</body>
</html>