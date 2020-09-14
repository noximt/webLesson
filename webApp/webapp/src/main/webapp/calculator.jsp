<html>
<head>
    <title>
        Calculation page
    </title>
<body>
<form action="/calculate" method="post">
    Input num1
    <input type="number" name="x">
    <br>
    Input num2
    <input type="number" name="y" >
    <br>
    Select operation type
    <select name="optype">
        <option value="sum">sum</option>
        <option value="sub">sub</option>
        <option value="mul">mul</option>
        <option value="div">div</option>
    </select>
    <button>Ok</button>
</form>
<label> Your result = ${requestScope.result}</label>
</body>
</html>
