package service;

import domain.entities.Singer;
import domain.entities.Tag;
import domain.entities.Video;
import domain.models.bindings.VideoBindingModel;
import domain.models.views.LatestVideosViewModel;
import domain.models.views.VideosViewModel;
import repository.VideoRepository;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;

    @Inject
    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public boolean saveVideo(VideoBindingModel videoBindingModel) {

        String description = String.join(",", videoBindingModel.getDescription());

        List<Tag> tags = videoBindingModel.getTags()
                .stream()
                .map(t -> {
                    Tag tag = new Tag();
                    tag.setName(t);

                    return tag;
                })
                .collect(Collectors.toList());

        List<Singer> singers = videoBindingModel.getSingers()
                .stream()
                .map(t -> {
                    Singer singer = new Singer();
                    singer.setName(t);

                    return singer;
                })
                .collect(Collectors.toList());

        Video video = new Video
                .VideoBuilder()
                .setName(videoBindingModel.getName())
                .setImageId(videoBindingModel.getImageId())
                .setDescription(description)
                .setYouTubeUrl(videoBindingModel.getYouTubeUrl())
                .setTags(tags)
                .setTime(videoBindingModel.getTime())
                .setSingers(singers)
                .build();

        return this.videoRepository.save(video) != null;
    }

    @Override
    public List<LatestVideosViewModel> getLatestVideosViewModel() {
        return this.videoRepository.findAll()
                .stream()
                .map(v -> {
                    LatestVideosViewModel latestVideosViewModel = new LatestVideosViewModel();
                    latestVideosViewModel.setId(v.getId());
                    latestVideosViewModel.setImageId("song_divi_i_shtastlivi");
                    latestVideosViewModel.setName(v.getName());

                    return latestVideosViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<VideosViewModel> getVideosPerPage(int currentPage, int recordsPerPage) {

        int start = currentPage * recordsPerPage - recordsPerPage;

        List<Video> videos = this.videoRepository.findVideosByNumber(start, recordsPerPage);


        return videos.stream()
                .map(v -> {
                    VideosViewModel videosViewModel = new VideosViewModel();
                    videosViewModel.setImageId(v.getImageId());
                    return videosViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public long getSize() {
        return this.videoRepository.size();
    }

}
