function ajax_comment() {
    let newcomment = document.getElementById('comment_textarea').value;
    let statuename = document.getElementById('statuename').innerText;
    console.log("newcomment"+ newcomment);
    console.log("statuename"+statuename);
    if(newcomment==='') {
        alert("请输入评论内容");
        return false;
    }
    $.ajax({
        type: "post",  //数据提交方式（post/get）
        url: "/addComment",  //提交到的url
        data: {"newcomment":newcomment,
            "statuename":statuename},//提交的数据
        dataType: "json",//返回的数据类型格式
        success: function(msg){
            if (msg.code === 200){
                alert("评论成功");
                document.getElementById("comment_textarea").value="";
                return false;
            }else {
                alert("评论失败");
            }
        }
    });

}
function ajax_findCommentByStatuename() {
    $.ajax({
        type: "post",  //数据提交方式（post/get）
        url: "/findCommentByStatuename",  //提交到的url
        data: {"statuename":tempStatueName},//提交的数据
        success: function(data){
            $('#comment').html(data);
        },
        error:function (data) {
            console.log("error:ajax  findCommentByStatuename");
        }
    });
}

function  ajax_findCommentByUsername() {
    $.ajax({
        type:"post",
        url:"/findCommentByUsername",
        data:{"username":tempPlayerName},
        success:function (data) {
            console.log("username success");
            $('#personnalComment').html(data);
        },
        error:function (data) {
            console.log("eeeer personal comment");
        }
    });
}

function toPersonalInfo() {
    window.location.href = "/user/personalPage";
}

function quit() {
    $.ajax({
        type: "get",  //数据提交方式（post/get）
        url: "/user/quit",  //提交到的url
        dataType: "json",//返回的数据类型格式
        success: function (msg) {
            if (msg.code === 200) {
                alert("退出成功");
                window.location.href = "/user/loginPage";
                return false;
            } else {
                alert("退出失败");
            }
        }
    });
}