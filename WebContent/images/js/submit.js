function submit_singleChose(){
      var qusType = '单选题';
      var  option_catchValue = $("#option_catchValue option:selected").val();//专业
      option_catchValue =1;
     //alert(option_catchValue);
      var  option_catchValue_ability = $("#option_catchValue_ability option:selected").val();//能力
      option_catchValue_ability=2;
      //alert(option_catchValue_ability);
      var  option_catchValue_indexPoint = $("#option_catchValue_indexPoint option:selected").val();//指标点
      option_catchValue_indexPoint = 3;
      //alert(option_catchValue_indexPoint);

      var  caption = $("#queName1").text();//标题
     //alert(caption);
      var  tipText= $("#queName2").text();//提示内容
      //alert(tipText);
      var  ansType = $("#ansType option:selected").val();//是否必答
     // alert(ansType);

      var chose_Num=getNum();//获取选项数目
      //alert(chose_Num);
      var chose_score_array = new Array();
      var chose_text_array = new Array();
      for (var i = 1; i <= chose_Num; i++) //获取每个选项的分数 和 内容
      {
        chose_score_array.push($("#"+"chose_score"+i+" option:selected").val());
      // alert(chose_score_array[i]);
       chose_text_array.push($("#"+"chose_text"+i).text());
        //alert(chose_text_array[i]);
      }

      //前端向后台发送数据
      //获取指标点表头信息专业

     //  var formData = new FormData();
     //   formData.append('option_catchValue' , option_catchValue);
     //   formData.append('option_catchValue_ability',option_catchValue_ability);
      $.ajax({
     type: 'get',
     url: 'aaa/bbb.do',
     contentType: 'application/json;charset=utf-8',
     traditional: true,
      dataType: 'json',
      data:{
              'queType':qusType,
              'option_catchValue':option_catchValue,
              'option_catchValue_ability':option_catchValue_ability,
              'option_catchValue_indexPoint':option_catchValue_indexPoint,
              'caption':caption,
              'tipText':tipText,
              'ansType':ansType,
                 "chose_Num":chose_Num,
                 chose_score_array,
                 chose_text_array
         },
     success: function (data) { //返回json结果
         alert(data);
     }
     });

}
function submit_multChose(){
     var  qusType = '多选题';
     var  option_catchValue = $("#option_catchValue option:selected").val();//专业
     option_catchValue =1;
    //alert(option_catchValue);
     var  option_catchValue_ability = $("#option_catchValue_ability option:selected").val();//能力
     option_catchValue_ability=2;
     //alert(option_catchValue_ability);
     var  option_catchValue_indexPoint = $("#option_catchValue_indexPoint option:selected").val();//指标点
     option_catchValue_indexPoint = 3;
     //alert(option_catchValue_indexPoint);

     var  caption = $("#queName1").text();//标题
    //alert(caption);
     var  tipText= $("#queName2").text();//提示内容
     //alert(tipText);
     var  ansType = $("#ansType option:selected").val();//是否必答
    // alert(ansType);

     var chose_Num=getNum();//获取选项数目
     //alert(chose_Num);
     var chose_score_array = new Array();
     var chose_text_array = new Array();
     for (var i = 1; i <= chose_Num; i++) //获取每个选项的分数 和 内容
     {
       chose_score_array[i] = $("#"+"chose_score"+i+" option:selected").val();
      //alert(chose_score_array[i]);
      chose_text_array[i] = $("#"+"chose_text"+i).text();
       //alert(chose_text_array[i]);
     }

     //前端向后台发送数据
     //获取指标点表头信息专业

    //  var formData = new FormData();
    //   formData.append('option_catchValue' , option_catchValue);
    //   formData.append('option_catchValue_ability',option_catchValue_ability);
     $.ajax({
    type: 'get',
    url: 'aaa/bbb.do',
    contentType: 'application/json;charset=utf-8',
    traditional: true,
     dataType: 'json',
     data:{
             'qusType':qusType,
             'option_catchValue':option_catchValue,
             'option_catchValue_ability':option_catchValue_ability,
             'option_catchValue_indexPoint':option_catchValue_indexPoint,
             'caption':caption,
             'tipText':tipText,
             'ansType':ansType,
                "chose_Num":chose_Num,
                chose_score_array,
                chose_text_array
        },
    success: function (data) { //返回json结果
        alert(data);
    }
    });


}
function submit_singleFill(){
  var qusType = '单项填空题';
  var  option_catchValue = $("#option_catchValue option:selected").val();//专业
  option_catchValue =1;
  //alert(option_catchValue);
  var  option_catchValue_ability = $("#option_catchValue_ability option:selected").val();//能力
  option_catchValue_ability=2;
  //alert(option_catchValue_ability);
  var  option_catchValue_indexPoint = $("#option_catchValue_indexPoint option:selected").val();//指标点
  option_catchValue_indexPoint = 3;
  //alert(option_catchValue_indexPoint);

  var  caption = $("#queName1").text();//标题
  //alert(caption);
  var  tipText= $("#queName2").text();//提示内容
  //alert(tipText);
  var  ansType = $("#ansType option:selected").val();//是否必答
  //alert(ansType);
      $.ajax({
     type: 'get',
     url: 'aaa/bbb.do',
     contentType: 'application/json;charset=utf-8',
     data:{
              'qusType':qusType,
             'option_catchValue':option_catchValue,
             'option_catchValue_ability':option_catchValue_ability,
             'option_catchValue_indexPoint':option_catchValue_indexPoint,
             'caption':caption,
             'tipText':tipText,
             'ansType':ansType

         },
     success: function (data) { //返回json结果
         alert(data);
     }
     });
}
function getNum(){           //获取选项数目并为选项设置id
  var chose_score = document.getElementsByClassName("chose_score");
  var chose_text = document.getElementsByClassName("chose_text");
  var chose_Num = chose_score.length;//选项数量
  //alert(chose_Num);
  for (var i = 0; i < chose_Num; i++) {
    chose_score[i].setAttribute("id","chose_score"+(i+1));
    //alert(chose_score[i].id);
    chose_text[i].setAttribute("id","chose_text"+(i+1));
  }
  return chose_Num;
}

