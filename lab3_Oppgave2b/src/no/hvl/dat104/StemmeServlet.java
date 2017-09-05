package no.hvl.dat104;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/stem")
public class StemmeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int valg = Integer.parseInt(request.getParameter("radio1"));
        request.getSession().setAttribute("valg",valg);
        response.sendRedirect("/result");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> options = readOptionsFromFile("WEB-INF/options.txt");
        request.getSession().setAttribute("options", options);
        request.getRequestDispatcher("stem.jsp").forward(request,response);
    }

    private List<String> readOptionsFromFile(String filePath) throws IOException{
        List<String> options = new ArrayList<>();

        InputStream optionsStream = getServletContext().getResourceAsStream(filePath);
        BufferedReader optionsReader = new BufferedReader(new InputStreamReader(optionsStream));

        String option = optionsReader.readLine();
        while(option != null) {
            options.add(option);
            option = optionsReader.readLine();
        }
        optionsReader.close();
        return options;
    }
}
