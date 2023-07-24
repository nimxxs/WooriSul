package hanjan.yeji.boot.woorisul.mybatis;

import hanjan.yeji.boot.woorisul.model.Program;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProgramMapper {

    int insertProgram(Program p);

    List<Program> selectProgram();
}
