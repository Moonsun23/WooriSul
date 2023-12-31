package hanjan.yeji.boot.woorisul.mybatis;

import hanjan.yeji.boot.woorisul.model.CocAttach;
import hanjan.yeji.boot.woorisul.model.Cocktail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CocktailMapper {
    int insertCocktail(Cocktail c);

    int insertCocAttach(CocAttach ca);

    List<Cocktail> selectCocktail(int stnum);

    Cocktail selectOneCocktail(String cno);

    int selectCountCocktail();

    CocAttach selectOneCocAttach(String cno);

    int lastCocCno();

    List<Cocktail> selectFindCocktail(Map<String, Object> params);

    int countPageFindCocktail(Map<String, Object> params);

    int countFindCocktail(Map<String, Object> params);

    int countAllCocktail();


//    int insertPdsComment(PdsComment pc);
//
//    List<PdsComment> selectPdsComment(String pno);
//
//    int insertPdsReply(PdsComment pc);

    /*int updateViewPds(String bno);
    List<Pds> selectFindPds(Map<String, Object> params);
    int countFindPds(Map<String, Object> params);*/


}
