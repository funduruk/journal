<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${student.lastName}</title>
</head>
<body>

<h1>Информация о студенте</h1>
<#list images as img>
    <img src="/images/${img.id}" height="60px"/><br>
</#list>
<b>Id студента:</b> ${student.id}<br>
<b>Имя студента:</b> ${student.firstName}<br>
<b>Фамилия студента:</b> ${student.lastName}<br>
<b>Курс студента:</b> ${student.course}<br>
<b>Почта студента:</b> ${student.email}<br>
<b>Возраст студента:</b> ${student.age}<br>
<b>Номер телефона студента:</b> ${student.numberPhone}<br>
<b>Адрес студента:</b> ${student.address}<br>
<hr>
<form action="/student/delete/${student.id}" method="post">
    <input type="submit" value="удалить студента"/>
</form>
<br>
<form action="/student/all" method="get">
    <input type="submit" value="вернуться">
</form>
</body>
</html>