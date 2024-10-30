package gc._4.pr2.grupo5.service.impl;

import gc._4.pr2.grupo5.entity.Envios;
import gc._4.pr2.grupo5.repo.EnviosRepository;
import gc._4.pr2.grupo5.service.EnviosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnviosServiceImpl implements EnviosService {

    @Autowired
    private EnviosRepository enviosRepository;

    @Override
    public List<Envios> getAllEnvios() {
        return enviosRepository.findAll();
    }

    @Override
    public Envios getEnvioById(Long id) {
        return enviosRepository.findById(id).orElse(null);
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
