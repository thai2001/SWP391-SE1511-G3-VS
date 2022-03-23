/*
 * Copyright(C) 2005, G3-VS.
 * Vehicle Store
 *  
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 MinhLH           First Implement
 */

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
    var currentComment = document.getElementsByClassName('media').length
  $.ajax({
  type: "GET",
  url: "/SWP391-SE1511-G3-VS/insertNewComment",
  data: {
      total : currentComment
  }
  ,
  success: function(data){
      var node = document.createElement('span');
      node.innerHTML += data;
     let row = document.getElementById('mediaes');
     row.insertBefore(node,row.children[0])
  },
  error: function(data){
     $("#resultarea").text(data);
  }
})
}
