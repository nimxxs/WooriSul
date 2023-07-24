package hanjan.yeji.boot.woorisul.service;

import hanjan.yeji.boot.woorisul.dao.ProgramDAO;
import hanjan.yeji.boot.woorisul.model.Program;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("psrv")
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService{

    final ProgramDAO pdao;
    @Override
    public boolean saveProgram(Program p) {
        boolean isSaved = false;
        if(pdao.insertProgram(p) > 0)
            isSaved = true;
        return isSaved;
    }

    @Override
    public List<Program> readProgram() {
        return pdao.selectProgram();
    }
}
