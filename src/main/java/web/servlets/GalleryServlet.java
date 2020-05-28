package web.servlets;

import domain.models.views.GalleryViewModel;
import service.GalleryService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/pictures")
public class GalleryServlet extends HttpServlet {

    private final GalleryService galleryService;

    @Inject
    public GalleryServlet(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<GalleryViewModel> galleries =this.galleryService.getAllGalleries();

        req.setAttribute("model", galleries);

        req.getRequestDispatcher("/jsp/gallery.jsp")
                .forward(req, resp);
    }
}
