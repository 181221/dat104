package pwa.controller;

import pwa.app.FlashUtil;
import pwa.app.ValidatorUtil;
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
            String navn = request.getParameter("vare");
            String slett =  request.getParameter("varenavn");
            if(ValidatorUtil.isValidString(navn)) {
                handlelisteEAO.leggTilVare(opprettVaren(navn, request));
                FlashUtil.Flash(request,"Success", "Vare lagt til");
            }else if(ValidatorUtil.isNotNull0(slett)) {
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
            Bruker b = (Bruker) request.getSession().getAttribute("currentUser");
            List<Vare> varer = handlelisteEAO.visAlleVarerTilBruker(b.getBruker_id());
            request.setAttribute("varer", varer);
            request.getRequestDispatcher("WEB-INF/handleliste.jsp").forward(request,response);
        }else {
            FlashUtil.duMaaVeareLoggetInn(request);
            response.sendRedirect("/login");
        }
    }
    private Vare opprettVaren(String navn, HttpServletRequest req){
        Vare v;
        v = new Vare();
        v.setNavn(navn);
        Bruker b = (Bruker) req.getSession().getAttribute("currentUser");
        v.setKurv(b.getKurv());
        b.getKurv().leggTilVare(v);
        return v;
    }
    public void init() throws ServletException {

    }
}
