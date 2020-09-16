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
import java.util.List;

@WebServlet("/discography")
public class DiscographyServlet extends HttpServlet {

    private final DiscographyService discographyService;

    @Inject
    public DiscographyServlet(DiscographyService discographyService) {
        this.discographyService = discographyService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<CurrentDiscographyViewModel> discographies =  this.discographyService.getAllDiscographies();

        req.setAttribute("model", discographies);

        req.getRequestDispatcher("/jsp/discography.jsp")
                .forward(req, resp);
    }
}
