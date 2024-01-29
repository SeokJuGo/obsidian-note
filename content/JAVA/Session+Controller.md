

# Session

## 1. 세션(Session) 

세션(Session)은 웹 애플리케이션에서 클라이언트와 서버 간의 상태를 유지하는 데 사용 

세션은 사용자별로 데이터를 저장하고, 동일한 사용자가 여러 요청 간에 데이터를 공유. 세션은 주로 사용자 인증 및 사용자 관련 데이터의 저장

```java
@WebServlet("/members")
public class MembersController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// Model(비즈니스 로직) 준비
		MembersService mservice = MembersServiceImpl.getInstance();

		// 요청으로부터 커맨드 추출
		String command = request.getParameter("command");

		if (command.equalsIgnoreCase("login")) {
			// 로그인 요청 처리
			String user_id = request.getParameter("user_id");
			String user_password = request.getParameter("user_password");
			Members member = new Members();
			member.setUser_id(user_id);
			member.setUser_password(user_password);

			// DTO 생성

			Members login = mservice.login(member);

			HttpSession session = request.getSession();
			if (login != null) {
				// 로그인 성공 시 세션에 사용자 정보 저장
				session.setAttribute("login", login);
				response.sendRedirect("./board?command=boardlist");
			} else {
				// 로그인 실패 시 세션 무효화
				session.invalidate();
				response.sendRedirect("./index.jsp");
			}
		} else if (command.equalsIgnoreCase("logout")) {
			// 로그아웃 요청 처리
			HttpSession session = request.getSession();
			session.invalidate(); // 세션 무효화
			response.sendRedirect("./index.jsp");
		}
	}
}

```
- (`command.equalsIgnoreCase("login")` ): 사용자가 로그인하면, 세션 객체를 얻어온다 
-  `setAttribute` 메서드를 사용하여 로그인한다.

```jsp

<c:if test="${empty login}">
    <script type="text/javascript">
        alert('로그인 하세요');
    </script>
</c:if>
<c:if test="${not empty login}">
    (${login.user_name})님 반갑습니다.   <a href='./members?command=logout'>로그아웃</a>
    <br/>
</c:if>
```

- jstl이 세션 scope에서 데이터를 검색하고 리스트를 보여준다.