/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.99
 * Generated at: 2020-02-20 20:18:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import torverbook.web.constants.RequestAttributes;
import torverbook.web.ad.Ad;
import java.util.List;

public final class favourite_002dlist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
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

      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"Java\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("<!-- Charset & Responsiveness Metadata -->\n");
      out.write("<meta charset=\"utf-8\" />\n");
      out.write("<meta name=\"viewport\"\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\n");
      out.write("<!-- StyleSheets -->\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/common.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/favourite-list.css\" />\n");
      out.write("\n");
      out.write("<!-- Bootstrap CSS CDN -->\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("<!-- Google Fonts API CDN -->\n");
      out.write("<link\n");
      out.write("\thref=\"https://fonts.googleapis.com/css?family=Montserrat:300,400,700,900&display=swap\"\n");
      out.write("\trel=\"stylesheet\">\n");
      out.write("<link\n");
      out.write("\thref=\"https://fonts.googleapis.com/css?family=Comfortaa:300,400,700&display=swap\"\n");
      out.write("\trel=\"stylesheet\">\n");
      out.write("\n");
      out.write("<title>TorverBook - Favourites</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t<header>\n");
      out.write("\t\t<h1 id=\"header-title\">TorverBook</h1>\n");
      out.write("\t</header>\n");
      out.write("\t<div id=\"content-container\">\n");
      out.write("\t\t<div class=\"row main-panels-container\">\n");
      out.write("\t\t\t<panel class=\"left-panel col-lg-3\"> <a\n");
      out.write("\t\t\t\thref=\"/dashboard\">\n");
      out.write("\t\t\t\t<button id=\"home-btn\">\n");
      out.write("\t\t\t\t\t<em class=\"fa fa-home\" /></em> Home\n");
      out.write("\t\t\t\t</button>\n");
      out.write("\t\t\t</a> <a href=\"/settings\">\n");
      out.write("\t\t\t\t<button id=\"settings-btn\">\n");
      out.write("\t\t\t\t\t<em class=\"fa fa-gear\" /></em> Settings\n");
      out.write("\t\t\t\t</button>\n");
      out.write("\t\t\t</a> <a href=\"/add-ad\">\n");
      out.write("\t\t\t\t<button id=\"add-ad-btn\">\n");
      out.write("\t\t\t\t\t<em class=\"fa fa-plus\" /></em> Add Ad\n");
      out.write("\t\t\t\t</button>\n");
      out.write("\t\t\t</a> <a href=\"/personal-ads\">\n");
      out.write("\t\t\t\t<button id=\"my-ads-btn\">\n");
      out.write("\t\t\t\t\t<em class=\"fa fa-bookmark\" /></em> My Ads\n");
      out.write("\t\t\t\t</button>\n");
      out.write("\t\t\t</a> <a href=\"/personal-reviews\">\n");
      out.write("\t\t\t\t<button id=\"my-reviews-btn\">\n");
      out.write("\t\t\t\t\t<em class=\"fa fa-th-list\" /></em> My Reviews\n");
      out.write("\t\t\t\t</button>\n");
      out.write("\t\t\t</a> <a href=\"/favourite\">\n");
      out.write("\t\t\t\t<button class=\"active\" id=\"favourites-btn\">\n");
      out.write("\t\t\t\t\t<em class=\"fa fa-star\" /></em> Favourite List\n");
      out.write("\t\t\t\t</button>\n");
      out.write("\t\t\t</a> <a href=\"/logout\">\n");
      out.write("\t\t\t\t<button id=\"logout-btn\">\n");
      out.write("\t\t\t\t\t<em class=\"fa fa-sign-out-alt\" /></em> Logout\n");
      out.write("\t\t\t\t</button>\n");
      out.write("\t\t\t</a> </panel>\n");
      out.write("\t\t\t<panel class=\"central-panel col-lg-6\">\n");
      out.write("\t\t\t<div class=\"ads-container\">\n");
      out.write("\t\t\t\t");

					Object listObj = request.getAttribute(RequestAttributes.ADS_LIST_ATTRIBUTE_NAME);
					List<Ad> list = new ArrayList<Ad>();
					if (listObj != null) {
						list = (List<Ad>) listObj;
					}
					for (int i = 0; i < list.size(); i++) {
						Ad ad = list.get(i);
				
      out.write("\n");
      out.write("\t\t\t\t<ad class=\"ad-container\">\n");
      out.write("\t\t\t\t<div class=\"title\">");
      out.print(ad.getTitle());
      out.write("</div>\n");
      out.write("\t\t\t\t<div class=\"info-container\">\n");
      out.write("\t\t\t\t\t<span class=\"price\">\n");
      out.write("\t\t\t\t\t<em\n");
      out.write("\t\t\t\t\t\tclass=\"price-icon fa fa-money-check-alt\"></em> ");
      out.print(ad.getPrice());
      out.write("</span>\n");
      out.write("\t\t\t\t\t<span class=\"quantity\">(");
      out.print(ad.getQuantity());
      out.write(" left)\n");
      out.write("\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"description\">");
      out.print(ad.getDescription());
      out.write("</div>\n");
      out.write("\t\t\t\t<h6>\n");
      out.write("\t\t\t\t\t<em class=\"fa fa-book\"></em>\n");
      out.write("\t\t\t\t\t");
      out.print(ad.getCategory());
      out.write("</h6>\n");
      out.write("\t\t\t\t</ad>\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t</panel>\n");
      out.write("\n");
      out.write("\t\t\t<panel class=\"right-panel col-lg-3\">\n");
      out.write("\t\t\t<div class=\"no-messages-container\">\n");
      out.write("\t\t\t\t<em class=\"fa fa-envelope-open fa-5x\"></em>\n");
      out.write("\t\t\t\t<h1>No messages yet..</h1>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t</panel>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Bootstrap JS CDN -->\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\"></script>\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"></script>\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("<!-- FontAwesome JS CDN -->\n");
      out.write("<script src=\"https://kit.fontawesome.com/8526e38f8c.js\"></script>\n");
      out.write("\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
