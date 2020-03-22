# Spring boot 整合thymeleaf模板引擎
#### 遇到问题
# 一、 IDEA thymeleaf ${xxx.xxx}表达式报错，红色波浪线
1. alt + enter  导入包 <!--/*@thymesVar id="user" type="com.suancai.thymeleaf.pojo.User"*/-->
2. setting > inspections >  thyemeleaf 中将校验过滤掉（不治本）
3. <!--suppress ALL--> 添加注释

# 二、引入static js 文件失败
1. 必须有thymeleaf依赖包
2. 添加 spring.mvc.static-path-pattern=/static/**
3. 引用方式一:  <script th:src="@{/static/scripts/jquery-3.2.1.js}"></script>
4. 这种方式要创建拦截器否则无效<script type="text/javascript" src="../static/js/jquery/jquery/jquery-3.2.1.js"></script>
<link rel="stylesheet" type="text/css" th:href="@{css/ws.css}"/>
 
# 三. 表单如何提交文件
使用form表单可以直接指定 提交前验证 onsubmit action type
如果用ajax提交表单请求则要 onsubmit return false; action = "##"
<code>
#### 将表单序列化成json
(function($){
        $.fn.serializeJson=function(){
            var serializeObj={};
            var array=this.serializeArray();
            var str=this.serialize();
            $(array).each(function(){
                if(serializeObj[this.name]){
                    if($.isArray(serializeObj[this.name])){
                        serializeObj[this.name].push(this.value);
                    }else{
                        serializeObj[this.name]=[serializeObj[this.name],this.value];
                    }
                }else{
                    serializeObj[this.name]=this.value;
                }
            });
            return serializeObj;
        };
    })(jQuery);
    </code>
# 四、 表单提交处理验证处理方式
<code>
<form id="form" onsubmit="return false;" action="##">
    <p><input type="text" name="userName" placeholder="用户名"></p>
    <p><input type="password" name="password" placeholder="密码"></p>
<p><input type="submit" value="提交" id="submit"><input type="reset" value="重置"></p>
</form>

 $('#submit').click(function() {
        var serialize = $("#form").serialize();
        console.log(serialize);
        $.ajax({
                type: 'POST',
                url: '/login',
                data:$("#form").serialize(),
                success:function (data) {
                    debugger;
                    console.log(data);
                    window.location.href = '/index';
                },
                error:function (data) {
                    console.log(data);
                }
            }
        )
    });
</code>    
    
    