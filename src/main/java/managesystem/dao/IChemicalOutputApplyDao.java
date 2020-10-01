package managesystem.dao;

import managesystem.entities.ChemicalOutputApply;

import java.util.List;

public interface IChemicalOutputApplyDao {

    Integer findAllCount();
    List<ChemicalOutputApply> findOnePage(Integer preNum);

    Boolean insertApply(ChemicalOutputApply apply);
}
