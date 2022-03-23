/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 MinhLH           First Implement
 */


function checkChange(){
if(document.getElementById('message').value.trim() !== ""){
    console.log(document.getElementById('message').value)
    document.getElementById('comment-btn').removeAttribute('disabled')
} 
if(document.getElementById('message').value.trim() === ""){
    console.log(document.getElementById('message').value)
    document.getElementById('comment-btn').setAttribute('disabled',true)
} 
}


function loadMore() {
    var currentComment = document.getElementsByClassName('media').length
  $.ajax({
  type: "GET",
  url: "/SWP391-SE1511-G3-VS/loadMoreComment",
  data: {
      total : currentComment
  }
  ,
  success: function(data){
     let row = document.getElementById('mediaes');
     row.innerHTML += data;
  },
  error: function(data){
     $("#resultarea").text(data);
  }
})
}


function insertNewComment() {
    var comment = document.getElementById('message').value.trim();
    var today = new Date();
    let todayString = today.getFullYear() + "-" + (today.getMonth() < 10 ? '0' + (today.getMonth() + 1) : (today.getMonth() + 1)) + "-" + (today.getDate() < 10 ? '0' + today.getDate() : today.getDate())

  $.ajax({
  type: "GET",
  url: "/SWP391-SE1511-G3-VS/insertNewComment",
  data: {
      today : todayString,
      text : comment
  }
  ,
  success: function(data){
      var node = document.createElement('span');
      node.innerHTML += data;
     let row = document.getElementById('mediaes');
     row.insertBefore(node,row.children[0]);
     document.getElementById('message').value = null;
     checkChange();
  },
  error: function(data){
     $("#resultarea").text(data);
  }
})
}
