package co.edu.cesde.ga.repository.impl;

import co.edu.cesde.ga.model.Subject;
import co.edu.cesde.ga.repository.SubjectsRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SubjectsRepositoryInMemory implements SubjectsRepository {

    // Lista sincronizada para seguridad en hilos (opcional)
    private final List<Subject> subjects = Collections.synchronizedList(new ArrayList<>());

    @Override
    public Subject create(Subject subject) {
        if (!existsByCode(subject.getCode())) {
            subjects.add(subject);
            return subject;
        }
        return null; // ya existe
    }

    @Override
    public boolean existsByCode(String code) {
        return subjects.stream()
                .anyMatch(s -> s.getCode().equalsIgnoreCase(code));
    }

    @Override
    public Subject findByCode(String code) {
        Optional<Subject> subject = subjects.stream()
                .filter(s -> s.getCode().equalsIgnoreCase(code))
                .findFirst();
        return subject.orElse(null);
    }

    @Override
    public List<Subject> findAll() {
        return new ArrayList<>(subjects); // devolvemos copia
    }

    @Override
    public boolean delete(String code) {
        return subjects.removeIf(s -> s.getCode().equalsIgnoreCase(code));
    }

    @Override
    public int count() {
        return subjects.size();
    }

    @Override
    public boolean update(Subject subject) {
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getCode().equalsIgnoreCase(subject.getCode())) {
                // Reemplaza completamente el objeto
                subjects.set(i, subject);
                return true;
            }
        }
        return false; // no encontrado
    }
}