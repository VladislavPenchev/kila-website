package web.servlets;

import domain.models.views.CurrentDiscographyViewModel;
import service.DiscographyService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/discography/*")
public class CurrentDiscographyServlet extends HttpServlet {

    private final DiscographyService discographyService;

    @Inject
    public CurrentDiscographyServlet(DiscographyService discographyService) {
        this.discographyService = discographyService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CurrentDiscographyViewModel discography = this.discographyService
                .getDiscographyById(req.getPathInfo().substring(1));

        req.setAttribute("model", discography);

        req.getRequestDispatcher("/jsp/current-discography.jsp")
                .forward(req, resp);
    }
}
