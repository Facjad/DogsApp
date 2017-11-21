<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Some dog images</title>
</head>
<body>
	<table>
		<tr>
			<td colspan="2" style="font-weight:bold;">Dog images :</td> 
		</tr>
			<%
			int i ;
			java.util.ArrayList<String> dogNames = (java.util.ArrayList<String>) request.getAttribute("dogNames");
			java.util.ArrayList<String> dogImages = (java.util.ArrayList<String>) request.getAttribute("dogImages");
			for (i=0 ; (i < dogNames.size()) && (i < dogImages.size()) ; i++) {
				out.print("<tr><td>") ;
				out.print("<a href= " + dogImages.get(i) + ">") ;
				out.print(dogNames.get(i)) ;
				out.print("</a>") ;
				out.print("</td></tr>") ;
			}
			/*while(rs.next()){
				String dogRace = rs.getString(1) ;
				String dogImage = rs.getString(2) ;
				out.print("<tr><td>") ;
				out.print("<a href= "+dogImage+">") ;
				out.print(dogRace) ;
				out.print("</a>") ;
				out.print("</td></tr>") ;
			}
			rs.close() ;
			st.close() ;*/
			%>
	</table>
</body>
</html>