package hanjan.yeji.boot.woorisul.service;

import hanjan.yeji.boot.woorisul.model.Cocktail;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CocktailService {
    List<Cocktail> readCocktail(Integer cpg);

    int countCocktail();

    int newCocktail(Cocktail c);

    /*boolean newCocAttach(List<MultipartFile> attachs, int cno) ;*/

    Cocktail readOneCocktail(String cno);

    List<Cocktail> readFindCocktail(Integer cpg, String ftype, String fkey);

    int countFindCocktail(String ftype, String fkey);


}
