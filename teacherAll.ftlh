<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Преподователи</title>
</head>
<body>
    <h1>Список преподавателей</h1>
<#list teachers as teacher>
    <div>
        <p>${teacher.firstName} ${teacher.lastName} <a href="/teacherInfo/${teacher.id}"> Подробнее</a> </p>
    </div>
</#list>
    <form action="/teacher/create" method="post">
        Имя преподавателя: <input type="text" name="firstName"/><br>
        Фамилия преподавателя: <input type="text" name="lastName"/><br>
        Почта преподавателя: <input type="text" name="email"/><br>
        Номер телефона преподавателя: <input type="text" name="numberPhone"/><br>
        Предмет преподавателя: <input type="text" name="lesson"/><br>
        Возраст преподавателя: <input type="number" name="age"/><br>
        Стаж преподавателя: <input type="number" name="workExperience"/><br>
        <#--    id студента: <input type="number" name="id"/><br>-->

        <input type="submit" value="Добавить преподавателя"/>
    </form>
<form action="/" method="get">
    <input type="submit" value="Вернуться">
</form>
</body>
</html>