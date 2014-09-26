<%@page laguage="java"contentType="text/html；charset=GBK"
  pageEncoding="GBK"import=“wpf.DBUtil,wpf.ConstantUtil，java.uitl.*.java.spl.*.java.io.*"%>
<!DOCTYPE html PUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN”
"http://www.w3.org/TR/html/loose.dtd">
<html>
<LINK Href="global.css"type=text/css"rel="stylesheet"/>
<head>
<meta http-equiv="Content-Type"content="text/html;charset=GBK">
<title><title>
</head>
<body>
<%
     request.srtCharacterEncoding(ConstantUtil.CHAR_ENCODING); //设置编辑格式
     string pid = (string)requset.getParameter("pid");        //读取照片ID
     Blob blob = DBUtil.getphotoBlob(pid)；               //调用DBUtil类的方法获得图片Blob
     if（blob == null）{                                  //获取Blob图片失败
            response.sendRedirect（"img/no_image.jpg"）;//显示默认的图片
     }                                                    
     else{                                                //成功获取数据
          long size = blob.length（）;                  //获取长度
     byte[]bytes = blob.getBytes(1,(int)size);           //获取字节数组
     response.setContentType（"image/Jpeg")
     OutputStream outs = response.getOutputStream();    //获取输出流
     outs.writ（bytes）;                                 //将图片数据
     outs.flush（）;                                    //清空缓冲
     out.clear();                                       //清除
     out = pageContext.pushBody（）;                    //返还pageContent对象
  }
%>
</body></html>
   
