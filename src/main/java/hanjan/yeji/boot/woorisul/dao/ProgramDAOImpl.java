package hanjan.yeji.boot.woorisul.dao;

import hanjan.yeji.boot.woorisul.model.Brewery;
import hanjan.yeji.boot.woorisul.model.Program;
import hanjan.yeji.boot.woorisul.mybatis.ProgramMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("pdao")
@RequiredArgsConstructor
public class ProgramDAOImpl implements ProgramDAO{

    final ProgramMapper programMapper;

    @Override
    public int insertProgram(Program p) {
        return programMapper.insertProgram(p);
    }

    @Override
    public List<Program> selectProgram() {
        return programMapper.selectProgram();
    }
}
