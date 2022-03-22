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
  url: "/SWP391_G3_VS/loadMoreCommnet",
  data: {
      total : currentComment
  }
  ,
  success: function(data){
     let row = document.getElementById('comments');
     row.innerHTML += data;
  },
  error: function(data){
     $("#resultarea").text(data);
  }
})
}
