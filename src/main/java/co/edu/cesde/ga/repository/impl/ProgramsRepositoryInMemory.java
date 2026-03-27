package co.edu.cesde.ga.repository.impl;

import co.edu.cesde.ga.model.Programs;
import co.edu.cesde.ga.repository.ProgramsRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProgramsRepositoryInMemory implements ProgramsRepository {


    private final List<Programs> programs = Collections.synchronizedList(new ArrayList<>());

    @Override
    public Programs create(Programs program) {
        if (!existsByCode(program.getCode())) {
            programs.add(program);
            return program;
        }
        return null;
    }

    @Override
    public List<Programs> findAll() {
        return new ArrayList<>(programs);
    }

    @Override
    public Programs findById(Long programId) {

        long id = programId != null ? programId : -1;
        for (Programs p : programs) {
            if (p.getProgramId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Programs findByCode(String code) {
        Optional<Programs> program = programs.stream()
                .filter(p -> p.getCode().equalsIgnoreCase(code))
                .findFirst();
        return program.orElse(null);
    }

    @Override
    public boolean update(Programs program) {
        for (int i = 0; i < programs.size(); i++) {
            if (programs.get(i).getProgramId() == program.getProgramId()) {
                programs.set(i, program);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Long programId) {
        long id = programId != null ? programId : -1;
        return programs.removeIf(p -> p.getProgramId() == id);
    }

    @Override
    public boolean existsByCode(String code) {
        return programs.stream()
                .anyMatch(p -> p.getCode().equalsIgnoreCase(code));
    }

    @Override
    public int count() {
        return programs.size();
    }
}