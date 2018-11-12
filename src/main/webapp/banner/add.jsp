<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>

<div style="text-align:center;">
<form method="post" class="easyui-form" id="save1" ENCTYPE="multipart/form-data">
    <div style="margin-top:30px;margin-left: 15px">
        title：<input  name="title" class="easyui-textbox" data-options="required:true,width:200,height:35">
    </div>
    <div style="margin-top:20px;margin-right: 10px">
        imgPath：<input  name="aa" class="easyui-filebox" data-options="width:200,height:35">
    </div>
    <div style="margin-top:20px;">
        status： <select class="easyui-combobox" data-options="width:200,height:35" name="status">
        <option value="m">显示</option>
        <option value="f">不显示</option>
    </select>
    <div style="margin-top:20px;">
        date：<input  name="date" class="easyui-datebox" data-options="width:200,height:35">
    </div>
    </div>
</form>
</div>