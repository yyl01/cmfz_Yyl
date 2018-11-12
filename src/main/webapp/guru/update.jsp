<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $("#upd1").form('load','/cmfz_Yyl/guru/findOne?id=${param.id}');
</script>
<div style="text-align:center;">
    <form method="post" class="easyui-form" id="upd1" >
        <div style="margin-top:30px;margin-left: 25px;">
            id：<input  name="id" class="easyui-textbox" readonly="readonly" data-options="required:true,width:200,height:35">
        </div>
        <div style="margin-top:30px;margin-left:15px;">
            title：<input  name="name" class="easyui-textbox" readonly="readonly" data-options="required:true,width:200,height:35">
        </div>
        <div style="margin-top:20px;margin-right:10px;">
            imgPath：<input  name="headPic" class="easyui-textbox" readonly="readonly"  data-options="width:200,height:35">
        </div>
        <div style="margin-top:20px;margin-left:10px;">
            性别：<input  name="sex" class="easyui-textbox" readonly="readonly"  data-options="width:200,height:35">
        </div>
        <div style="margin-top:20px;">
            状态： <select class="easyui-combobox" data-options="width:200,height:35" name="status">
            <option value="m">正常</option>
            <option value="f">冻结</option>
        </select>
        </div>

    </form>
</div>