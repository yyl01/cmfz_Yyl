<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $("#upd").form('load','/cmfz_Yyl/banner/findOne?id=${param.id}');
</script>
<div style="text-align:center;">
    <form method="post" class="easyui-form" id="upd" >
        <div style="margin-top:30px;margin-left: 25px;">
            id：<input  name="id" class="easyui-textbox" readonly="readonly" data-options="width:200,height:35">
        </div>
        <div style="margin-top:30px;margin-left:15px;">
            title：<input  name="title" class="easyui-textbox" readonly="readonly" data-options="width:200,height:35">
        </div>
        <div style="margin-top:20px;margin-right:10px;">
            imgPath：<input  name="imgPath" class="easyui-textbox" readonly="readonly"  data-options="width:200,height:35">
        </div>
        <div style="margin-top:20px;">
            status： <select class="easyui-combobox" data-options="width:200,height:35" name="status">
            <option value="m">显示</option>
            <option value="f">不显示</option>
        </select>
        </div>
        <div style="margin-top:20px;margin-left: 10px;">
            date：<input  name="date" class="easyui-datebox" data-options="width:200,height:35">
        </div>
    </form>
</div>