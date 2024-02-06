## 1. Board Select, Add Practice



## 0. util 사전작업

```java
	private DBUtil db;
	public BoardDao() {
		db=DBUtil.getInstance();
	}
```

```java
	private final String driverName = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/ssafydb?serverTimezone=Asia/Seoul&useSSL=false";
	private final String user = "ssafy";
	private final String pass = "ssafy";

	private static DBUtil instance = new DBUtil();

	private DBUtil() {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DBUtil getInstance() {
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}

	public void close(AutoCloseable... closeables) {
		for (AutoCloseable c : closeables) {
			if (c != null) {
				try {
					c.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
```



### 1. Add

```java
	public boolean addBoard(Board board) {
		StringBuilder sql=new StringBuilder();
		sql.append(" INSERT INTO BOARD (user_id,subject,content,register_time) \n");
		sql.append(" VALUES(?,?,?,now()) \n");  
		Connection conn=null;
		PreparedStatement psmt=null;
		int count=0;
		try {
			conn=db.getConnection();
			System.out.println("2/6 conn SS addBoard ");
			psmt=conn.prepareStatement(sql.toString());
			int i=1;
			psmt.setString(i++, board.getUser_id());
			psmt.setString(i++, board.getSubject());
			psmt.setString(i++, board.getContent());
			System.out.println("3/6 conn SS addBoard ");
			count=psmt.executeUpdate();
			System.out.println("4/6 conn SS addBoard ");
			
		} catch (SQLException e) {
			System.out.println("fail addBoard: "+e);
		}finally {
			db.close(psmt,conn);
			System.out.println("6/6 conn SS addBoard ");
		}
		return count>0 ? true: false;
	}
	
	
```

### 2.SelectAll

```java
public List<Board> getAllBoards(){
		List<Board> boards = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT article_no, user_id,subject,content,register_time \n");
		sql.append("FROM BOARD ORDER BY article no");
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn=db.getConnection();
			System.out.println("2/6 getAllBoards suc ~~");
			psmt = conn.prepareStatement(sql.toString());
			System.out.println("3/6 getAllBoards suc ~~");
			rs = psmt.executeQuery();
			System.out.println("4/6 rs getAllBoards suc ~~");
			while(rs.next()) {
				int j = 1;
				Board board= new Board(
						rs.getInt(j++),
						rs.getString(j++),
						rs.getString(j++),
						rs.getString(j++),
						rs.getString(j++)
						);
				boards.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.close(rs,psmt,conn);
		}
		return boards;
	}
```

