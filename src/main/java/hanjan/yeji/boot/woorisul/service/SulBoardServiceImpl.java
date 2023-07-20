package hanjan.yeji.boot.woorisul.service;

import hanjan.yeji.boot.woorisul.dao.SulBoardDAO;
import hanjan.yeji.boot.woorisul.model.SulBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sbsrv")
@RequiredArgsConstructor

public class SulBoardServiceImpl implements SulBoardService {

    final SulBoardDAO sbdao;

    @Override
    public boolean saveSulBoard(SulBoard sb) {
        boolean isSaved= false;

        if(sbdao.insertSulBoard(sb) > 0) isSaved = true;

        return isSaved;
    }

    @Override
    public List<SulBoard> readSulBoard(Integer cpg) {

        int stnum= (cpg -1) * 25;
        return sbdao.selectSulBoard(stnum);
    }

    @Override
    public int countSulBoard() {
        return sbdao.selectCountSulBoard();
    }


}
