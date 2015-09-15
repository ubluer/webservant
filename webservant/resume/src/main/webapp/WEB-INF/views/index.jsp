<!DOCTYPE html>
<html>
<head>
    <title>
        abc
    </title>
</head>
<body>
<h2>Hello World!</h2>
<img id='img' src='img1.jpg' alt='爸爸去哪儿' ></img>
<div style='background-color: #384757;width:500px;height:1000px;font-size:50px;'>new style</div>
<div id="a">baidu</div>
<div id='parent'><div><a>a</a><a>b</a></div></div>
<a style='color:green;' href='http://www.baidu.com' target='_blank'> baidu</a>
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
    },500);

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