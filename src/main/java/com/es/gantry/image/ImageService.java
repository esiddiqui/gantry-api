package com.es.gantry.image;

import com.spotify.docker.client.messages.Image;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


public interface ImageService {

    List<Image> findAll();
    List<Image> findAll(Pageable pageable);
    Optional<Image> findById(String id);
    Optional<Image> findByName(String name);

}
