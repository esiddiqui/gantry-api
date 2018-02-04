package com.es.gantry.service;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class SpotifyUnixSockDockerClient implements DockerClientService {

    private DockerClient client;

    public SpotifyUnixSockDockerClient(@Value("${docker.unix.sock}") String sock) {
        this.client = new DefaultDockerClient(sock);
    }

    @Override
    public DockerClient get() {
        return this.client;
    }
}
