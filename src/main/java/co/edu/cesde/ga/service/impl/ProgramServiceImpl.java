package co.edu.cesde.ga.service.impl;

import co.edu.cesde.ga.model.Programs;
import co.edu.cesde.ga.repository.ProgramsRepository;
import co.edu.cesde.ga.service.ProgramService;
import java.util.List;

public class ProgramServiceImpl implements ProgramService {

    private final ProgramsRepository programsRepository;

    public ProgramServiceImpl(ProgramsRepository programsRepository) {
        this.programsRepository = programsRepository;
    }

    @Override
    public Programs create(Programs program) {
        if (isInvalidProgram(program)) return null;
        if (programsRepository.existsByCode(program.getCode())) return null;
        return programsRepository.create(program);
    }

    @Override
    public boolean update(Programs program) {
        if (isInvalidProgram(program) || program.getProgramId() <= 0L) return false;
        if (programsRepository.findById(program.getProgramId()) == null) return false;
        return programsRepository.update(program);
    }

    @Override
    public boolean delete(Long programId) {
        if (programId == null || programId <= 0L) return false;
        return programsRepository.delete(programId);
    }

    @Override
    public Programs findById(Long programId) {
        if (programId == null || programId <= 0L) return null;
        return programsRepository.findById(programId);
    }

    @Override
    public Programs findByCode(String code) {
        if (code == null || code.isBlank()) return null;
        return programsRepository.findByCode(code);
    }

    @Override
    public boolean existsByCode(String code) {
        if (code == null || code.isBlank()) return false;
        return programsRepository.existsByCode(code);
    }

    @Override
    public List<Programs> findAll() {
        return programsRepository.findAll();
    }

    private boolean isInvalidProgram(Programs program) {
        return program == null
                || !isNotBlank(program.getCode())
                || !isNotBlank(program.getName());
    }

    private boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}