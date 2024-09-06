package gc._4.pr2.grupo5.service.impl;

import gc._4.pr2.grupo5.entity.Envios;
import gc._4.pr2.grupo5.repository.EnviosRepository;
import gc._4.pr2.grupo5.service.EnviosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnviosServiceImpl implements EnviosService {

    @Autowired
    private EnviosRepository enviosRepository;

    @Override
    public List<Envios> getAllEnvios() {
        return enviosRepository.findAll();
    }

    @Override
    public Optional<Envios> getEnvioById(Long id) {
        return enviosRepository.findById(id);
    }

    @Override
    public Envios createOrUpdateEnvio(Envios envio) {
        return enviosRepository.save(envio);
    }

    @Override
    public void deleteEnvio(Long id) {
        enviosRepository.deleteById(id);
    }
}
