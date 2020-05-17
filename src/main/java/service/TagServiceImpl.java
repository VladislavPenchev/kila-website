package service;

import domain.entities.Tag;
import repository.TagRepository;

import javax.inject.Inject;

public class TagServiceImpl implements TagService{

    private final TagRepository tagRepository;

    @Inject
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public boolean saveTag() {
        Tag tag = new Tag();
        tag.setName("Store");
        this.tagRepository.save(tag);
        return true;
    }
}
