package Reclamação;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaReclamacao", urlPatterns = {"/lista.html"})
public class ListaReclamacao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Reclamação> reclamacoes = new ArrayList<>();

        try {
            //Pegar os dados do banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM reclamacao");
            while(resultado.next()){
                Reclamação reclamacaoAtual = new Reclamação();
                reclamacaoAtual.setId(resultado.getLong("id"));
                reclamacaoAtual.setNome(resultado.getString("nome"));
                reclamacaoAtual.setEmail(resultado.getString("email"));
                reclamacaoAtual.setDescricao(resultado.getString("descricao"));
                reclamacaoAtual.setStatus(resultado.getInt("status"));
                reclamacoes.add(reclamacaoAtual);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaReclamacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaReclamacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("solicitacao", reclamacoes);
        request.getRequestDispatcher("ListaReclamacao.jsp").forward(request, response);
    }

}
