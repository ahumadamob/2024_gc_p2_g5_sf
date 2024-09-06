package gc._4.pr2.grupo5.controller;

import gc._4.pr2.grupo5.entity.Envios;
import gc._4.pr2.grupo5.service.EnviosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/envios")
public class EnviosController {

    @Autowired
    private EnviosService enviosService;

    @GetMapping
    public ResponseEntity<List<Envios>> getAllEnvios() {
        List<Envios> enviosList = enviosService.getAllEnvios();
        return new ResponseEntity<>(enviosList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Envios> getEnvioById(@PathVariable Long id) {
        Optional<Envios> envio = enviosService.getEnvioById(id);
        return envio.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Envios> createEnvio(@RequestBody Envios envio) {
        Envios createdEnvio = enviosService.createOrUpdateEnvio(envio);
        return new ResponseEntity<>(createdEnvio, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Envios> updateEnvio(@PathVariable Long id, @RequestBody Envios envio) {
        if (!enviosService.getEnvioById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        envio.setId(id);
        Envios updatedEnvio = enviosService.createOrUpdateEnvio(envio);
        return new ResponseEntity<>(updatedEnvio, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnvio(@PathVariable Long id) {
        if (!enviosService.getEnvioById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        enviosService.deleteEnvio(id);
        return ResponseEntity.noContent().build();
    }
}
