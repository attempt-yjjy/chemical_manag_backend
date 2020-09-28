package managesystem.service.impl;

import managesystem.dao.IChemicalInputRecordDao;
import managesystem.entities.ChemicalInputRecord;
import managesystem.entities.logic.ResponseEntities;
import managesystem.service.IChemicalInputRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iChemicalInputRecordService")
public class IChemicalInputRecordServiceImpl implements IChemicalInputRecordService {

    @Autowired
    private IChemicalInputRecordDao iChemicalInputRecordDao;

    @Override
    public ResponseEntities<Integer> findAllCount() {
        return new ResponseEntities<Integer>(true,iChemicalInputRecordDao.findCount(),1);
    }

    @Override
    public ResponseEntities<List<ChemicalInputRecord>> findOnePage(Integer preNum) {
        List<ChemicalInputRecord> records = iChemicalInputRecordDao.findByPage(preNum);
        return new ResponseEntities<List<ChemicalInputRecord>>(true,records,1);
    }

    @Override
    public ResponseEntities<Integer> findFuzzyCount(String pattern) {
        return new ResponseEntities<Integer>(true,iChemicalInputRecordDao.findFuzzyCount(pattern),1);
    }

    @Override
    public ResponseEntities<List<ChemicalInputRecord>> findFuzzyOnePage(String pattern, Integer preNum) {
        List<ChemicalInputRecord> records = iChemicalInputRecordDao.findFuzzyByPage(pattern,preNum);
        return new ResponseEntities<List<ChemicalInputRecord>>(true,records,1);
    }
}
