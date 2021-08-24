package br.com.music.musicws.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import javax.validation.Valid;
import java.util.Optional;
import br.com.music.musicws.service.MusicaService;
import br.com.music.musicws.shared.MusicaDto;
import org.springframework.http.ResponseEntity;
import org.modelmapper.ModelMapper;

@RestController
@RequestMapping("/api/musicas")

public class MusicaController {
    @Autowired
    MusicaService servico;

    @GetMapping
   public ResponseEntity<List<MusicaDto>> listarMusicas(){

   return new ResponseEntity<>(servico.listarMusicas(), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<MusicaDto> criarMusica(@RequestBody @Valid MusicaDto musica){
        return new ResponseEntity<>( servico.criarMusica(musica), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Void> excluirMusica(@PathVariable String id){
        servico.excluirMusica(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity< MusicaDto> atualizarMusica(@PathVariable String id, @RequestBody @Valid MusicaDto musica) {
        MusicaDto dto = new ModelMapper().map(musica, MusicaDto.class);
        Optional<MusicaDto> music = servico.atualizarMusica(id, dto);
        if(music.isPresent()){
            return new ResponseEntity<>(music.get(), HttpStatus.FOUND);

        }
        return new ResponseEntity<>( HttpStatus.NOT_ACCEPTABLE);
    }







    
}
