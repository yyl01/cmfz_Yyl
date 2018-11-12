<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $("#showall").form('load','/cmfz_Yyl/album/findOne?id=${param.id}');
</script>
<div style="text-align:center;">
    <form method="post" class="easyui-form" id="showall" >
        <div style="margin-top:20px;margin-right:10px;">
            coverImg：<img  src="/cmfz_Yyl/images/${param.coverImg}" style="width:50px;height:50px;">
        </div>
        <div style="margin-top:30px;margin-left: 25px;">
            id：<input  name="id" class="easyui-textbox" readonly="readonly" data-options="width:200,height:35">
        </div>
        <div style="margin-top:30px;margin-left:15px;">
            title：<input  name="title" class="easyui-textbox" readonly="readonly" data-options="width:200,height:35">
        </div>

        <div style="margin-top:20px;margin-right:10px;">
            count：<input  name="count" class="easyui-textbox" readonly="readonly"  data-options="width:200,height:35">
        </div>
        <div style="margin-top:20px;margin-right:10px;">
            pdDate：<input  name="pdDate" class="easyui-textbox" readonly="readonly"  data-options="width:200,height:35">
        </div>
        <div style="margin-top:20px;margin-right:10px;">
            star：<input  name="star" class="easyui-textbox" readonly="readonly"  data-options="width:200,height:35">
        </div>
        <div style="margin-top:20px;margin-right:10px;">
            author：<input  name="author" class="easyui-textbox" readonly="readonly"  data-options="width:200,height:35">
        </div>
        <div style="margin-top:20px;margin-right:10px;">
            broadCast：<input  name="broadCast" class="easyui-textbox" readonly="readonly"  data-options="width:200,height:35">
        </div>
        <div style="margin-top:20px;margin-right:10px;">
            brief：<input  name="brief" class="easyui-textbox" readonly="readonly"  data-options="width:200,height:35">
        </div>


    </form>
</div>