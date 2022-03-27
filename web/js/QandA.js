/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 MinhLH           First Implement
 */

function PostComment(obj)
{
    var con = obj;
    var content = document.getElementById("commentcontent").value;
    if (content.trim() == "")
    {
        return;
    }
    document.getElementById("commentcontent").value = "";
    $.ajax({
        url: "/SWP391_G3_VS(2)/QandA",
        type: "post", //send it through get method
        data: {
            account: con,
            contents: content
        },
        success: function (data) {
            var row = document.getElementById("contentcomment");
            row.innerHTML = data + row.innerHTML;
            console.log("oke");
        },
        error: function (xhr) {
            console.log("da co loi xay ra");
            //Do Something to handle error
        }
    });
}
;

async  function LoadMoreRely(obj, obj1)
{
    var exist = document.getElementsByClassName("blockrely" + obj).length;
    await $.ajax({
        url: "/SWP391_G3_VS(2)/LoadMoreRely",
        type: "post", //send it through get method
        data: {
            id: obj,
            exist: exist,
        },
        success: function (data) {
            var row = document.getElementById("r" + obj);
            row.innerHTML = row.innerHTML + data;
            console.log("oke");
            var exist = document.getElementsByClassName("blockrely" + obj).length;
            console.log("trong load more rely " + exist);
            if (exist >= obj1)
            {
                document.getElementById("blockloadrely" + obj).style.display = "none";
            }
        },
        error: function (xhr) {
            console.log("da co loi xay ra");
            //Do Something to handle error
        }
    });
    return document.getElementsByClassName("blockrely" + obj).length;
}

function Rely(id, obj, obj1)
{
    var con = obj;
    var idcom = id.toString();
    var content = document.getElementById("t" + idcom).value;
    if (content.trim() == "")
    {
        return;
    }
    document.getElementById("t" + idcom).value = "";
    $.ajax({
        async: false,
        url: "/SWP391_G3_VS(2)/AddRely",
        type: "post", //send it through get method
        data: {
            account: con,
            idcom: idcom,
            contents: content
        },
        success: async function (data) {
            var exist = document.getElementsByClassName("blockrely" + id).length;
            if (obj1 > 3)
            {
                while (exist <= obj1) {
                    console.log("92");
                    exist = await LoadMoreRely(id, obj1);
                    console.log("95 " + exist);
                }
                console.log(obj1);
            } else {
                var row = document.getElementById("r" + idcom);
                row.innerHTML = row.innerHTML + data;
            }
            console.log("oke");
        },
        error: function (xhr) {
            console.log("da co loi xay ra");
            //Do Something to handle error
        }
    });
}

function setFocus(id)
{
    document.getElementById(id).focus();
}

function Confirm(title, msg, $true, $false, id) { /*change*/
    var $content = "<div class='dialog-ovelay'>" +
            "<div class='dialog'><header>" +
            " <h3> " + title + " </h3> " +
            "<i class='fa fa-close'></i>" +
            "</header>" +
            "<div class='dialog-msg'>" +
            " <p> " + msg + " </p> " +
            "</div>" +
            "<footer>" +
            "<div class='controls'>" +
            " <button class='button button-danger doAction'>" + $true + "</button> " +
            " <button class='button button-default cancelAction'>" + $false + "</button> " +
            "</div>" +
            "</footer>" +
            "</div>" +
            "</div>";
    $('body').prepend($content);
    $('.doAction').click(function () {
        $.ajax({
            url: "/SWP391_G3_VS(2)/DeleteEditRelyComment",
            type: "get", //send it through get method
            data: {
                id: id,
            },
            success: function (data) {
                var myArray = data.split(".");
                if (myArray[0] == "com")
                {
                    var row = document.getElementById("contentcomment");
                    var row1 = document.getElementById("childcom" + myArray[1]);
                    row.removeChild(row1)
                }

                if (myArray[0] == "rel")
                {
                    console.log(data);
                    var row = document.getElementById("r" + myArray[2]);
                    var row1 = document.getElementById("childrel" + myArray[1]);
                    row.removeChild(row1)
                }
                console.log("oke");
            },
            error: function (xhr) {
                console.log("da co loi xay ra");
                //Do Something to handle error
            }
        });
        //window.open(id, "_blank"); /*new*/
        $(this).parents('.dialog-ovelay').fadeOut(500, function () {
            $(this).remove();
        });
    });
    $('.cancelAction, .fa-close').click(function () {
        $(this).parents('.dialog-ovelay').fadeOut(500, function () {
            $(this).remove();
        });
    });

}

