<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${teacher.lastName}</title>
</head>
<body>
<h1>Информация о преподавателе</h1>
<b>Id преподавателя:</b> ${teacher.id}
<b>Имя препадователя:</b> ${teacher.firstName}<br>
<b>Фамилия препадователя:</b> ${teacher.lastName}<br>
<b>Почта препадователя:</b> ${teacher.email}<br>
<b>Возраст препадователя:</b> ${teacher.age}<br>
<b>Номер телефона преподавателя:</b> ${teacher.numberPhone}<br>
<b>Предмет преподавателя:</b> ${teacher.lesson}<br>
<b>Стаж преподавателя:</b> ${teacher.workExperience}

<form action="/teacher/all" method="get">
    <input type="submit" value="вернуться">
</form>
</body>
</html>