<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $("#tb").datagrid({
            url:"/cmfz_Yyl/banner/showAll",
            fit:true,
            toolbar:'#tbs',
            fitColumns:true,
            pagination: true,
            pageSize: 5,
            pageList: [1, 2, 3, 4, 5],
            columns:[[
                {title: 'cks', field: 'cks', checkbox: true},
                {field:'id',title:'编号'},
                {field:'title',title:'标题'},
                {field:'imgPath',title:'图片'},
                {field:'status',title:'状态'},
                {field:'date',title:'时间'},
                /*{field:'options',title:'options',
                formatter(value,row,index){
                    return "<a href='javascript:;' class='del' onclick=\"remove('"+row.id+"')\">删除</a>&nbsp;&nbsp;<a href='javascript:;' class='upd' onclick=\"update('"+row.id+"')\">修改</a>";
                }
                }*/

            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="/cmfz_Yyl/images/' + rowData.imgPath +'" style="height:60px;"></td>' +
                    '<td style="border:0">' +
                    '<p>title: ' + rowData.title + '</p>' +
                    '<p>date: ' + rowData.date + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }

            /* onLoadSuccess: function () {
                 $(".del").linkbutton({iconCls: 'icon-remove'});
                 $(".upd").linkbutton({iconCls: 'icon-edit'});
             },*/
        });
    });
    function remove(){
        var row = $("#tb").datagrid('getSelections');
        if (row.length <= 0) {
            $.messager.show({title: '提示', msg: '至少选中一行！！！'});
        } else {
            var ids = [];
            for (var i = 0; i < row.length; i++) {
                ids.push(row[i].id);
            }
            $.ajax({
                url: "/cmfz_Yyl/banner/deleteAll",
                type: "post",
                traditional: true,
                data: {id: ids},
                success: function (result) {
                    $.messager.show({title: '提示', msg: '删除成功'});
                    $("#tb").datagrid('reload');

                }, error: function () {
                    $.messager.show({title: '提示', msg: '删除失败'});
                    $("#tb").datagrid('reload');
                }
            })

        }


    }
    function adds(){
        $("#save").dialog({
            width:500,
            height:400,
            buttons:[
                {
                    iconCls:'icon-add',
                    text:'保存',
                    handler:function(){
                        $("#save1").form('submit',{
                            url:'/cmfz_Yyl/banner/save',
                            success: function (result) {
                                var resultobj=$.parseJSON(result);
                                if(resultobj.success){
                                    $.messager.show({title:'提示',msg:'用户添加成功！！！'});
                                }else{
                                    $.messager.show({title:'提示',msg:'用户添加失败！！！'});
                                }
                                $("#save").dialog('close');
                                $("#tb").datagrid('reload');
                            }
                        });
                    }


                }
            ]

        });
    }
   function upd(id,imgPath) {
       var row = $("#tb").datagrid('getSelections');
       if (row.length <= 0) {
           $.messager.show({title: '提示', msg: '请选择要修改的数据！！！'});
       } else if (row.length > 1) {
           $.messager.show({title: '提示', msg: '一次只能修改一条数据！！！'});
       } else {
           for (var i = 0; i < row.length; i++) {
               id = row[i].id;
           }
           $("#upddg").dialog({
               width: 500,
               height: 400,
               href: '/cmfz_Yyl/banner/update.jsp?id=' + id,
               buttons: [{
                   iconCls: 'icon-edit',
                   text: '更新',
                   handler: function () {
                       $("#upd").form('submit', {
                           url: '/cmfz_Yyl/banner/change',
                           success: function (result) {
                               var resultobj=$.parseJSON(result);
                               if(resultobj.success){
                                   $.messager.show({title:'提示',msg:'更新成功！！！'});
                               }else{
                                   $.messager.show({title:'提示',msg:'更新失败！！！'});
                               }
                               $("#upddg").dialog('close');
                               $("#tb").datagrid('reload');
                           }


                       });
                   }

               },
                   {
                       iconCls: 'icon-cancel',
                       text: '取消',
                       handler: function () {
                           $("#upddg").dialog('close');
                       }
                   }
               ],
           })
       }
   }
</script>
<table id="tb" ></table>
<div id="tbs">
    <div href="javascript:;" class="easyui-linkbutton" onclick="adds()" data-options="iconCls:'icon-add',plain:true">添加</div>
    <div href="javascript:;" class="easyui-linkbutton" onclick="upd()" data-options="iconCls:'icon-edit',plain:true">修改</div>
    <div href="javascript:;" class="easyui-linkbutton" onclick="remove();" data-options="iconCls:'icon-delete',plain:true">删除</div>

</div>

<div id="save" data-options="href:'/cmfz_Yyl/banner/add.jsp',iconCls:'icon-save',width:500,height:400,title:'保存用户信息'"></div>
<div id="upddg" data-options="iconCls:'icon-edit',width:500,height:400,title:'修改用户信息'"></div>