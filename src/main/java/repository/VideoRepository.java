package repository;

import domain.entities.Video;

import java.util.List;

public interface VideoRepository extends GenericRepository<Video, String>{

    List<Video> getLatestVideos();

}
