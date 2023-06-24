package br.edu.ficdev;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/merendas")
public class MerendaController {

    private final MerendaRepository merendaRepository;

    public MerendaController(MerendaRepository merendaRepository) {
        this.merendaRepository = merendaRepository;
    }

    @GetMapping
    public List<Merenda> getAllMerendas() {
        return merendaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Merenda> getMerendaById(@PathVariable Long id) {
        return merendaRepository.findById(id);
    }
    
    @GetMapping("/nome/{nome}")
    public List<Merenda> getMerendaByNome(@PathVariable String nome) {
        return merendaRepository.findByNome(nome);
    }

    @PostMapping
    public Merenda addMerenda(@RequestBody Merenda newMerenda) {
        return merendaRepository.save(newMerenda);
    }

    @PutMapping("/{id}")
    public Merenda updateMerenda(@RequestBody Merenda updatedMerenda, @PathVariable Long id) {
        updatedMerenda.setId(id);
        return merendaRepository.save(updatedMerenda);
    }

    @DeleteMapping("/{id}")
    public void deleteMerenda(@PathVariable Long id) {
        merendaRepository.deleteById(id);
    }
}
