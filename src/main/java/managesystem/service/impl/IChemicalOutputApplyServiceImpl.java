package managesystem.service.impl;

import managesystem.dao.IChemicalOutputApplyDao;
import managesystem.entities.ChemicalOutputApply;
import managesystem.entities.logic.ResponseEntities;
import managesystem.service.IChemicalOutputApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iChemicalOutputApplyService")
public class IChemicalOutputApplyServiceImpl implements IChemicalOutputApplyService {

    @Autowired
    private IChemicalOutputApplyDao iChemicalOutputApplyDao;

    @Override
    public ResponseEntities<Boolean> addApply(List<ChemicalOutputApply> applies) {
        for(ChemicalOutputApply apply:applies) {
            Boolean result = iChemicalOutputApplyDao.insertApply(apply);
            if(!result){
                throw new RuntimeException("药品出库申请插入失败");
            }
        }
        return new ResponseEntities<Boolean>(true,true,1);
    }
}
