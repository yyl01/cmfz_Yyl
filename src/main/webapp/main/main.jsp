<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../c_js/form.validator.rules.js"></script>
    <script type="text/javascript" src="../c_js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="../c_js/jquery.etree.js"></script>
    <script type="text/javascript" src="../c_js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="../c_js/common.js"></script>
    <script type="text/javascript" src="../c_js/datagrid-groupview.js"></script>

<script type="text/javascript">
          $(function () {
              if(${sessionScope.admin==null}){
                  location.href='/cmfz_Yyl/login.jsp';
              }

                $.post("/cmfz_Yyl/menu/showAll", function (menu) {

                    $.each(menu, function (index, m) {
                        var content = "<div style='text-align:center'>";
                        $.each(m.menus, function (idx, child) {
                            content += "<a  onclick=\"addtabs('" + child.title + "','" + child.iconCls + "','" + child.href + "')\"  style='width:90%;margin:10px 0px;border:2px solid #00bbee;' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'" + child.iconCls + "'\">" + child.title + "</a><br/>"
                        });
                        content += "</div>"

                        $("#aa").accordion('add', {

                            title: m.title,
                            iconCls: m.iconCls,
                            content: content,

                        });
                    });
                });

            });
            function addtabs(title, iconCls, href) {
                if (!$("#tabs").tabs('exists', title)) {
                    $("#tabs").tabs('add', {
                        title: title,
                        iconCls: iconCls,
                        closable: true,
                        fit: true,
                        href: "/cmfz_Yyl" + href,
                    });
                } else {
                    $("#tabs").tabs('select', title);
                }
            }
            function update(){
                $("#updadm").dialog({
                    width:400,
                    heigth:300,
                    buttons:[{
                        iconCls:'icon-edit',
                        text:'修改',
                        handler: function () {
                            $("#save").form('submit', {
                                url: '/cmfz_Yyl/admin/change',
                                success: function (result) {
                                    var resultobj=$.parseJSON(result);
                                    if(resultobj.success){
                                        $.messager.show({title:'提示',msg:'密码修改成功！！！'});
                                    }else{
                                        $.messager.show({title:'提示',msg:'密码修改失败！！！'});
                                    }
                                    $("#updadm").dialog('close');

                                }

                            });


                        }

                        
                    }]
                });

            }
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.admin.name} &nbsp;<a href="javascript:;" class="easyui-linkbutton" onclick="update()" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="/cmfz_Yyl/admin/exit" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">
    		
		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tabs" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>

		</div>  
    </div>
<div id="updadm" data-options="width:400,height:300,href:'/cmfz_Yyl/main/update.jsp',title:'修改密码'"></div>
</body> 
</html>