package web.servlets;

import domain.models.bindings.GalleryBindingModel;
import service.GalleryService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/create/gallery")
@MultipartConfig
public class CreateGalleryServlet extends HttpServlet {

    private final GalleryService galleryService;

    @Inject
    public CreateGalleryServlet(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/create-gallery.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GalleryBindingModel galleryBindingModel = new GalleryBindingModel();
        galleryBindingModel.setName(req.getParameter("name"));
        List<Part> imageParts = req.getParts().stream()
                .filter(part -> part.getName().equals("imageFile"))
                .collect(Collectors.toList());
        galleryBindingModel.setImageFile(imageParts);

        boolean isGallerySaved = this.galleryService.saveGallery(galleryBindingModel);

        if (isGallerySaved) {
            resp.sendRedirect("/create/gallery");
        }
    }
}
