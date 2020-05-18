package web.servlets;

import domain.models.bindings.PostBindingModel;
import service.PostService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create/post")
public class CreatePostServlet extends HttpServlet {

    private final PostService postService;

    @Inject
    public CreatePostServlet(PostService postService) {
        this.postService = postService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/create-post.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PostBindingModel postBindingModel = (PostBindingModel) req.getAttribute("model");

        boolean isPostSaved = postService.savePost(postBindingModel);

        if (isPostSaved) {
            resp.sendRedirect("/create/post");
        }

    }
}
