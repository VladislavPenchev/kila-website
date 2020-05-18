package web.servlets;

import domain.entities.Video;
import domain.models.views.VideosViewModel;
import service.VideoService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/videos")
public class VideoServlet extends HttpServlet {

    private final VideoService videoService;

    @Inject
    public VideoServlet(VideoService videoService) {
        this.videoService = videoService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
//        int recordsPerPage = Integer.parseInt(req.getParameter("recordsPerPage"));

        int currentPage = 1;
        int recordsPerPage = 4;

        List<VideosViewModel> videos = this.videoService.getVideosPerPage(currentPage, recordsPerPage);
        req.setAttribute("listVideos", videos);

        long rows = this.videoService.getSize();

        long nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }

        req.setAttribute("noOfPages", nOfPages);
        req.setAttribute("currentPage", currentPage);

        req.getRequestDispatcher("/jsp/videos.jsp")
                .forward(req, resp);
    }
}
