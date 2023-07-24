package hanjan.yeji.boot.woorisul.service;

import hanjan.yeji.boot.woorisul.model.Program;

import java.util.List;

public interface ProgramService {

    boolean saveProgram(Program p);

    List<Program> readProgram();
}
