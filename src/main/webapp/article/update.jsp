<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $("#upd2").form('load','/cmfz_Yyl/article/findOne?id=${param.id}');
</script>
<div style="text-align:center;">
    <form method="post" class="easyui-form" id="upd2" >
        <div style="margin-top:30px;margin-left: 25px;">
            id：<input  name="id" class="easyui-textbox" readonly="readonly" data-options="width:200,height:35">
        </div>
        <div style="margin-top:30px;margin-left:15px;">
            title：<input  name="title" class="easyui-textbox" readonly="readonly" data-options="required:true,width:200,height:35">
        </div>
        <div style="margin-top:20px;margin-right:10px;">
            imgPath：<input  name="imgPath" class="easyui-textbox" readonly="readonly"  data-options="width:200,height:35">
        </div>
        <div style="margin-top:20px;margin-right:10px;">
            content：<input  name="content" class="easyui-textbox" readonly="readonly"  data-options="required:true,width:200,height:35">
        </div>
        <div style="margin-top:20px;margin-right:10px;">
            pdDate：<input  name="pdDate" class="easyui-textbox" readonly="readonly"  data-options="width:200,height:35">
        </div>


    </form>
</div>