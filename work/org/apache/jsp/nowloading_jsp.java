/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.42
 * Generated at: 2013-09-25 14:16:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class nowloading_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	request.setCharacterEncoding("utf-8");

      out.write("\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<HTML>\n");
      out.write("<HEAD>\n");
      out.write("<div id=\"loaderImage\"></div>\n");
      out.write("<script type=\"text/javascript\" src=\"canvas.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\tvar cSpeed=9;\n");
      out.write("\tvar cWidth=128;\n");
      out.write("\tvar cHeight=128;\n");
      out.write("\tvar cTotalFrames=24;\n");
      out.write("\tvar cFrameWidth=128;\n");
      out.write("\tvar cImageSrc='images/sprites.gif';\n");
      out.write("\t\n");
      out.write("\tvar cImageTimeout=false;\n");
      out.write("\n");
      out.write("\t\n");
      out.write("\tfunction startAnimation(){\n");
      out.write("\t\t\n");
      out.write("\t\tdocument.getElementById('loaderImage').innerHTML='<canvas id=\"canvas\" width=\"'+cWidth+'\" height=\"'+cHeight+'\"><p>Your browser does not support the canvas element.</p></canvas>';\n");
      out.write("\t\t\n");
      out.write("\t\t//FPS = Math.round(100/(maxSpeed+2-speed));\n");
      out.write("\t\tFPS = Math.round(100/cSpeed);\n");
      out.write("\t\tSECONDS_BETWEEN_FRAMES = 1 / FPS;\n");
      out.write("\t\tg_GameObjectManager = null;\n");
      out.write("\t\tg_run=genImage;\n");
      out.write("\n");
      out.write("\t\tg_run.width=cTotalFrames*cFrameWidth;\n");
      out.write("\t\tgenImage.onload=function (){cImageTimeout=setTimeout(fun, 0)};\n");
      out.write("\t\tinitCanvas();\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\tfunction imageLoader(s, fun)//Pre-loads the sprites image\n");
      out.write("\t{\n");
      out.write("\t\tclearTimeout(cImageTimeout);\n");
      out.write("\t\tcImageTimeout=0;\n");
      out.write("\t\tgenImage = new Image();\n");
      out.write("\t\tgenImage.onload=function (){cImageTimeout=setTimeout(fun, 0)};\n");
      out.write("\t\tgenImage.onerror=new Function('alert(\\'Could not load the image\\')');\n");
      out.write("\t\tgenImage.src=s;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t//The following code starts the animation\n");
      out.write("\tnew imageLoader(cImageSrc, 'startAnimation()');\n");
      out.write("\t\n");
      out.write("\tfunction Search(){\n");
      out.write("\t\tparent.left.location.href=\"./left.jsp\";\n");
      out.write("\t\tdocument.Search.submit();\n");
      out.write("\t}\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body onLoad=\"Search()\">\n");
      out.write("<form name=\"Search\" action=\"MainServlet\" method=\"POST\" target=\"right\">\n");
      out.write("\t<input type=\"hidden\" name=Keyword value=");
      out.print(request.getParameter("keyword") );
      out.write(">\n");
      out.write("</form>\n");
      out.write("</body>\n");
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
