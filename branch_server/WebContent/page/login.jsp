<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
       <script type="text/javascript">
        
        </script>
</head>

   <body>
    <form action="login_Login_login.do" method="post" id="loginform" >
                <div>
                 账号   <input   type="text" name="account" id="account" />
                </div>
                <div>
               密码      <input  type="password" name="password" type="password" />
                </div>
                <div>
           <button type="submit" value="Submit">Submit</button>
                </div>
               <div>
                  <%
				if(session.getAttribute("message")!=null&&!"".equals(session.getAttribute("message"))){
					%>
					<%=session.getAttribute("message") %>
					<%
					session.removeAttribute("message");
				}
				%>
               </div>
      </form>
</body>
</html>