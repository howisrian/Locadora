package br.com.locadora.locadora.controller.veiculo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoRepository veiculoRepository;

    @PostMapping
    public Veiculo criarVeiculo(@RequestBody @Valid Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }

    @GetMapping
    public List<Veiculo> buscarVeiculo(){
        return veiculoRepository.findAll();
    }

    @GetMapping("{id}")
    public Veiculo buscarVeiculoPorId(@PathVariable Long id){
        return veiculoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("buscarPorModelo")
    public Veiculo buscarVeiculoPorModelo(@RequestParam String modelo){
        return veiculoRepository.findByModelo(modelo).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("buscarPorMarca")
    public Veiculo buscarVeiculoPorMarca(@RequestParam String marca){
        return veiculoRepository.findByMarca(marca).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @GetMapping("buscarPorDisponivel")
    public Veiculo buscarVeiculoPorDisponivel(@RequestParam Boolean disponivel){
        return veiculoRepository.findByDisponivel(disponivel).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @PutMapping("{id}")
    public Veiculo editarVeiculo(@PathVariable Long id, @RequestBody @Validated Veiculo veiculoAtualizado){
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        veiculo.setModelo(veiculoAtualizado.getModelo());
        veiculo.setMarca(veiculoAtualizado.getMarca());
        veiculo.setMotor(veiculoAtualizado.getMotor());
        veiculo.setLugares(veiculoAtualizado.getLugares());
        veiculo.setCor(veiculoAtualizado.getCor());
        veiculo.setDisponivel(veiculoAtualizado.isDisponivel());
        veiculo.setAno(veiculoAtualizado.getAno());
        veiculo.setPlaca(veiculoAtualizado.getPlaca());
        return veiculoRepository.save(veiculo);
    }
}

/* EXAMPL pra usar no THUNDER CLIENT: http://localhost:8080/veiculos ou http://localhost:8080/veiculos/buscarPorDisponivel?disponivel=false
    {
        "modelo":"golf",
        "marca":"volkswagen",
        "motor":"2.0",
        "lugares": 5,
        "cor":"branco",
        "disponivel":true,
        "ano":"2022",
        "placa":"000a0"
    }
    */
