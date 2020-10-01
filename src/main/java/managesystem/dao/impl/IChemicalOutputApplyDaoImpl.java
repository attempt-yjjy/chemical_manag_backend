package managesystem.dao.impl;

import managesystem.dao.IChemicalOutputApplyDao;
import managesystem.entities.ChemicalOutputApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("iChemicalOutputApplyDao")
public class IChemicalOutputApplyDaoImpl implements IChemicalOutputApplyDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer findAllCount() {
        return null;
    }

    @Override
    public List<ChemicalOutputApply> findOnePage(Integer preNum) {
        return null;
    }

    @Override
    public Boolean insertApply(ChemicalOutputApply apply) {
        Integer result = jdbcTemplate.update("insert into chemical_output_apply(ch_name,ch_type,count,output_time,proposer,pro_id) values(?,?,?,?,?,?)",apply.getCh_name(),apply.getCh_type(),apply.getCount(),apply.getOutput_time(),apply.getProposer(),apply.getPro_id());
        if(result == 1){
            return true;
        }
        else if(result == 0){
            return false;
        }
        else{
            throw new RuntimeException("插入药品出库申请时受影响的数据项数异常!");
        }
    }
}
