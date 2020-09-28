package managesystem.dao;

import managesystem.entities.ChemicalInputRecord;

import java.util.List;

public interface IChemicalInputRecordDao {
    List<ChemicalInputRecord> findAll();

    Integer findCount();
    List<ChemicalInputRecord> findByPage(Integer preNum);

    Integer findFuzzyCount(String pattern);
    List<ChemicalInputRecord> findFuzzyByPage(String pattern,Integer preNum);

    Boolean insertChemicalInputRecord(ChemicalInputRecord chemicalInputRecord);

    Boolean updateChemicalInputRecord(ChemicalInputRecord chemicalInputRecord);

    Boolean deleteChemicalInputRecord(Integer id);
}
