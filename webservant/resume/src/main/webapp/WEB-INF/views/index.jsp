<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>
        abc
    </title>
</head>
<body>
<h2>Hello World!</h2>
<img id='img' src='img1.jpg' alt='爸爸去哪儿' />
<div style='background-color: #384757;width:500px;height:100px;font-size:50px;'>new style</div>
<script>
    var id = document.getElementById('a');
    id.innerHTML = 'absdfsa';
    var img=document.getElementById('img');
    var a = 0;
    setInterval(function(){
        a++;
        id.innerHTML = a;
        if(a%2==0){
            img.setAttribute('src','img1.jpg');
        }else{
            img.setAttribute('src','img2.jpg');
        }
    },5000);

    var bs=['baudu','du','dijf'];
    var divs=[];
    var parent = document.getElementById('parent');
    for(var i=0;i<bs.length;i++){
        var div = document.createElement('div');
        parent.appendChild(div);
    }


</script>
</body>
</html>