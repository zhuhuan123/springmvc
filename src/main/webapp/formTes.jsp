<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>form 表单</title>     
<!--     <link href="../../lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="../../lib/ligerUI/skins/Gray2014/css/all.css" rel="stylesheet" />
    <script src="../../lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
    <script src="../../lib/ligerUI/js/ligerui.all.js"></script>
        <script src="../../lib/ligerUI/js/plugins/ligerForm.js"></script>
    <script src="../../lib/ligerUI/js/plugins/ligerComboBox.js"></script>
    <script src="../../lib/ligerUI/js/plugins/ligerCheckBoxList.js"></script>
    <script src="../../lib/ligerUI/js/plugins/ligerRadioList.js"></script>
    <script src="../../lib/ligerUI/js/plugins/ligerListBox.js"></script> -->
 <link href="js/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" /> 
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script src="js/lib/ligerUI/js/ligerui.all.js" type="text/javascript"></script>  
<script src="js/lib/jquery.cookie.js"></script>
<script src="js/lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
<script src="js/lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
<script src="js/lib/ligerUI/js/plugins/ligerRadioList.js" type="text/javascript"></script>
<script src="js/lib/ligerUI/js/plugins/ligerForm.js" type="text/javascript"></script>
<script src="js/lib/json2.js"></script>

    <script type="text/javascript">
        $(function ()
        {
            $("#form1").ligerForm();
        });
 
    </script>
    <style type="text/css">
            body
            {
                padding-left:10px;
                font-size:13px;
            }
            h1
            {
                font-size:20px;
                font-family:Verdana;
            }
            h4
            {
                font-size:16px;
                margin-top:25px;
                margin-bottom:10px;
            }
            .description
            {
                padding-bottom:30px;
                font-family:Verdana;
            }
            .description h3
            {
                color:#CC0000;
                font-size:16px;
                margin:0 30px 10px 0px;
                padding:45px 0 8px; 
                border-bottom:solid 1px #888;
            }
        td {
            padding: 5px;
        }
    </style>

</head>

<body style="padding:10px">
 
     <h1>表单演示</h1>      
       

    <div id="form1" >
        <input type="hidden" value="hvv" name="hv" />
        <table>
            
            <tr>
                <td>
                    <label for="textbox1">TextBox：</label>
                </td>
                <td>
                    <input id="textbox1"  name="username" type="text" class="ui-textbox"  />
                </td>
            </tr>
            <tr>
                <td>
                    <label for="pwd1">Password：</label>
                </td>
                <td>
                    <input id="pwd1" name="pwd" type="password" class="ui-password" />
                </td>
            </tr>
            <tr>
                <td>
                    <label for="textarea1">TextArea：</label>
                </td>
                <td>
                    <textarea id="textarea1" name="area" class="ui-textarea"  ></textarea>
                </td>
            </tr>
            <tr>
                <td>                   
                    <label for="date1">DatePicker：</label>
                </td>
                <td>
                    <input id="date1" name="birthDay" type="text"  class="ui-datepicker" value="2010-10-12"  />
                </td>
            </tr>
            <tr>
                <td>
                    Spinner：
                </td>
                <td>
                    <input name="age" type="text" class="ui-spinner" value="22"   />
                </td>
            </tr>
            <tr>
                <td>
                    CheckBox：
                </td>
                <td>
                    <input name="married" class="ui-checkbox" type="text"  text="婚否" value="Y"  />
                </td>
            </tr>
             <tr>
                <td>
                    ComboBox(select)：
                </td>
                <td>
                  <select name="depart" validate="{required:true}">
	                <option value="1" selected="selected">主席</option>
	                <option value="2">研发中心</option>
	                <option value="3">销售部</option>
	                <option value="4">市场部</option>
	                <option value="5">顾问组</option>
                </select>
                </td>
            </tr>

            <tr>
                <td>
                    ComboBox：
                </td>
                <td>
                    <input name="country1" type="hidden" class="ui-combobox" data-value="de" data-ajaxType="get" data-url="data/countrys.txt"  data-textField="text" data-valueField="id" /> 
                </td>
            </tr>
              <tr>
                <td>
                    ComboBox(多选)：
                </td>
                <td>
                    <input name="country1_mul" type="hidden" class="ui-combobox" data-isMultiSelect="true" data-value="de" data-ajaxType="get" data-url="data/countrys.txt"  data-textField="text" data-valueField="id" /> 
                </td>
            </tr>
            <tr>
                <td>
                    CheckBoxList：
                </td>
                <td>
                    <input name="country2" type="hidden" class="ui-checkboxlist" data-value="cn" data-ajaxType="get" data-url="data/countrys.txt"  data-textField="text" data-valueField="id" /> 
                </td>
            </tr>
            <tr>
                <td>
                    RadioButtonList：
                </td>
                <td>
                    <input name="country3" type="hidden" class="ui-radiolist" data-value="fr" data-ajaxType="get" data-url="data/countrys.txt"  data-textField="text" data-valueField="id" /> 
                </td>
            </tr>
            <tr>
                <td>
                    ListBox：
                </td>
                <td>
                    <input name="country4" type="hidden" class="ui-listbox" data-value="cn" data-ajaxType="get" data-url="data/countrys.txt"  data-textField="text" data-valueField="id" /> 
                </td>
            </tr>
             <tr>
                <td>
                    ListBox(多选)：
                </td>
                <td>
                    <input name="country4_mul" type="hidden" class="ui-listbox" data-isMultiSelect="true"  data-value="cn" data-ajaxType="get" data-url="data/countrys.txt"  data-textField="text" data-valueField="id" /> 
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td> 
                    <input value="setData" type="button" onclick="setData()" />
                    <input value="getData" type="button" onclick="getData()" />
                    <input value="jquery获取数据" type="button" onclick="submitForm()" />
                </td>
            </tr>
        </table>
    </div>
    </form>
 <script type="text/javascript">
   
     function getData()
     {
         var form = new liger.get("form1");
         var data = form.getData();
         alert(JSON.stringify(data));
     }
     function setData()
     {
         var obj = {
             hv : "隐藏数据",
             username: "abc",
             pwd: "1234",
             area : "广东",
             birthDay: "2050-11-12",
             age : 45,
             married: true,
             depart : "2",
             country1: "en",
             country1_mul: "en;cn",
             country2: "en",
             country3: "en",
             country4: "en",
             country4_mul: "en;cn",
         };
         var form = new liger.get("form1");
         form.setData(obj);
     }
      
     function submitForm()
     {
         var data = {};
         $("input,select,textarea").each(function ()
         {
             var name = $(this).attr("name");
             if (name && name.indexOf('ligerui') == -1)
             {
                 data[name] = this.value;
             }
         });
         alert(JSON.stringify(data));
     }
 
    </script>
    
    

</body>
</html>