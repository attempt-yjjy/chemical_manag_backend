package managesystem.dao.impl;

import managesystem.dao.IChemicalInputRecordDao;
import managesystem.entities.ChemicalInputRecord;
import managesystem.entities.logic.SpecialQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("iChemicalInputRecordDao")
public class IChemicalInputRecordDaoImpl implements IChemicalInputRecordDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ChemicalInputRecord> findAll() {
        return jdbcTemplate.query("select * from chemical_input_record",new BeanPropertyRowMapper<ChemicalInputRecord>(ChemicalInputRecord.class));
    }

    @Override
    public Integer findCount() {
        List<SpecialQueryResult> result = jdbcTemplate.query("select count(*) as count from chemical_input_record",new BeanPropertyRowMapper<SpecialQueryResult>(SpecialQueryResult.class));
        if(result == null || result.size() != 1){
            throw new RuntimeException("查询药品入库记录总条数异常");
        }
        else{
            return result.get(0).getCount();
        }
    }

    @Override
    public List<ChemicalInputRecord> findByPage(Integer preNum) {
        List<ChemicalInputRecord> records = jdbcTemplate.query("select * from chemical_input_record limit ?,10",new BeanPropertyRowMapper<ChemicalInputRecord>(ChemicalInputRecord.class),preNum);
        return records;
    }

    @Override
    public Integer findFuzzyCount(String pattern) {
        pattern = "%" + pattern + "%";
        List<SpecialQueryResult> result = jdbcTemplate.query("select count(*) as count from chemical_input_record where input_person like ? or approver like ? or unit like ? or ch_name like ? or ch_type like ?",new BeanPropertyRowMapper<SpecialQueryResult>(SpecialQueryResult.class),pattern,pattern,pattern,pattern,pattern);
        if(result == null || result.size() != 1){
            throw new RuntimeException("模糊查询药品入库记录条数异常");
        }
        else{
            return result.get(0).getCount();
        }
    }

    @Override
    public List<ChemicalInputRecord> findFuzzyByPage(String pattern, Integer preNum) {
        pattern = "%" + pattern + "%";
        List<ChemicalInputRecord> records = jdbcTemplate.query("select * from chemical_input_record where input_person like ? or approver like ? or unit like ? or ch_name like ? or ch_type like ? limit ?,10",new BeanPropertyRowMapper<ChemicalInputRecord>(ChemicalInputRecord.class),pattern,pattern,pattern,pattern,pattern,preNum);
        return records;
    }

    @Override
    public Boolean insertChemicalInputRecord(ChemicalInputRecord chemicalInputRecord) {
        Integer result = jdbcTemplate.update("insert into chemical_input_record(input_time,useful_life,count,cabinet,input_person,approver,unit,ch_name,ch_type) values (?,?,?,?,?,?,?,?,?)",chemicalInputRecord.getInput_time(),chemicalInputRecord.getUseful_life(),chemicalInputRecord.getCount(),chemicalInputRecord.getCabinet(),chemicalInputRecord.getInput_person(),chemicalInputRecord.getApprover(),chemicalInputRecord.getUnit(),chemicalInputRecord.getCh_name(),chemicalInputRecord.getCh_type());
        return isSuccess(result,"插入药品入库记录时异常");
    }

    @Override
    public Boolean updateChemicalInputRecord(ChemicalInputRecord chemicalInputRecord) {
        Integer result = jdbcTemplate.update("update chemical_input_record set input_time=?,useful_life=?,count=?,cabinet=?,input_person=?,approver=?,unit=?,ch_name=?,ch_type=? where id=?",chemicalInputRecord.getInput_time(),chemicalInputRecord.getUseful_life(),chemicalInputRecord.getCount(),chemicalInputRecord.getCabinet(),chemicalInputRecord.getInput_person(),chemicalInputRecord.getApprover(),chemicalInputRecord.getUnit(),chemicalInputRecord.getCh_name(),chemicalInputRecord.getCh_type(),chemicalInputRecord.getId());
        return isSuccess(result,"更新药品入库记录时异常");
    }

    @Override
    public Boolean deleteChemicalInputRecord(Integer id) {
        Integer result = jdbcTemplate.update("delete from chemical_input_record where id=?",id);
        return isSuccess(result,"删除药品入库记录时异常");
    }

    public Boolean isSuccess(Integer result,String msg){
        if(result == 0){
            return false;
        }
        else if(result == 1){
            return true;
        }
        else{
            throw new RuntimeException(msg);
        }
    }
}
