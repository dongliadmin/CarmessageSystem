/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-03-20 01:40:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("<title>洗车管理系统</title>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("/assets/css/dpl-min.css\" rel=\"stylesheet\"\n");
      out.write("\ttype=\"text/css\" />\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("/assets/css/bui-min.css\" rel=\"stylesheet\"\n");
      out.write("\ttype=\"text/css\" />\n");
      out.write("<link href=\"");
      out.print(basePath);
      out.write("/assets/css/main-min.css\" rel=\"stylesheet\"\n");
      out.write("\ttype=\"text/css\" />\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div class=\"header\">\n");
      out.write("\t\t<div class=\"dl-title\"></div>\n");
      out.write("\t\t<div class=\"dl-log\">\n");
      out.write("\t\t\t欢迎您，<span class=\"dl-log-user\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${username }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span> <a\n");
      out.write("\t\t\t\thref=\"");
      out.print(basePath);
      out.write("usercontrol/exitlogin.spring\" title=\"退出系统\"\n");
      out.write("\t\t\t\tclass=\"dl-log-quit\">[退出]</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"content\">\n");
      out.write("\t\t<div class=\"dl-main-nav\">\n");
      out.write("\t\t\t<div class=\"dl-inform\">\n");
      out.write("\t\t\t\t<div class=\"dl-inform-title\"></div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<ul id=\"J_Nav\" class=\"nav-list ks-clear\">\n");
      out.write("\t\t\t\t<li class=\"nav-item dl-selected\">\n");
      out.write("\t\t\t\t\t<div class=\"nav-item-inner nav-home\">车主管理</div>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t\t<li class=\"nav-item dl-selected\">\n");
      out.write("\t\t\t\t\t<div class=\"nav-item-inner nav-order\">用户管理</div>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t\t<li class=\"nav-item dl-selected\">\n");
      out.write("\t\t\t\t\t<div class=\"nav-item-inner nav-order\">权限管理</div>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t\t<li class=\"nav-item dl-selected\">\n");
      out.write("\t\t\t\t\t<div class=\"nav-item-inner nav-order\">员工管理</div>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<ul id=\"J_NavContent\" class=\"dl-tab-conten\">\n");
      out.write("\t\t</ul>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<script type=\"text/javascript\"\n");
      out.write("\t\tsrc=\"");
      out.print(basePath);
      out.write("/assets/js/jquery-1.8.1.min.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("/assets/js/bui-min.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\"\n");
      out.write("\t\tsrc=\"");
      out.print(basePath);
      out.write("/assets/js/common/main-min.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\"\n");
      out.write("\t\tsrc=\"");
      out.print(basePath);
      out.write("/assets/js/config-min.js\"></script>\n");
      out.write("\t<script>\n");
      out.write("\t\tBUI.use('common/main', function() {\n");
      out.write("\t\t\tvar config = [ {\n");
      out.write("\t\t\t\tid : '1',\n");
      out.write("\t\t\t\thomePage : '2',\n");
      out.write("\t\t\t\tmenu : [ {\n");
      out.write("\t\t\t\t\ttext : '车主管理',\n");
      out.write("\t\t\t\t\titems : [ {\n");
      out.write("\t\t\t\t\t\tid : '2',\n");
      out.write("\t\t\t\t\t\ttext : '所有车主',\n");
      out.write("\t\t\t\t\t\thref : '");
      out.print(basePath);
      out.write("/carcontrol/showcar.spring'\n");
      out.write("\t\t\t\t\t}, {\n");
      out.write("\t\t\t\t\t\tid : '3',\n");
      out.write("\t\t\t\t\t\ttext : '查找车主',\n");
      out.write("\t\t\t\t\t\thref : '");
      out.print(basePath);
      out.write("./selectshowcar.jsp'\n");
      out.write("\t\t\t\t\t}, {\n");
      out.write("\t\t\t\t\t\tid : '4',\n");
      out.write("\t\t\t\t\t\ttext : '添加车主',\n");
      out.write("\t\t\t\t\t\thref : '");
      out.print(basePath);
      out.write("/carcontrol/main.spring'\n");
      out.write("\t\t\t\t\t} ]\n");
      out.write("\t\t\t\t} ]\n");
      out.write("\t\t\t},{\n");
      out.write("\t\t\t\tid : '7',\n");
      out.write("\t\t\t\thomePage : '9',\n");
      out.write("\t\t\t\tmenu : [ {\n");
      out.write("\t\t\t\t\ttext : '用户管理',\n");
      out.write("\t\t\t\t\titems : [ {\n");
      out.write("\t\t\t\t\t\tid : '9',\n");
      out.write("\t\t\t\t\t\ttext : '所有用户',\n");
      out.write("\t\t\t\t\t\thref : '");
      out.print(basePath);
      out.write("/usercontrol/showuser.spring'\n");
      out.write("\t\t\t\t\t}, {\n");
      out.write("\t\t\t\t\t\tid : '',\n");
      out.write("\t\t\t\t\t\ttext : '添加用户',\n");
      out.write("\t\t\t\t\t\thref : '");
      out.print(basePath);
      out.write("/rolesControl/showallRolesname.spring'\n");
      out.write("\t\t\t\t\t} ]\n");
      out.write("\t\t\t\t} ]\n");
      out.write("\t\t\t}, {\n");
      out.write("\t\t\t\tid : '8',\n");
      out.write("\t\t\t\t homePage : '13', \n");
      out.write("\t\t\t\tmenu : [ {\n");
      out.write("\t\t\t\t\ttext : '权限管理',\n");
      out.write("\t\t\t\t\titems : [ {\n");
      out.write("\t\t\t\t\t\tid : '13',\n");
      out.write("\t\t\t\t\t\ttext : '角色管理',\n");
      out.write("\t\t\t\t\t\thref : '");
      out.print(basePath);
      out.write("/rolesControl/showallRoles.spring'\n");
      out.write("\t\t\t\t\t}, {\n");
      out.write("\t\t\t\t\t\tid : '14',\n");
      out.write("\t\t\t\t\t\ttext : '模块管理',\n");
      out.write("\t\t\t\t\t\thref : '");
      out.print(basePath);
      out.write("/modulescontrol/showallModules.spring'\n");
      out.write("\t\t\t\t\t},{\n");
      out.write("\t\t\t\t\t\tid : '14',\n");
      out.write("\t\t\t\t\t\ttext : '添加用户',\n");
      out.write("\t\t\t\t\t\thref : '");
      out.print(basePath);
      out.write("/rolesControl/showallRolesname.spring'\n");
      out.write("\t\t\t\t\t} ]\n");
      out.write("\t\t\t\t} ]\n");
      out.write("\t\t\t}, {\n");
      out.write("\t\t\t\tid : '9',\n");
      out.write("\t\t\t\t homePage : '14', \n");
      out.write("\t\t\t\tmenu : [ {\n");
      out.write("\t\t\t\t\ttext : '员工管理',\n");
      out.write("\t\t\t\t\titems : [ {\n");
      out.write("\t\t\t\t\t\tid : '14',\n");
      out.write("\t\t\t\t\t\ttext : '所有员工',\n");
      out.write("\t\t\t\t\t\thref : '");
      out.print(basePath);
      out.write("/employeesControl/main.spring'\n");
      out.write("\t\t\t\t\t},{\n");
      out.write("\t\t\t\t\t\tid : '15',\n");
      out.write("\t\t\t\t\t\ttext : '添加员工',\n");
      out.write("\t\t\t\t\t\thref : '");
      out.print(basePath);
      out.write("/addEmployees.jsp'\n");
      out.write("\t\t\t\t\t} ]\n");
      out.write("\t\t\t\t\t} ]\n");
      out.write("\t\t\t} ];\n");
      out.write("\t\t\t\tnew PageUtil.MainPage({\n");
      out.write("\t\t\t\tmodulesConfig : config\n");
      out.write("\t\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t\t});\n");
      out.write("\t</script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}