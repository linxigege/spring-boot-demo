<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajax Document</title>

    <style>
        #result{
            width:200px;
            height:100px;
            border:solid 1px #90b;
        }
    </style>
</head>
<body>
<button>获取当前用户</button>
<div id="result"></div>

<script>
    const btn = document.getElementsByTagName("button")[0];
    var result = document.getElementById("result");
    btn.onclick = function(){
        //1.创建对象
        const xhr = new XMLHttpRequest()
        //2.初始化，设置请求方法和url
        xhr.open('GET','http://localhost:8080/getCurrentUser',true)
        //3.发送
        xhr.send();
        //4.事件绑定 处理服务端返回的结果
        xhr.onreadystatechange = function(){
            // 判断
            if(xhr.readyState == 4){

                if(xhr.status >=200 && xhr.status < 300){
                    //响应
                    result.innerHTML =xhr.response;
                }
            }
        }

    }
</script>
</body>
</html>