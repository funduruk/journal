<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Журнал</title>
    <style>
        .btn {
            padding: 10px 20px;
            font-size: 16px;
            font-weight: bold;
            text-transform: uppercase;
            border: none;
            border-radius: 5px;
            background-color: #180d0d;
            color: #f31414;
            cursor: pointer;
            transition: background-color 0.3s, color 0.3s; /* Анимация изменения цвета фона и текста */
        }
        .btn:hover {
            background-color: #ff0000; /* Оранжевый цвет при наведении */
            color: #180d0d; /* Белый цвет текста при наведении */
        }
    </style>
</head>
<body>
<h1>ЖУРНАЛ МГКИТ</h1>
<h3>Посмотреть список студентов</h3>
<form action="student/all" method="get">
    <input type="submit" class="btn" value="Посмотреть"/>
</form>
<hr>
<h3>Посмотреть список преподователей</h3>
<form action="teacher/all" method="get">
    <input type="submit" value="Посмотреть">
</form>
</body>
</html>
