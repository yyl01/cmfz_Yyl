<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
   $(function(){
       $('#tt').treegrid({
           url:'/cmfz_Yyl/album/showAll',
           idField:'id',
           toolbar:'#tbs4',
           treeField:'title',
           fit:'true',
           fitColumns:'true',
           columns:[[
               {field:'title',title:'名称',width:60,align:'right'},
               {field:'downPath',title:'下载路径',width:60,align:'right'},
               {field:'size',title:'章节大小',width:60,align:'right'},
               {field:'duration',title:'章节时长',width:60,align:'right'}
           ]]
       });

   });

    function adds(){

        $("#savec").dialog({
            width:500,
            height:400,
            buttons:[
                {
                    iconCls:'icon-add',
                    text:'保存',
                    handler:function(){
                        $("#save4").form('submit',{
                            url:'/cmfz_Yyl/album/save',
                            success: function (result) {
                                var resultobj=$.parseJSON(result);
                                if(resultobj.success){
                                    $.messager.show({title:'提示',msg:'添加成功！！！'});
                                }else{
                                    $.messager.show({title:'提示',msg:'添加失败！！！'});
                                }
                                $("#savec").dialog('close');
                                $("#tt").treegrid('reload');
                            }
                        });
                    }


                }
            ]

        });
    }
   function addz(id) {
       var row = $("#tt").datagrid('getSelections');
       for (var i = 0; i < row.length; i++) {
           id = row[i].id;
           var count=row[i].count;
       }
       if (row.length <= 0) {
           $.messager.show({title: '提示', msg: '请选中一张专辑！！！'});
       }else if(count==null){
           $.messager.show({title: '提示', msg: '请选中一张专辑！！！'});
       }
         else{
           $("#saved").dialog({
               width: 500,
               height: 400,
               buttons: [
                   {
                       iconCls: 'icon-add',
                       text: '保存',
                       handler: function () {
                           $("#save5").form('submit', {
                               url: '/cmfz_Yyl/chapter/save?id=' + id,
                               success: function (result) {
                                   var resultobj = $.parseJSON(result);
                                   if (resultobj.success) {
                                       $.messager.show({title: '提示', msg: '添加成功！！！'});
                                   } else {
                                       $.messager.show({title: '提示', msg: '添加失败！！！'});
                                   }
                                   $("#saved").dialog('close');
                                   $("#tt").treegrid('reload');
                               }
                           });
                       }


                   }
               ]

           });
       }
       }
   function show(id,coverImg) {
       var row = $("#tt").datagrid('getSelections');
       for (var i = 0; i < row.length; i++) {
           id = row[i].id;
           var count=row[i].count;
           coverImg=row[i].coverImg;
       }
       if (row.length <= 0) {
           $.messager.show({title: '提示', msg: '请选择一张专辑！！！'});
       } else if (count==null) {
           $.messager.show({title: '提示', msg: '请选择一张专辑！！！！！！'});
       } else {


           $("#show").dialog({
               width: 500,
               height: 400,
               href: '/cmfz_Yyl/album/show.jsp?id=' + id+'&coverImg='+coverImg,

           });
       }
   }
function download(downPath){
    var row = $("#tt").datagrid('getSelections');
    for (var i = 0; i < row.length; i++) {
        downPath = row[i].downPath;
    }
    if (row.length <= 0) {
        $.messager.show({title: '提示', msg: '请选择要下载的章节！！！'});
    } else if (downPath==null) {
        $.messager.show({title: '提示', msg: '请选择要下载的章节！！！！！！'});
    } else {
        location.href="/cmfz_Yyl/chapter/download?openStyle=attachment&fileName="+downPath;

    }
}


</script>
<table id="tt" ></table>
<div id="tbs4">
    <div href="javascript:;" class="easyui-linkbutton" onclick="show()" data-options="iconCls:'icon-search',plain:true">专辑详情</div>
    <div href="javascript:;" class="easyui-linkbutton" onclick="adds()" data-options="iconCls:'icon-add',plain:true">添加专辑</div>
    <div href="javascript:;" class="easyui-linkbutton" onclick="addz()" data-options="iconCls:'icon-add',plain:true">添加章节</div>
    <div href="javascript:;" class="easyui-linkbutton" onclick="download();" data-options="iconCls:'icon-20130406125519344_easyicon_net_16',plain:true">下载音频</div>
</div>

<div id="savec" data-options="href:'/cmfz_Yyl/album/addAlbum.jsp',iconCls:'icon-save',width:500,height:400,title:'保存'"></div>
<div id="saved" data-options="href:'/cmfz_Yyl/album/addChapter.jsp',iconCls:'icon-save',width:500,height:400,title:'保存'"></div>
<div id="show" data-options="href:'/cmfz_Yyl/album/show.jsp',iconCls:'icon-save',width:500,height:400"></div>
