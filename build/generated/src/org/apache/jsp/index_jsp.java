package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css\" rel=\"stylesheet\" />\n");
      out.write("    \n");
      out.write("   <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Validate Words Application</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"jumbotron\">\n");
      out.write("                <h2 align=\"center\"><b>~<u> Words Validation Application </u>~</b></h2>\n");
      out.write("            <br>\n");
      out.write("               ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" \n");
      out.write("            <form name=\"f1\" action=\"Javafile\" method=\"get\" class=\"form-horizontol\">\n");
      out.write("                <table align=\"center\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td><input name=\"ip1\" id=\"input1\" type=\"text\" placeholder=\"Search a word\" class=\"form-control\" sautofocus=\"\"></td>\n");
      out.write("                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                        <td><input type=\"submit\" name=\"b1\" value=\"Search\" id=\"submit\" class=\"btn btn-info \"></td>\n");
      out.write("                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                        \n");
      out.write("                    </tr>\n");
      out.write("                        \n");
      out.write("                    <tr>\n");
      out.write("                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><select class=\"suggested1 js-example-basic-single form-control\" id=\"sug1\"  align=\"left\"><option></option></select></td>\n");
      out.write("                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                        <td><select class=\"suggested2 js-example-basic-single form-control\" id=\"sug2\" align=\"left\" style=\"width:120%\"><option></option></select></td>\n");
      out.write("                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                        <td></td>\n");
      out.write("                    </tr>\n");
      out.write("                    </tr>\n");
      out.write("                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                    <tr> \n");
      out.write("                    <tr>\n");
      out.write("                        <td><input type=\"text\" class=\"form-control\" size=\"7\" align=\"center\"  list=\"matchedWords\" id=\"words\"><datalist id=\"matchedWords\"></datalist></td>\n");
      out.write("                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                        <td><span id=\"moreWords\" style=\"color:red\"> </span></td>\n");
      out.write("                        <td><input type=\"text\" class=\"form-control\" align=\"center\" id=\"words2\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("                              \n");
      out.write("            </form>\n");
      out.write("            </div>\n");
      out.write("        </div>    \n");
      out.write("    </body>\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js\"></script>\t\n");
      out.write("    <script>\n");
      out.write("        //alert(\"hii\");\n");
      out.write("        $(document).ready(function(){\n");
      out.write("            var count=0;\n");
      out.write("            var listWords='';\n");
      out.write("            $(\"#words\").keyup(function (){\n");
      out.write("                var inputStr=document.getElementById(\"words\").value;\n");
      out.write("               // console.log(inputStr);\n");
      out.write("                \n");
      out.write("                if(inputStr.length>0)\n");
      out.write("                {\n");
      out.write("                    var xmlhttp=new XMLHttpRequest();\n");
      out.write("                    xmlhttp.onreadystatechange= functionSuggestion;\n");
      out.write("                    xmlhttp.open(\"GET\",\"Javafile?inputStr=\"+inputStr,false);\n");
      out.write("                    xmlhttp.send();\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            function functionSuggestion()\n");
      out.write("            {\n");
      out.write("\n");
      out.write("                //console.log(this.status+\":::I m here  \"+this.readyState);       \n");
      out.write("                if(this.readyState==4 /*Complete*/ && this.status==200/*OK Response*/ )\n");
      out.write("                {\n");
      out.write("                    \n");
      out.write("                        var hintWords=this.responseText;\n");
      out.write("                        var wordsObj=JSON.parse(hintWords);\n");
      out.write("                    \n");
      out.write("                    console.log(wordsObj);\n");
      out.write("                    \n");
      out.write("                    //count=0;\n");
      out.write("                    var temp=count;\n");
      out.write("                    var set2=wordsObj.matchedWords.slice(0,10);\n");
      out.write("                    set2=[\"adsfas\",\"asdf\",\"dfd\"];\n");
      out.write("                    while(count<temp+11 && count<wordsObj.matchedWords.length)\n");
      out.write("                    {\n");
      out.write("                        listWords+='<option value=\"'+wordsObj.matchedWords[count]+'\">';\n");
      out.write("                        count++;\n");
      out.write("                    }\n");
      out.write("                    console.log(\"set2 \"+set2);\n");
      out.write("                    $(\"#words2\").select2({\n");
      out.write("                        placeholder:\"Matched Words\",\n");
      out.write("                        allowClear: true,  \n");
      out.write("                        multiple:true\n");
      out.write("                        //data:set2\n");
      out.write("                    });\n");
      out.write("                    if(count<wordsObj.matchedWords.length)\n");
      out.write("                    {\n");
      out.write("                        //document.getElementById('moreWords').innerHTML= \"+\"+(wordsObj.matchedWords.length-count)\n");
      out.write("                        listWords+='<option value=\"more words\">';\n");
      out.write("                        document.getElementById('moreWords').innerHTML= \"+\"+(wordsObj.matchedWords.length-count)+\" more found\";\n");
      out.write("                    }\n");
      out.write("                    else if(count<temp+11)\n");
      out.write("                    {\n");
      out.write("                        document.getElementById('moreWords').innerHTML= \"no more matches\";\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("                    else if(count<temp+1)\n");
      out.write("                    {\n");
      out.write("                        document.getElementById('moreWords').innerHTML= \"no matches\";\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("                   console.log(listWords);\n");
      out.write("                   document.getElementById('matchedWords').innerHTML=listWords;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            $(\"#hi\").click(function () {\n");
      out.write("            $(this).parent().hide();\n");
      out.write("            return false;\n");
      out.write("            });\n");
      out.write("            $(\"#moreWords\").mouseenter(function () {\n");
      out.write("            $(this).css({\"color\":\"blue\"});\n");
      out.write("            });\n");
      out.write("            $(\"#moreWords\").mouseleave(function () {\n");
      out.write("            $(this).css({\"color\":\"red\"});\n");
      out.write("            });\n");
      out.write("            $(\"#moreWords\").click(function (){\n");
      out.write("                functionSuggestion();\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            \n");
      out.write("          \n");
      out.write("            var objJSON='");
      out.print(request.getAttribute("wordObj"));
      out.write("';\n");
      out.write("\n");
      out.write("            var $sel_open=$(\".suggested1\").select2({\n");
      out.write("            placeholder:\"Suggested Words\",\n");
      out.write("            allowClear: true\n");
      out.write("            });\n");
      out.write("            $(\"#matchedWords2\").select2({\n");
      out.write("            placeholder:\"Similar Words\",\n");
      out.write("            allowClear: true\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            $(\"#sug1\").change(function() {\n");
      out.write("               // var selval=$(this).val();\n");
      out.write("                $(\"#input1\").val($(this).find(\"option:selected\").attr(\"value\"));\n");
      out.write("            });\n");
      out.write("            $(\"#sug2\").change(function() {\n");
      out.write("                //var selval=$(this).val();\n");
      out.write("                $(\"#input1\").val($(this).find(\"option:selected\").attr(\"value\"));\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        if(objJSON!='null' )\n");
      out.write("            {\n");
      out.write("                var obj=JSON.parse(objJSON);\n");
      out.write("            \n");
      out.write("                $(\".suggested1\").select2({\n");
      out.write("                data: obj.permutedWordArray\n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                $sel_open.select2(\"open\");\n");
      out.write("            }\n");
      out.write("\n");
      out.write("    \n");
      out.write("           \n");
      out.write("    });\n");
      out.write("     \n");
      out.write("    </script>\n");
      out.write("    \n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
