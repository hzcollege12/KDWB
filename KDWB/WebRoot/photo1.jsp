<%@page laguage="java"contentType="text/html��charset=GBK"
  pageEncoding="GBK"import=��wpf.DBUtil,wpf.ConstantUtil��java.uitl.*.java.spl.*.java.io.*"%>
<!DOCTYPE html PUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN��
"http://www.w3.org/TR/html/loose.dtd">
<html>
<LINK Href="global.css"type=text/css"rel="stylesheet"/>
<head>
<meta http-equiv="Content-Type"content="text/html;charset=GBK">
<title><title>
</head>
<body>
<%
     request.srtCharacterEncoding(ConstantUtil.CHAR_ENCODING); //���ñ༭��ʽ
     string pid = (string)requset.getParameter("pid");        //��ȡ��ƬID
     Blob blob = DBUtil.getphotoBlob(pid)��               //����DBUtil��ķ������ͼƬBlob
     if��blob == null��{                                  //��ȡBlobͼƬʧ��
            response.sendRedirect��"img/no_image.jpg"��;//��ʾĬ�ϵ�ͼƬ
     }                                                    
     else{                                                //�ɹ���ȡ����
          long size = blob.length����;                  //��ȡ����
     byte[]bytes = blob.getBytes(1,(int)size);           //��ȡ�ֽ�����
     response.setContentType��"image/Jpeg")
     OutputStream outs = response.getOutputStream();    //��ȡ�����
     outs.writ��bytes��;                                 //��ͼƬ����
     outs.flush����;                                    //��ջ���
     out.clear();                                       //���
     out = pageContext.pushBody����;                    //����pageContent����
  }
%>
</body></html>
   
