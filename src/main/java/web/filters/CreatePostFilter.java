package web.filters;

import domain.models.bindings.PostBindingModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/create/post")
public class CreatePostFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        req.setCharacterEncoding("UTF-8");

//        if (req.getMethod().toLowerCase().equals("post")) {
//            PostBindingModel postBindingModel = new PostBindingModel();
//            postBindingModel.setName(req.getParameter("name"));
//            postBindingModel.setDescription(req.getParameter("description"));
//            postBindingModel.setImageId(req.getParameter("imageId"));
//
//            req.setAttribute("model", postBindingModel);
//        }

        PostBindingModel postBindingModel = new PostBindingModel();
        postBindingModel.setName("100 KILA – NYAMA TAKAVA JENA");
        postBindingModel.setDescription("Music video by 100 KILA performing Nyama Takava Jena Lyrics – 100 KILA Music – 100 KILA & Star Light Records – Svetlin Kuslev Video – Mnogostoka http://fb.com/official100kila http://instagram.com/100kila (C) Jabulah Ent. 2017");
        postBindingModel.setImageId("song_divi_i_shtastlivi");

        req.setAttribute("model", postBindingModel);

        filterChain.doFilter(req, resp);
    }
}
