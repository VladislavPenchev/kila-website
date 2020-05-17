package service;

import domain.entities.Singer;
import domain.entities.Tag;
import domain.entities.Video;
import domain.models.bindings.VideoBindingModel;
import repository.VideoRepository;

import javax.inject.Inject;
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
}
