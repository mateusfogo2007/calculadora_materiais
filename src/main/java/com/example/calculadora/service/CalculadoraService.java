package com.example.calculadora.service;

import com.example.calculadora.model.Parede;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CalculadoraService {
    public Double calcularVolumeConcreto(List<Parede> paredes, Double alturaViga) {
        return paredes.stream()
                .mapToDouble(p -> p.getLargura() * p.getComprimento() * alturaViga)
                .sum();
    }
    public Double calcularTijolos(List<Parede> paredes, Double areaTijolo) {
        double areaTotal = paredes.stream()
                .mapToDouble(p -> (p.getComprimento() * p.getAltura()) - p.getAreaAberturas())
                .sum();
        return Math.ceil(areaTotal / areaTijolo);
    }
}