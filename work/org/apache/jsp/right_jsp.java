/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.41
 * Generated at: 2013-08-28 01:11:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class right_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');

	int total_amount = (Integer)request.getAttribute("Size");
	ArrayList<Integer> clust0 = (ArrayList)request.getAttribute("clust0");
	ArrayList<Integer> clust1 = (ArrayList)request.getAttribute("clust1");
	ArrayList<Integer> clust2 = (ArrayList)request.getAttribute("clust2");
	ArrayList<Integer> clust3 = (ArrayList)request.getAttribute("clust3");
	System.out.println(clust0);

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<script type=\"text/javascript\" src=\"./BubbleTree/jslib/jquery-1.5.2.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"./BubbleTree/jslib/jquery.history.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"./BubbleTree/jslib/raphael.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"./BubbleTree/jslib/vis4.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"./BubbleTree/jslib/Tween.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"./BubbleTree/build/bubbletree.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"./BubbleTree/build/bubbletree.css\" />\n");
      out.write("<script type=\"text/javascript\" src=\"./BubbleTree/styles/cofog.js\"></script>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("        $(function() {\n");
      out.write("\n");
      out.write("\n");
      out.write("            var data = {\n");
      out.write("                label: 'Center',\n");
      out.write("                amount: ");
      out.print(total_amount );
      out.write(",\n");
      out.write("                children: [\n");
      out.write("                    { label: '1st', amount: ");
      out.print(clust0.size());
      out.write(", color: '#D95F02',\n");
      out.write("                        children: [\n");
      out.write("                        ");
for (int x=0;x<clust0.size();x++){ 
                        	if(x+1!=clust0.size()){
      out.write("\n");
      out.write("                        { label: '");
      out.print(clust0.get(x));
      out.write("', amount: 1,color:'#D95F02'},\n");
      out.write("                        ");
}else if(x+1==clust0.size()){
      out.write("\n");
      out.write("                        { label: '");
      out.print(clust0.get(x));
      out.write("', amount: 1,color:'#D95F02'}\n");
      out.write("                        ");
}}
      out.write("\n");
      out.write("                    ] },\n");
      out.write("                    { label: '2nd', amount: ");
      out.print(clust1.size());
      out.write(", color: '#dda0dd',\n");
      out.write("                        children: [\n");
      out.write("                        ");
for (int x=0;x<clust1.size();x++){ 
                        	if(x+1!=clust1.size()){
      out.write("\n");
      out.write("                        { label: '");
      out.print(clust1.get(x));
      out.write("', amount: 1,color:'#dda0dd'},\n");
      out.write("                        ");
}else if(x+1==clust1.size()){
      out.write("\n");
      out.write("                        { label: '");
      out.print(clust1.get(x));
      out.write("', amount: 1,color:'#dda0dd'}\n");
      out.write("                        ");
}}
      out.write("\n");
      out.write("                    ] },\n");
      out.write("                    { label: '3rd', amount: ");
      out.print(clust2.size());
      out.write(", color: '#0000ff',\n");
      out.write("                        children: [\n");
      out.write("                        ");
for (int x=0;x<clust2.size();x++){ 
                        	if(x+1!=clust2.size()){
      out.write("\n");
      out.write("                        { label: '");
      out.print(clust2.get(x));
      out.write("', amount: 1,color:'#0000ff'},\n");
      out.write("                        ");
}else if(x+1==clust2.size()){
      out.write("\n");
      out.write("                        { label: '");
      out.print(clust2.get(x));
      out.write("', amount: 1,color:'#0000ff'}\n");
      out.write("                        ");
}}
      out.write("\n");
      out.write("                    ] },\n");
      out.write("                    { label: '4th', amount: ");
      out.print(clust3.size());
      out.write(", color: '#00ff00',\n");
      out.write("                        children: [\n");
      out.write("                        ");
for (int x=0;x<clust3.size();x++){ 
                        	if(x+1!=clust3.size()){
      out.write("\n");
      out.write("                        { label: '");
      out.print(clust3.get(x));
      out.write("', amount: 1,color:'#00ff00'},\n");
      out.write("                        ");
}else if(x+1==clust1.size()){
      out.write("\n");
      out.write("                        { label: '");
      out.print(clust3.get(x));
      out.write("', amount: 1,color:'#00ff00'}\n");
      out.write("                        ");
}}
      out.write("\n");
      out.write("                    ]\n");
      out.write("                    }\n");
      out.write("                ]\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            new BubbleTree({\n");
      out.write("                data: data,\n");
      out.write("                bubbleType: 'icon',\n");
      out.write("                container: '.bubbletree'\n");
      out.write("            });\n");
      out.write("\n");
      out.write("        });\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div class=\"bubbletree-wrapper\">\n");
      out.write("\t\t<div class=\"bubbletree\"></div>\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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
