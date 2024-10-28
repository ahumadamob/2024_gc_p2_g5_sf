package gc._4.pr2.grupo5.controller;

import gc._4.pr2.grupo5.entity.Envios;
import gc._4.pr2.grupo5.service.EnviosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/envios")
public class EnviosController {

    @Autowired
    private EnviosService enviosService;

    @GetMapping
    public List<Envios> getAllEnvios() {
        return enviosService.getAllEnvios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Envios> getEnvioById(@PathVariable Long id) {
        Envios envio = enviosService.getEnvioById(id);

        if (envio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(envio);
    }

    @PostMapping
    public ResponseEntity<Envios> createOrUpdateEnvio(@RequestBody Envios envio) {
        Envios updatedEnvio = enviosService.createOrUpdateEnvio(envio);
        return ResponseEntity.ok(updatedEnvio);
    }

    @PutMapping
    public ResponseEntity<Envios> updateEnvio(@RequestBody Envios envio) {
        if (envio.getId() == null || enviosService.getEnvioById(envio.getId()) == null) {
            return ResponseEntity.notFound().build();
        }
        Envios updatedEnvio = enviosService.createOrUpdateEnvio(envio);
        return ResponseEntity.ok(updatedEnvio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnvio(@PathVariable Long id) {
        if (enviosService.getEnvioById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        enviosService.deleteEnvio(id);
        return ResponseEntity.noContent().build();
    }
}
