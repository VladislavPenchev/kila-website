package web.servlets;

import service.PostService;
import service.VideoService;
import service.VideoServiceImpl;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    private final VideoService videoService;
    private final PostService postService;

    @Inject
    public IndexServlet(VideoServiceImpl videoService, PostService postService) {
        this.videoService = videoService;
        this.postService = postService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("latestVideos", this.videoService.getLatestVideosViewModel());
        req.setAttribute("posts", this.postService.getAllPosts());
        req.setAttribute("youTubeUrl", "1BW2Hz0f_68");

        req.getRequestDispatcher("/jsp/index.jsp")
                .forward(req, resp);
    }
}
