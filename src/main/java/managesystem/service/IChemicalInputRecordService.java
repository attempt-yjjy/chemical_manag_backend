package managesystem.service;

import managesystem.entities.ChemicalInputRecord;
import managesystem.entities.logic.ResponseEntities;

import java.util.List;

public interface IChemicalInputRecordService {

    ResponseEntities<Integer> findAllCount();
    ResponseEntities<List<ChemicalInputRecord>> findOnePage(Integer preNum);

    ResponseEntities<Integer> findFuzzyCount(String pattern);
    ResponseEntities<List<ChemicalInputRecord>> findFuzzyOnePage(String pattern,Integer preNum);

    ResponseEntities<Boolean> insertChemicalInputRecord(ChemicalInputRecord chemicalInputRecord);
}
