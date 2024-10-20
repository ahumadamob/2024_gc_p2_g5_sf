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
<<<<<<< HEAD
        if (envio == null) {
            return ResponseEntity.notFound().build();
        }
=======
>>>>>>> 4ce691f84feaa2586d2609d6fad457b574e1b24b
        return ResponseEntity.ok(envio);
    }

    @PostMapping
    public ResponseEntity<Envios> createOrUpdateEnvio(@RequestBody Envios envio) {
        Envios updatedEnvio = enviosService.createOrUpdateEnvio(envio);
        return ResponseEntity.ok(updatedEnvio);
    }

<<<<<<< HEAD
    @PutMapping
    public ResponseEntity<Envios> updateEnvio(@RequestBody Envios envio) {
        if (enviosService.getEnvioById(envio.getId()) == null) {
            return ResponseEntity.notFound().build();
        }
=======
    @PutMapping("/{id}")
    public ResponseEntity<Envios> updateEnvio(@PathVariable Long id, @RequestBody Envios envio) {
        envio.setId(id); // Asegúrate de tener un método setId en tu entidad
>>>>>>> 4ce691f84feaa2586d2609d6fad457b574e1b24b
        Envios updatedEnvio = enviosService.createOrUpdateEnvio(envio);
        return ResponseEntity.ok(updatedEnvio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnvio(@PathVariable Long id) {
<<<<<<< HEAD
        if (enviosService.getEnvioById(id) == null) {
            return ResponseEntity.notFound().build();
        }
=======
>>>>>>> 4ce691f84feaa2586d2609d6fad457b574e1b24b
        enviosService.deleteEnvio(id);
        return ResponseEntity.noContent().build();
    }
}
