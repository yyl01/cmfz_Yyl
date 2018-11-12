<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>

<div style="text-align:center;">
<form method="post" class="easyui-form" id="save">
    <input name="id" type="easyui-textbox" value="${sessionScope.admin.id}" hidden="hidden">
    <div style="margin-top:30px;">
        原始密码：<input  name="oldpassword" class="easyui-textbox"  data-options="required:true,validType:'pwd'">
    </div>
    <div style="margin-top:20px;">
        输入新密码：<input  name="password" class="easyui-textbox" data-options="required:true,validType:'pwd'">
    </div>
    <div style="margin-top:20px;">
        确认密码：<input  name="cofirmpassword" class="easyui-textbox" data-options="required:true,validType:'cofirmPwd'">
    </div>
</form>
</div>