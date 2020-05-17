package web.servlets;

import domain.models.bindings.VideoBindingModel;
import service.VideoService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create/video")
public class CreateVideoServlet extends HttpServlet {

    private final VideoService videoService;

    @Inject
    public CreateVideoServlet(VideoService videoService) {
        this.videoService = videoService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/create-video.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VideoBindingModel videoBindingModel = (VideoBindingModel) req.getAttribute("model");

        boolean isSavedVideo = this.videoService.saveVideo(videoBindingModel);

        if (isSavedVideo) {
            resp.sendRedirect("/create/video");
        }

    }
}
