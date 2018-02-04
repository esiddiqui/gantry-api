package com.es.gantry.image;


import com.es.gantry.service.DockerClientService;
import com.spotify.docker.client.messages.Image;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DockerClientImageService implements ImageService {

    private DockerClientService docker;

    @Autowired
    public DockerClientImageService(DockerClientService docker) {
        this.docker = docker;

    }

    public List<Image> findAll() {
        try {
            return this.docker.get().listImages();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Image> findAllMatching(String pattern) {
        List<Image> images = findAll();
        return images.stream()
                .filter( image ->
                     image.repoTags().stream()
                            .filter(tag->tag.contains(pattern))
                            .count()>0 ||
                     image.id().contains(pattern)
                ).collect(Collectors.toList());
    }

    public List<Image> findAll(Pageable pageable) {
        return null;
    }

    public Optional<Image> findById(String id) {
        return this.findAll().stream()
                .filter(image -> image.id().startsWith(id))
                .findFirst();
    }

    public Optional<Image> findByName(String name) {
        return this.findAll().stream()
                .filter(image -> image.id().equalsIgnoreCase(name))
                .findFirst();

    }

}
