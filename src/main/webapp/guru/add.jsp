<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>

<div style="text-align:center;">
<form method="post" class="easyui-form" id="save2" ENCTYPE="multipart/form-data">
    <div style="margin-top:30px;">
        法名：<input  name="name" class="easyui-textbox" data-options="required:true,width:200,height:35">
    </div>
    <div style="margin-top:20px;margin-left: 5px">
        头像：<input  name="aa" class="easyui-filebox" data-options="width:200,height:35">
    </div>
    <div style="margin-top:20px;">
    性别： <select class="easyui-combobox" data-options="width:200,height:35" name="sex">
    <option value="m">男</option>
    <option value="f">女</option>
     </select>
        <div style="margin-top:20px;margin-right: 10px;">
            状态： <select class="easyui-combobox" data-options="width:200,height:35" name="status">
            <option value="m">正常</option>
            <option value="f">冻结</option>
        </select>
    </div>

    </div>
</form>
</div>