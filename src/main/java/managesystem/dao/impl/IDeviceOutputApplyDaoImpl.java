package managesystem.dao.impl;

import managesystem.entities.DeviceOutputApply;
import managesystem.dao.IDeviceOutputApplyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("iDeviceOutputApplyDao")
public class IDeviceOutputApplyDaoImpl implements IDeviceOutputApplyDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer findCount() {
        return null;
    }

    @Override
    public List<DeviceOutputApply> findOnePage(Integer preNum) {
        return null;
    }

    @Override
    public Boolean insertApply(DeviceOutputApply apply) {
        Integer result = jdbcTemplate.update("insert into device_output_apply(de_name,de_type,count,output_time,proposer,pro_id) values(?,?,?,?,?,?)",apply.getDe_name(),apply.getDe_type(),apply.getCount(),apply.getOutput_time(),apply.getProposer(),apply.getPro_id());
        if(result == 1){
            return true;
        }
        else if(result == 0){
            return false;
        }
        else{
            throw new RuntimeException("插入设备出库申请时受影响的数据项数异常!");
        }
    }
}
