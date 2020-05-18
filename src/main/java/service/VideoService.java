package service;

import domain.models.bindings.VideoBindingModel;
import domain.models.views.LatestVideosViewModel;
import domain.models.views.VideosViewModel;

import java.util.List;

public interface VideoService {

    boolean saveVideo(VideoBindingModel videoBindingModel);

    List<LatestVideosViewModel> getLatestVideosViewModel();

    List<VideosViewModel> getVideosPerPage(int start, int recordsPerPage);

    long getSize();

}
