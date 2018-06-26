<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	// 현재 컨택스트(프로젝트명) 가져오기
    	String path = request.getContextPath();  // jsp 형식
    	// ${pageContext.request.contextPath} => 같다(EL 형식)
    %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ryan Login</title>
    <link rel="stylesheet" href="<%=path %>/lion/style.css">
<%--     <link rel="stylesheet" href="${pageContext.request.contextPath}/lion/style.css"> --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
    <div class="divform">
        <svg id="ryan" viewBox="0 0 120 120" xmlns="http://www.w3.org/2000/svg">
            <path d="M0,150 C0,65 120,65 120,150" fill="#e0a243" stroke="#000" stroke-width="2.5" />
            <g class="ears">
                <path d="M46,32 L46,30 C46,16 26,16 26,30 L26,32" fill="#e0a243" stroke="#000" stroke-width="2.5" stroke-linecap="round" transform="rotate(-10,38,24)" />
                <path d="M74,32 L74,30 C74,16 94,16 94,30 L94,32" fill="#e0a243" stroke="#000" stroke-width="2.5" stroke-linecap="round" transform="rotate(10,82,24)" />
            </g>
            <circle cx="60" cy="60" r="40" fill="#e0a243" stroke="#000" stroke-width="2.5" />
            <g class="eyes">
                <!-- left eye and eyebrow-->
                <line x1="37" x2="50" y1="46" y2="46" stroke="#000" stroke-width="3" stroke-linecap="round" />
                <circle cx="44" cy="55" r="3" fill="#000" />
                <!-- right eye and eyebrow -->
                <line x1="70" x2="83" y1="46" y2="46" stroke="#000" stroke-width="3" stroke-linecap="round" />
                <circle cx="76" cy="55" r="3" fill="#000" />
            </g>
            <g class="muzzle">
                <path d="M60,66 C58.5,61 49,63 49,69 C49,75 58,77 60,71 M60,66 C61.5,61 71,63 71,69 C71,75 62,77 60,71" fill="#fff" />
                <path d="M60,66 C58.5,61 49,63 49,69 C49,75 58,77 60,71 M60,66 C61.5,61 71,63 71,69 C71,75 62,77 60,71" fill="#fff" stroke="#000" stroke-width="2.5" stroke-linejoin="round" stroke-linecap="round" />
                <polygon points="59,63.5,60,63.4,61,63.5,60,65" fill="#000" stroke="#000" stroke-width="5" stroke-linejoin="round" />
            </g>
            <path d="M40,105 C10,140 110,140 80,105 L80,105 L70,111 L60,105 L50,111 L40,105" fill="#fff" />
        </svg>
        <input type="text" placeholder="email 입력" id="login_email" name="email">
        <input type="password" placeholder="패스워드 입력" id="login_pw" name="pw">
        
        <br>
        <button class="button orange" onclick="sendData('<%=path %>')">로그인</button> <br>
        <a href="<%=path%>/joinus.tm0" class="button orange">회원가입</a>
    </div>
    
    <script src="<%=path %>/lion/script.js"></script>
    <script>
    function sendData(path) { 
        var email = $('#login_email').val();
        var pw = $('#login_pw').val();

        console.log('니가 쓴 메일은? ' + email);
        console.log('니가 쓴 PW? ' + pw);
        
       	var postUrl = path + "/login_proc.tm0";
        $.post(postUrl,
        	    {
        	        email: email,
        	        pw: pw
        	    },
        	    function(data, status){
        	    	
        	    	console.log("status" + data);
        	    	console.log("data" + data);
        	    	if (status.trim() == "success" && data.trim() == "YES") {
        	    		console.log("로그인 성공");
        	    		location.href="<%=path %>/main.tm0";
        	    	} else {
        	    		console.log("로그인 실패");
        	    		alert("아이디 패스워드를 확인하세요.");
        	    	}
        	    	
        	        //alert("Data: " + data + "\nStatus: " + status);
        	    });
    }
    </script>
</body>
</html>