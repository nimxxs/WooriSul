package hanjan.yeji.boot.woorisul.dao;

import hanjan.yeji.boot.woorisul.model.Program;

import java.util.List;

public interface ProgramDAO {

    int insertProgram(Program p);

    List<Program> selectProgram();
}
