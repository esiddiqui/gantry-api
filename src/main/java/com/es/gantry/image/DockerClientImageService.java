package com.es.gantry.image;


import com.spotify.docker.client.messages.Image;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


@Service
public class DockerClientImageService implements ImageService {

    public List<Image> findAll() {
        return null;
    }

    public List<Image> findAll(Pageable pageable) {
        return null;
    }

    public Optional<Image> findById(String id) {
        return null;
    }

    public Optional<Image> findByName(String name) {
        return null;
    }

}
