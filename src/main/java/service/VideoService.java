package service;

import domain.models.bindings.VideoBindingModel;
import domain.models.views.LatestVideosViewModel;

import java.util.List;

public interface VideoService {

    boolean saveVideo(VideoBindingModel videoBindingModel);

    List<LatestVideosViewModel> getLatestVideosViewModel();

}
