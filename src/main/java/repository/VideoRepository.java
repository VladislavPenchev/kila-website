package repository;

import domain.entities.Video;

import java.util.List;

public interface VideoRepository extends GenericRepository<Video, String>{

    List<Video> getLatestVideos();

    List<Video> findVideosByNumber(int start, int recordsPerPage);

    List<Video> findVideosByDiscographyId(String id);

}
