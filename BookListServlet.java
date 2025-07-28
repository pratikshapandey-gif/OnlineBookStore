@WebServlet("/books")
public class BookListServlet extends HttpServlet {
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Book> books = new ArrayList<>();
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement ps = conn.prepareStatement("SELECT * FROM books");
         ResultSet rs = ps.executeQuery()) {
      while(rs.next()) {
        Book b = new Book();
        b.setId(rs.getInt("id"));
        b.setTitle(rs.getString("title"));
        b.setAuthor(rs.getString("author"));
        b.setPrice(rs.getDouble("price"));
        b.setStock(rs.getInt("stock"));
        books.add(b);
      }
    } catch (SQLException e) { e.printStackTrace(); }
    req.setAttribute("books", books);
    req.getRequestDispatcher("/jsp/bookList.jsp").forward(req, resp);
  }
}