function submit_multFill(){
  var qusType = '多项填空题';
  var  option_catchValue = $("#option_catchValue option:selected").val();//专业
  option_catchValue =1;
  //alert(option_catchValue);
  var  option_catchValue_ability = $("#option_catchValue_ability option:selected").val();//能力
  option_catchValue_ability=2;
  //alert(option_catchValue_ability);
  var  option_catchValue_indexPoint = $("#option_catchValue_indexPoint option:selected").val();//指标点
  option_catchValue_indexPoint = 3;
  //alert(option_catchValue_indexPoint);

  var  caption = $("#multFill_wap_qtest_id").text().toString();//标题
  //alert(caption);
  var  tipText= $("#queName2").text();//提示内容
  //alert(tipText);
  var  ansType = $("#ansType option:selected").val();//是否必答
// alert(ansType);


// for (var i = 1; i < count; i++) {
//   var range =$(".multFill_que_menu_center .cap2 p");
//   alert(range.text());
//     alert(range.text());
// }


 var count = getMulFillNum();
//  alert(count);;
  var minSize= new Array();
  var maxSize = new Array();

  for (var i = 1; i <= count; i++) {
    minSize[i] = $("#min"+i).text();
//    alert(minSize[i]);
    maxSize[i] = $("#max"+i).text();
//    alert(maxSize[i]);
    // maxSize[i] = range.innerHTML;
  }


    $.ajax({
    type: 'get',
    url: 'aaa/bbb.do',
    traditional: true,
    contentType: 'application/json;charset=utf-8',
    data:{
            'qusType' : qusType,
           'option_catchValue':option_catchValue,
           'option_catchValue_ability':option_catchValue_ability,
           'option_catchValue_indexPoint':option_catchValue_indexPoint,
           'caption':caption,
           'tipText':tipText,
           'ansType':ansType,
           'count':count,
           minSize,
           maxSize
       },
    success: function (data) { //返回json结果
       alert(data);
    }
    });
}
function getMulFillNum(){           //获取选项数目并为选项设置id
  var cap2 = document.getElementsByClassName("cap2");

  var fNum = cap2.length - 1;//选项数量
  return fNum;
}
function submit_fill(){
  var qusType = '文件上传题';
  var  option_catchValue = $("#option_catchValue option:selected").val();//专业
  option_catchValue =1;
  //alert(option_catchValue);
  var  option_catchValue_ability = $("#option_catchValue_ability option:selected").val();//能力
  option_catchValue_ability=2;
  //alert(option_catchValue_ability);
  var  option_catchValue_indexPoint = $("#option_catchValue_indexPoint option:selected").val();//指标点
  option_catchValue_indexPoint = 3;
  //alert(option_catchValue_indexPoint);

  var  caption = $("#queName1").text();//标题
  //alert(caption);
  var  tipText= $("#queName2").text();//提示内容
  //alert(tipText);
  var  ansType = $("#ansType option:selected").val();//是否必答
  //alert(ansType);
      $.ajax({
     type: 'get',
     url: 'aaa/bbb.do',
     contentType: 'application/json;charset=utf-8',
     data:{
              'qusType':qusType,
             'option_catchValue':option_catchValue,
             'option_catchValue_ability':option_catchValue_ability,
             'option_catchValue_indexPoint':option_catchValue_indexPoint,
             'caption':caption,
             'tipText':tipText,
             'ansType':ansType

         },
     success: function (data) { //返回json结果
         alert(data);
     }
     });
}
