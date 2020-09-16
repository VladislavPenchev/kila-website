package web.filters;

import domain.models.bindings.VideoBindingModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/create/video")
public class CreateVideoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        req.setCharacterEncoding("UTF-8");

        if (req.getMethod().toLowerCase().equals("post")) {
            VideoBindingModel videoBindingModel = new VideoBindingModel();
            videoBindingModel.setName(req.getParameter("name"));
            videoBindingModel.setImageId(req.getParameter("imageId"));
            videoBindingModel.setDescription(Arrays.asList(req.getParameterValues("description")));
            videoBindingModel.setYouTubeUrl(req.getParameter("youTubeUrl"));
            videoBindingModel.setTags(Arrays.asList(req.getParameterValues("tags")));
            videoBindingModel.setTime(req.getParameter("time"));
            videoBindingModel.setSingers(Arrays.asList(req.getParameterValues("singer")));


            req.setAttribute("model", videoBindingModel);
        }

        filterChain.doFilter(req, resp);

    }
}
