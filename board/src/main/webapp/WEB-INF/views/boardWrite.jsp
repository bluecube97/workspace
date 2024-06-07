<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://cdn.ckeditor.com/ckeditor5/35.2.1/classic/ckeditor.js"></script>
    <title>글쓰기</title>
</head>
<body>
    <div class="container">
        <h1 class="mt-5">글쓰기</h1>
        <form method="post" action="/board/write" enctype="multipart/form-data">
            <div class="form-group">
                <label for="brdtitle">Title</label>
                <input type="text" class="form-control" id="brdtitle" name="brdtitle" required>
            </div>
            <div class="form-group">
                <label for="brdmemo">Content</label>
                <textarea class="form-control" id="brdmemo" name="brdmemo"></textarea>
            </div>
            <div class="form-group">
                <label for="file">File Upload</label>
                <input type="file" class="form-control-file" id="file" name="file">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <a href="/board/list" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
    <script>
        ClassicEditor
            .create(document.querySelector('#content'))
            .catch(error => {
                console.error(error);
            });
    </script>
</body>
</html>