function confirmdelete(obj)
{
    Confirm('CONFIRM', 'Are you sure you want to delete?', 'Yes', 'Cancel', obj); /*change*/
}

function Destroy(obj, obj1, id)
{
    document.getElementById(obj + "des" + obj1).style.display = 'none';
    document.getElementById(obj + "ent" + obj1).style.display = 'none';
    document.getElementById(obj + obj1).style.display = 'block';
    document.getElementById(id).value = '';
}

function edit(obj1, obj2, id, id1, obj)
{
    console.log(id1);
    document.getElementById(id).focus();
    document.getElementById(id).value = obj;
    document.getElementById(obj1 + "des" + obj2).style.display = 'block';
    document.getElementById(obj1 + "ent" + obj2).style.display = 'block';
    document.getElementById(obj1 + obj2).style.display = 'none';
    var button = document.getElementById(obj1 + "ent" + obj2);
    button.onclick = function ()
    {
        var content;
        var myArray = id1.split(".");
        if (myArray[0] == "com")
        {
            content = document.getElementById(id).value;
        } else
        {
            content = document.getElementById("t" + obj2).value;
        }
        if (content.trim() == "")
        {
            return;
        }
        $.ajax({
            url: "/SWP391_G3_VS(2)/DeleteEditRelyComment",
            type: "post", //send it through get method
            data: {
                id: id1,
                content: content,
            },
            success: function (data) {
                var myArray = data.split(".");
                if (myArray[0] == "com")
                {
                    var row = document.getElementById("pcomment" + myArray[1]);
                    row.innerHTML = content;
                }

                if (myArray[0] == "rel")
                {
                    var row = document.getElementById("prely" + myArray[1]);
                    row.innerHTML = content;
                }
                console.log("oke");
                Destroy(obj1, obj2, id);
            },
            error: function (xhr) {
                console.log("da co loi xay ra");
                //Do Something to handle error
            }
        });
    }
}

//function LoadMoreRely(obj,obj1)
//{
//    console.log(obj);
//    var exist = document.getElementsByClassName("blockrely"+obj).length;
//    console.log(exist);
//    $.ajax({
//        url: "/SWP391_G3_VS(2)/LoadMoreRely",
//        type: "post", //send it through get method
//        data: {
//            id: obj,
//            exist: exist,
//        },
//        success: function (data) {
//            var row = document.getElementById("r"+obj);
//            row.innerHTML = row.innerHTML + data;
//            console.log("oke");
//            var exist = document.getElementsByClassName("blockrely"+obj).length;
//            console.log(obj1);
//            console.log(exist);
//            if (exist == obj1)
//            {
//                document.getElementById("blockloadrely"+obj).style.display = "none";
//            }
//        },
//        error: function (xhr) {
//            console.log("da co loi xay ra");
//            //Do Something to handle error
//        }
//    });
//}

function LoadMoreComment(obj)
{
    var exist = document.getElementsByClassName("blockcomment").length;
    $.ajax({
        url: "/SWP391_G3_VS(2)/LoadMoreComment",
        type: "post", //send it through get method
        data: {
            exist: exist,
        },
        success: function (data) {
            var row = document.getElementById("contentcomment");
            row.innerHTML = row.innerHTML + data;
            console.log("oke");
            var exist = document.getElementsByClassName("blockcomment").length;
            if (exist == obj)
            {
                document.getElementById("LoadmoreCommentdiv").style.display = "none";
            }
        },
        error: function (xhr) {
            console.log("da co loi xay ra");
            //Do Something to handle error
        }
    });
}

