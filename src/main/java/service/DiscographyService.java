package service;

import domain.entities.Discography;
import domain.models.bindings.DiscographyBindingModel;
import domain.models.views.CurrentDiscographyViewModel;

import java.io.IOException;
import java.util.List;

public interface DiscographyService {

    boolean saveDiscography(DiscographyBindingModel discographyBindingModel) throws IOException;

    CurrentDiscographyViewModel getDiscographyById(String id);

    List<CurrentDiscographyViewModel> getAllDiscographies();
}
