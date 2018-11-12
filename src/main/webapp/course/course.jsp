<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $("#tl").datagrid({
            url:"/cmfz_Yyl/course/showAll",
            fit:true,
            toolbar:'#tls',
            fitColumns:true,
            pagination: true,
            pageSize: 5,
            pageList: [1, 2, 3, 4, 5],
            columns:[[
                {title: 'cks', field: 'cks', checkbox: true},
                {field:'id',title:'编号'},
                {field:'title',title:'课程名称'},
                {field:'mark',title:'mark'},
                {field:'createTime',title:'创建时间'},
                /*{field:'options',title:'options',
                formatter(value,row,index){
                    return "<a href='javascript:;' class='del' onclick=\"remove('"+row.id+"')\">删除</a>&nbsp;&nbsp;<a href='javascript:;' class='upd' onclick=\"update('"+row.id+"')\">修改</a>";
                }
                }*/

            ]],
            /* onLoadSuccess: function () {
                 $(".del").linkbutton({iconCls: 'icon-remove'});
                 $(".upd").linkbutton({iconCls: 'icon-edit'});
             },*/
        });
    });
    function remove(){
        var row = $("#tl").datagrid('getSelections');
        if (row.length <= 0) {
            $.messager.show({title: '提示', msg: '至少选中一行！！！'});
        } else {
            var ids = [];
            for (var i = 0; i < row.length; i++) {
                ids.push(row[i].id);
            }
            $.ajax({
                url: "/cmfz_Yyl/course/deleteAll",
                type: "post",
                traditional: true,
                data: {id: ids},
                success: function (result) {
                    $.messager.show({title: '提示', msg: '删除成功'});
                    $("#tl").datagrid('reload');

                }, error: function () {
                    $.messager.show({title: '提示', msg: '删除失败'});
                    $("#tl").datagrid('reload');
                }
            })

        }


    }
    function adds(){
        $("#savef").dialog({
            width:500,
            height:400,
            buttons:[
                {
                    iconCls:'icon-save',
                    text:'保存',
                    handler:function(){
                        $("#save6").form('submit',{
                            url:'/cmfz_Yyl/course/save',
                            success: function (result) {
                                var resultobj=$.parseJSON(result);
                                if(resultobj.success){
                                    $.messager.show({title:'提示',msg:'添加成功！！！'});
                                }else{
                                    $.messager.show({title:'提示',msg:'添加失败！！！'});
                                }
                                $("#savef").dialog('close');
                                $("#tl").datagrid('reload');
                            }
                        });
                    }


                }
            ]

        });
    }

</script>
<table id="tl" ></table>
<div id="tls">
    <div href="javascript:;" class="easyui-linkbutton" onclick="adds()" data-options="iconCls:'icon-add',plain:true">添加课程</div>
    <div href="javascript:;" class="easyui-linkbutton" onclick="remove();" data-options="iconCls:'icon-delete',plain:true">删除课程</div>

</div>

<div id="savef" data-options="href:'/cmfz_Yyl/course/add.jsp',iconCls:'icon-save',width:500,height:400,title:'保存用户信息'"></div>