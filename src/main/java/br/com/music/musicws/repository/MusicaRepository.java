package br.com.music.musicws.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.music.musicws.model.Musica;

public interface MusicaRepository extends MongoRepository<Musica, String> {
    
}
