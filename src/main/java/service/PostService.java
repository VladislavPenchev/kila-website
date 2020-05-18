package service;

import domain.models.bindings.PostBindingModel;
import domain.models.views.PostViewModel;

import java.util.List;

public interface PostService {

    boolean savePost(PostBindingModel postBindingModel);

    List<PostViewModel> getAllPosts();
}
