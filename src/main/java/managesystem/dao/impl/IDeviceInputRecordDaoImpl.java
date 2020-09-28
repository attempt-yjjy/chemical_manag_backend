package managesystem.dao.impl;

import managesystem.dao.IDeviceInputRecordDao;
import managesystem.entities.DeviceInputRecord;
import managesystem.entities.logic.SpecialQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("iDeviceInputRecordDao")
public class IDeviceInputRecordDaoImpl implements IDeviceInputRecordDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<DeviceInputRecord> findAll() {
        return jdbcTemplate.query("select * from device_input_record",new BeanPropertyRowMapper<DeviceInputRecord>(DeviceInputRecord.class));
    }

    @Override
    public Integer findCount() {
        List<SpecialQueryResult> result = jdbcTemplate.query("select count(*) as count from device_input_record",new BeanPropertyRowMapper<SpecialQueryResult>(SpecialQueryResult.class));
        if(result == null || result.size() != 1){
            throw new RuntimeException("查询设备入库记录总条数异常");
        }
        else{
            return result.get(0).getCount();
        }
    }

    @Override
    public List<DeviceInputRecord> findByPage(Integer preNum) {
        List<DeviceInputRecord> records = jdbcTemplate.query("select * from chemical_input_record limit ?,10",new BeanPropertyRowMapper<DeviceInputRecord>(DeviceInputRecord.class),preNum);
        return records;
    }

    @Override
    public Integer findFuzzyCount(String pattern) {
        pattern = "%" + pattern + "%";
        List<SpecialQueryResult> result = jdbcTemplate.query("select count(*) as count from device_input_record where input_person like ? or approver like ? or unit like ? or de_name like ? or de_type like ?",new BeanPropertyRowMapper<SpecialQueryResult>(SpecialQueryResult.class),pattern,pattern,pattern,pattern,pattern);
        if(result == null || result.size() != 1){
            throw new RuntimeException("模糊查询设备入库记录条数异常");
        }
        else{
            return result.get(0).getCount();
        }
    }

    @Override
    public List<DeviceInputRecord> findFuzzyByPage(String pattern, Integer preNum) {
        pattern = "%" + pattern + "%";
        List<DeviceInputRecord> records = jdbcTemplate.query("select * from device_input_record where input_person like ? or approver like ? or unit like ? or de_name like ? or de_type like ? limit ?,10",new BeanPropertyRowMapper<DeviceInputRecord>(DeviceInputRecord.class),pattern,pattern,pattern,pattern,pattern,preNum);
        return records;
    }

    @Override
    public Boolean insertDeviceInputRecord(DeviceInputRecord deviceInputRecord) {
        Integer result = jdbcTemplate.update("insert into device_input_record(input_time,count,cabinet,input_person,approver,unit,de_name,de_type) values (?,?,?,?,?,?,?,?)",deviceInputRecord.getInput_time(),deviceInputRecord.getCount(),deviceInputRecord.getCabinet(),deviceInputRecord.getInput_person(),deviceInputRecord.getApprover(),deviceInputRecord.getUnit(),deviceInputRecord.getDe_name(),deviceInputRecord.getDe_type());
        return isSuccess(result,"插入设备入库记录时异常");
    }

    @Override
    public Boolean updateDeviceInputRecord(DeviceInputRecord deviceInputRecord) {
        Integer result = jdbcTemplate.update("update device_input_record set input_time=?,count=?,cabinet=?,input_person=?,approver=?,unit=?,de_name=?,de_type=? where id=?",deviceInputRecord.getInput_time(),deviceInputRecord.getCount(),deviceInputRecord.getCabinet(),deviceInputRecord.getInput_person(),deviceInputRecord.getApprover(),deviceInputRecord.getUnit(),deviceInputRecord.getDe_name(),deviceInputRecord.getDe_type(),deviceInputRecord.getId());
        return isSuccess(result,"更新设备入库记录时异常");
    }

    @Override
    public Boolean deleteDeviceInputRecord(Integer id) {
        Integer result = jdbcTemplate.update("delete from device_input_record where id=?",id);
        return isSuccess(result,"删除设备入库记录时异常");
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
