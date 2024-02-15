<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Список студентов</title>
</head>
<body>
<h1>Студенты</h1>

<#list students as student>
    <div>
        <p>${student.firstName} ${student.lastName} | <a href="/studentInfo/${student.id}"> Подробнее.</a></p>
    </div>
</#list>
<form action="/student/create" method="post" enctype="multipart/form-data">
    Имя студента: <input type="text" name="firstName"/><br>
    Фамилия студента: <input type="text" name="lastName"/><br>
    Почта студента: <input type="text" name="email"/><br>
    Номер телефона студента: <input type="text" name="numberPhone"/><br>
    Адрес студента: <input type="text" name="address"/><br>
    Возраст студента: <input type="number" name="age"/><br>
    Курс студента: <input type="number" name="course"/><br>
    <#--    id студента: <input type="number" name="id"/><br>-->
    Фото: <input type="file" name="file"/><br><br>

    <input type="submit" value="Добавить студента"/>
</form>

<form action="/" method="get">
    <input type="submit" value="Вернуться!">
</form>
</body>
</html>