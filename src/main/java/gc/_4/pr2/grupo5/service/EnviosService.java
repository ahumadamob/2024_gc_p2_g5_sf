package gc._4.pr2.grupo5.service;

import gc._4.pr2.grupo5.entity.Envios;
import java.util.List;
import java.util.Optional;

public interface EnviosService {
    List<Envios> getAllEnvios();
    Optional<Envios> getEnvioById(Long id);
    Envios createOrUpdateEnvio(Envios envio);
    void deleteEnvio(Long id);
}
