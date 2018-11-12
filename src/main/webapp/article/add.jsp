<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>

<div style="text-align:center;">
<form method="post" class="easyui-form" id="save3" ENCTYPE="multipart/form-data">
    <div style="margin-top:30px;">
        title：<input  name="title" class="easyui-textbox" data-options="required:true,width:200,height:35">
    </div>
    <div style="margin-top:20px;margin-right: 10px">
    imgPath：<input  name="aa" class="easyui-filebox" data-options="width:200,height:35">
</div>
    <div style="margin-top:20px;margin-right: 10px">
        content：<input  name="content" class="easyui-textbox" data-options="required:true,width:200,height:35">
    </div>
    <div style="margin-top:20px;margin-right: 10px">
       pdDate：<input  name="pdDate" class="easyui-datebox" data-options="width:200,height:35">
    </div>
    <div style="margin-top:20px;margin-right: 10px">
        上师：<input  name="guru.id"  class="easyui-combobox" data-options="valueField:'id',textField:'name',width:200,height:35,url:'/cmfz_Yyl/guru/show'">
    </div>



</form>
</div>