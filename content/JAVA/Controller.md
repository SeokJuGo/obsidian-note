

# 컨트롤러

- 자바 컨트롤러는 웹 애플리케이션에서 클라이언트의 요청을 처리하고, 모델과 뷰를 연결하는 역할을 수행하는 중요한 구성 요소

![image](https://github.com/SeokJuGo/SeokJuGo/assets/116260619/10054d3b-aa17-47b1-8f8d-be41e77fc2cb)






```java
@WebServlet("/board")
public class BoardController extends HttpServlet {
	
private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doProcess(request, response);
}

public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doProcess(request, response);
}

public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 요청과 응답 설정
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");

	// 모델 준비
	BoardService bservice = BoardServiceImpl.getInstance();

	// 요청으로부터 커맨드 추출
	String command = request.getParameter("command");

	// 분기 처리 (Controller)
	if (command.equalsIgnoreCase("boardwrite")) {
		// 요청 파라미터 추출
		String user_id = request.getParameter("user_id");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		// DTO 생성 (Data Transfer Object)
		Board board = new Board(user_id, subject, content);

		// 모델 서비스 호출 (비즈니스 로직)
		boolean isSucceeded = bservice.addBoard(board);

		// 결과에 따른 뷰로 리다이렉트
		if (isSucceeded) {
			response.sendRedirect("./board?command=boardlist");
		} else {
			response.sendRedirect("writeboard.jsp");
		}
	}

	// 다른 커맨드 이하.
}
    }
```
