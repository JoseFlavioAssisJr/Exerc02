package Reclamação;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditaReclamacao", urlPatterns = {"/edita.html"})
public class EditaReclamacao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Reclamação r = new Reclamação();
        Long id = Long.parseLong(request.getParameter("id"));

        try {
            //Pegar os dados do banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM reclamacao WHERE id=" + id);
            if (resultado.next()) {
                //contato = new Contato();
                r.setId(resultado.getLong("id"));
                r.setNome(resultado.getString("nome"));
                r.setEmail(resultado.getString("email"));
                r.setDescricao(resultado.getString("descricao"));
                r.setStatus(resultado.getInt("status"));
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaReclamacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaReclamacao.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("reclamacao", r);
        request.getRequestDispatcher("EditaReclamacao.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Reclamação r = new Reclamação();
        r.setId(Long.parseLong(request.getParameter("id")));
        r.setNome(request.getParameter("nome"));
        r.setEmail(request.getParameter("email"));
        r.setDescricao(request.getParameter("descricao"));
        r.setStatus(Integer.parseInt(request.getParameter("status")));

        try {
            //Pegar os dados do banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate("UPDATE reclamacao SET nome='"
                    + r.getNome() + "', email='"
                    + r.getEmail() + "', descricao='"
                    + r.getDescricao() + "', status='"
                    + r.getStatus() + "' WHERE id="
                    + r.getId()
            );

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaReclamacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaReclamacao.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("lista.html");
    }

}