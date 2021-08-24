package br.com.music.musicws.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.music.musicws.repository.MusicaRepository;
import br.com.music.musicws.shared.MusicaDto;
import br.com.music.musicws.model.Musica;

@Service
public class MusicaServiceImp implements MusicaService {
    @Autowired
    MusicaRepository repo;

    @Override
    public List<MusicaDto> listarMusicas() {
        List<Musica> musicas = repo.findAll();

        return musicas.stream()
        .map(m -> new ModelMapper().map(m, MusicaDto.class))
        .collect(Collectors.toList());
    }

    @Override
    public MusicaDto criarMusica(MusicaDto musica) {
        Musica musicaParaGravar = new ModelMapper().map(musica, Musica.class);
        musicaParaGravar = repo.save(musicaParaGravar);

        return new ModelMapper().map(musicaParaGravar, MusicaDto.class);
    }

    @Override
    public void excluirMusica(String id) {
        repo.deleteById(id);  
    }

    @Override
    public Optional<MusicaDto> atualizarMusica(String id, MusicaDto musica) {
        ModelMapper mapper = new ModelMapper();
       Optional<Musica> mus = repo.findById(id);
       Musica musicParaSalvar = mapper.map(musica, Musica.class);
        if (mus.isPresent()){
            musicParaSalvar.setId(id);
            musicParaSalvar = repo.save(musicParaSalvar);
            return Optional.of(mapper.map(musicParaSalvar, MusicaDto.class));
        }
        return Optional.empty();
      
    }
    

    
}
