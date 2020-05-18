package service;

import domain.entities.Post;
import domain.models.bindings.PostBindingModel;
import domain.models.views.PostViewModel;
import repository.PostRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Inject
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public boolean savePost(PostBindingModel postBindingModel) {

        Post post = new Post.PostBuilder()
                .setName(postBindingModel.getName())
                .setDescription(postBindingModel.getDescription())
                .setImageId(postBindingModel.getImageId())
                .build();

        return this.postRepository.save(post) != null;
    }

    @Override
    public List<PostViewModel> getAllPosts() {
        return this.postRepository.findAll()
                .stream()
                .map(p -> {
                    PostViewModel postViewModel = new PostViewModel();
                    postViewModel.setId(p.getId());
                    postViewModel.setName(p.getName());
                    postViewModel.setDescription(p.getDescription());
                    postViewModel.setImageId(p.getImageId());

                    return postViewModel;
                })
                .collect(Collectors.toList());
    }
}
