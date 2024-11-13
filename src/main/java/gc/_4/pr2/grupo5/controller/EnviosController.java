package gc._4.pr2.grupo5.controller;

import gc._4.pr2.grupo5.dto.EnviosResponseDTO;
import gc._4.pr2.grupo5.entity.Envios;
import gc._4.pr2.grupo5.service.EnviosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/envios")
public class EnviosController {

    @Autowired
    private EnviosService enviosService;

    // Obtener todos los envíos
    @GetMapping
    public ResponseEntity<?> getAllEnvios() {
        List<Envios> envios = enviosService.getAllEnvios();
        
        // Verifica si la lista está vacía y devuelve un mensaje si no hay envíos disponibles
        if (envios.isEmpty()) {
            EnviosResponseDTO response = new EnviosResponseDTO(false, "No hay envíos disponibles.", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        
        // Inicialización de EnviosResponseDTO para respuesta exitosa
        EnviosResponseDTO response = new EnviosResponseDTO(true, "Lista de envíos obtenida exitosamente", envios);
        return ResponseEntity.ok(response);
    }

    // Buscar un envío por ID
    @GetMapping("/{id}")
    public ResponseEntity<EnviosResponseDTO> getEnvioById(@PathVariable Long id) {
        Envios envio = enviosService.getEnvioById(id);
        
        // Si el envío no existe, devuelve un mensaje de error
        if (envio == null) {
            return new ResponseEntity<>(new EnviosResponseDTO(false, "El envío no existe.", null), HttpStatus.NOT_FOUND);
        }
        
        // Inicialización de EnviosResponseDTO con envío encontrado
        return new ResponseEntity<>(new EnviosResponseDTO(true, "Envío encontrado.", envio), HttpStatus.OK);
    }

    // Crear un nuevo envío
    @PostMapping
    public ResponseEntity<EnviosResponseDTO> createEnvio(@RequestBody Envios envio) {
        if (enviosService.exists(envio.getId())) {
            return new ResponseEntity<>(new EnviosResponseDTO(false, "El envío ya existe.", null), HttpStatus.CONFLICT);
        }
        
        // Creación de nuevo objeto de tipo Envios y inicialización mediante el servicio
        Envios nuevoEnvio = enviosService.createOrUpdateEnvio(envio);
        
        return new ResponseEntity<>(new EnviosResponseDTO(true, "Envío creado con éxito.", nuevoEnvio), HttpStatus.CREATED);
    }

    // Actualizar un envío existente
    @PutMapping("/{id}")
    public ResponseEntity<EnviosResponseDTO> updateEnvio(@PathVariable Long id, @RequestBody Envios envio) {
        if (!enviosService.exists(id)) {
            return new ResponseEntity<>(new EnviosResponseDTO(false, "No se puede actualizar un envío inexistente.", null), HttpStatus.NOT_FOUND);
        }
        
        // Actualiza el ID del envío existente y crea una nueva versión actualizada
        envio.setId(id);
        Envios updatedEnvio = enviosService.createOrUpdateEnvio(envio);
        
        return new ResponseEntity<>(new EnviosResponseDTO(true, "Envío actualizado con éxito.", updatedEnvio), HttpStatus.OK);
    }

    // Eliminar un envío por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<EnviosResponseDTO> deleteEnvio(@PathVariable Long id) {
        if (!enviosService.exists(id)) {
            return new ResponseEntity<>(new EnviosResponseDTO(false, "No se pudo encontrar el envío para eliminar.", null), HttpStatus.NOT_FOUND);
        }
        
        enviosService.deleteEnvio(id);
        return new ResponseEntity<>(new EnviosResponseDTO(true, "Envío eliminado exitosamente.", null), HttpStatus.OK);
    }

    // Verificar la existencia de un envío
    @GetMapping("/exists/{id}")
    public ResponseEntity<EnviosResponseDTO> checkEnvioExists(@PathVariable Long id) {
        boolean exists = enviosService.exists(id);
        
        if (exists) {
            return new ResponseEntity<>(new EnviosResponseDTO(true, "El envío existe.", null), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new EnviosResponseDTO(false, "El envío no existe.", null), HttpStatus.NOT_FOUND);
        }
    }
}
