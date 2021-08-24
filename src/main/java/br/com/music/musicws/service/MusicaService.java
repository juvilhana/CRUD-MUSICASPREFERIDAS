package br.com.music.musicws.service;

import java.util.List;
import java.util.Optional;

import br.com.music.musicws.shared.MusicaDto;


public interface MusicaService {
    
    List<MusicaDto> listarMusicas();
    MusicaDto criarMusica(MusicaDto musica);
    void excluirMusica(String id);
    Optional<MusicaDto> atualizarMusica( String id, MusicaDto filme);
    

    
}
