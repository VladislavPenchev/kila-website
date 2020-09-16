package web.servlets;

import domain.models.bindings.DiscographyBindingModel;
import service.DiscographyService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@WebServlet("/create/discography")
@MultipartConfig
public class CreateDiscographyServlet extends HttpServlet {

    private final DiscographyService discographyService;

    @Inject
    public CreateDiscographyServlet(DiscographyService discographyService) {
        this.discographyService = discographyService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/create-discography.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiscographyBindingModel discographyBindingModel = new DiscographyBindingModel();

        req.setCharacterEncoding("UTF-8");

        discographyBindingModel.setName(req.getParameter("name"));
        discographyBindingModel.setYear(req.getParameter("year"));
        discographyBindingModel.setDuration(req.getParameter("duration"));
        discographyBindingModel.setBitrate(req.getParameter("bitrate"));
        if (req.getParameter("buyYes") != null) {
            discographyBindingModel.setCanBuy(true);
        } else {
            discographyBindingModel.setCanBuy(false);
        }
        discographyBindingModel.setImageFile(req.getParts()
                .stream()
                .filter(p -> p.getName().equals("imageFile"))
                .collect(Collectors.toList()));
        discographyBindingModel.setSongs(Arrays.asList(req.getParameterValues("song")));

        discographyService.saveDiscography(discographyBindingModel);

        resp.sendRedirect("/create/discography");
    }
}
