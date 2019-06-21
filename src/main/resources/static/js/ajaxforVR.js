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
            console.log("back");
            if (msg.code === 200){
                alert("评论成功");
                return false;
            }else {
                alert("评论失败");
            }
        }
    });

}
function ajax_findCommentByStatuename() {
    let statuename = document.getElementById('statuename').innerText;
    $.ajax({
        type: "post",  //数据提交方式（post/get）
        url: "/findCommentByStatuename",  //提交到的url
        data: {"statuename":statuename},//提交的数据
        // dataType: "json",//返回的数据类型格式
        success: function(data){
            // console.log("datahhhhhhhhh");
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