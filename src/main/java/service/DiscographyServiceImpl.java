package service;

import domain.entities.Discography;
import domain.entities.Image;
import domain.entities.Video;
import domain.models.bindings.DiscographyBindingModel;
import domain.models.views.CurrentDiscographyViewModel;
import domain.models.views.ImageViewModel;
import domain.models.views.VideosViewModel;
import org.apache.commons.io.IOUtils;
import repository.DiscographyRepository;
import repository.ImageRepository;
import repository.VideoRepository;

import javax.inject.Inject;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

public class DiscographyServiceImpl implements DiscographyService {

    private final DiscographyRepository discographyRepository;
    private final ImageRepository imageRepository;
    private final VideoRepository videoRepository;

    @Inject
    public DiscographyServiceImpl(DiscographyRepository discographyRepository, ImageRepository imageRepository, VideoRepository videoRepository) {
        this.discographyRepository = discographyRepository;
        this.imageRepository = imageRepository;
        this.videoRepository = videoRepository;
    }

    @Override
    public boolean saveDiscography(DiscographyBindingModel discographyBindingModel) throws IOException {

        Discography discography = new Discography.DiscographyBuilder()
                .setName(discographyBindingModel.getName())
                .setYear(discographyBindingModel.getYear())
                .setDuration(discographyBindingModel.getDuration())
                .setBitrate(discographyBindingModel.getBitrate())
                .setCanBuy(discographyBindingModel.getCanBuy())
                .build();

        this.discographyRepository.save(discography);

        Image image = null;

        if (discographyBindingModel.getImageFile() != null) {
            List<Part> fileParts = discographyBindingModel.getImageFile();
            for (Part filePart : fileParts) {
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

                InputStream filecontent = filePart.getInputStream();
                byte[] fileAsByteArray = IOUtils.toByteArray(filecontent);

                image = new Image.ImageBuilder()
                        .setName(fileName)
                        .setImageContent(fileAsByteArray)
                        .setGalleryId(discography.getId())
                        .build();

                imageRepository.save(image);
            }
        }

        Video video = null;

        if (discographyBindingModel.getSongs() != null) {
            for (String curVideo : discographyBindingModel.getSongs()) {
                video = new Video.VideoBuilder()
                        .setName(curVideo)
                        .setDiscographyId(discography.getId())
                        .build();
            }

            videoRepository.save(video);
        }

        return true;
    }

    @Override
    public CurrentDiscographyViewModel getDiscographyById(String id) {
        CurrentDiscographyViewModel currentDiscographyViewModel = new CurrentDiscographyViewModel();

        Discography discography = this.discographyRepository.findById(id);

        currentDiscographyViewModel.setId(discography.getId());
        currentDiscographyViewModel.setName(discography.getName());
        currentDiscographyViewModel.setYear(discography.getYear());
        currentDiscographyViewModel.setDuration(discography.getDuration());
        currentDiscographyViewModel.setBitrate(discography.getBitrate());
        currentDiscographyViewModel.setCanBuy(discography.getCanBuy());

        List<ImageViewModel> imageViewModels = imageRepository.findAllByDiscographyId(id)
                .stream()
                .map(i -> {
                    ImageViewModel imageViewModel = new ImageViewModel();
                    imageViewModel.setId(i.getName());

                    String base64Encoded = null;

                    byte[] encodeBase64 = Base64.getEncoder().encode(i.getImageContent());
                    try {
                        base64Encoded = new String(encodeBase64, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    imageViewModel.setImage_content(base64Encoded);

                    return imageViewModel;
                })
                .collect(Collectors.toList());

        List<VideosViewModel> videos = videoRepository.findVideosByDiscographyId(id)
                .stream()
                .map(v -> {
                    VideosViewModel videosViewModel = new VideosViewModel();
                    videosViewModel.setName(v.getName());
                    return videosViewModel;
                })
                .collect(Collectors.toList());

        currentDiscographyViewModel.setImages(imageViewModels);
        currentDiscographyViewModel.setVideos(videos);

        return currentDiscographyViewModel;
    }

    @Override
    public List<CurrentDiscographyViewModel> getAllDiscographies() {
        return this.discographyRepository.findAll()
                .stream()
                .map(d -> {
                    CurrentDiscographyViewModel currentDiscographyViewModel = new CurrentDiscographyViewModel();
                    currentDiscographyViewModel.setId(d.getId());
                    currentDiscographyViewModel.setName(d.getName());
                    currentDiscographyViewModel.setYear(d.getYear());
                    currentDiscographyViewModel.setDuration(d.getDuration());
                    currentDiscographyViewModel.setBitrate(d.getBitrate());
                    currentDiscographyViewModel.setCanBuy(d.getCanBuy());

                    List<ImageViewModel> imageViewModels = imageRepository.findAllByDiscographyId(d.getId())
                            .stream()
                            .map(i -> {
                                ImageViewModel imageViewModel = new ImageViewModel();
                                imageViewModel.setId(i.getName());

                                String base64Encoded = null;

                                byte[] encodeBase64 = Base64.getEncoder().encode(i.getImageContent());
                                try {
                                    base64Encoded = new String(encodeBase64, "UTF-8");
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                                imageViewModel.setImage_content(base64Encoded);

                                return imageViewModel;
                            })
                            .collect(Collectors.toList());

                    currentDiscographyViewModel.setImages(imageViewModels);

                    return currentDiscographyViewModel;
                })
                .collect(Collectors.toList());


    }
}
