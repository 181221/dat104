package pwa.controller;

import pwa.app.FlashUtil;
import pwa.dataaccess.HandlelisteEAO;
import pwa.model.Bruker;
import pwa.model.Vare;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by Peder on 12.09.2017.
 */
@WebServlet("/handleliste")
public class HandlelisteServlet extends HttpServlet {
    @EJB
    private HandlelisteEAO handlelisteEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("loggedInUser") != null){
            Vare v;
            String navn = request.getParameter("vare");
            String slett =  request.getParameter("varenavn");
            if(navn != null) {
                v = new Vare();
                v.setNavn(navn);
                Bruker b = (Bruker) request.getSession().getAttribute("currentUser");
                System.out.println(b.getKurv().getKurv_id());
                b.getKurv().leggTilVare(v);
                System.out.println(b.getKurv().getVarer().get(0).getNavn());
                handlelisteEAO.leggTilVare(v);
                FlashUtil.Flash(request,"Success", "Vare lagt til");
            }else if(!slett.isEmpty()) {
                FlashUtil.Flash(request,"Success", "Vare slettet!");
                handlelisteEAO.slettVare(slett);
            }
            else {
                FlashUtil.Flash(request, "Error", "Du skrev inn Ugyldig");
            }
        }
        response.sendRedirect("/handleliste");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("loggedInUser") != null){
            FlashUtil.Flash(request,"Success","Her er din handleliste");
          //  List<Vare> varer = handlelisteEAO.visAlleVarer();
            Bruker b = (Bruker) request.getSession().getAttribute("currentUser");
            System.out.println("hei");
            List<Vare> varer = handlelisteEAO.visAlleVarerTilBruker(b.getBruker_id());
            request.setAttribute("varer",varer);
            request.getRequestDispatcher("WEB-INF/handleliste.jsp").forward(request,response);
        }else {
            FlashUtil.duMaaVeareLoggetInn(request);
            response.sendRedirect("/login");
        }

    }
}
