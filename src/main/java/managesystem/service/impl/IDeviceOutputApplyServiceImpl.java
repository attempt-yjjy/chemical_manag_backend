package managesystem.service.impl;

import managesystem.dao.IDeviceOutputApplyDao;
import managesystem.entities.DeviceOutputApply;
import managesystem.entities.logic.ResponseEntities;
import managesystem.service.IDeviceOutputApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iDeviceOutputApplyService")
public class IDeviceOutputApplyServiceImpl implements IDeviceOutputApplyService {

    @Autowired
    private IDeviceOutputApplyDao iDeviceOutputApplyDao;

    @Override
    public ResponseEntities<Boolean> addApply(List<DeviceOutputApply> applies) {
        for(DeviceOutputApply apply:applies) {
            Boolean result = iDeviceOutputApplyDao.insertApply(apply);
            if(!result){
                throw new RuntimeException("插入设备出库申请列表时异常");
            }
        }
        return new ResponseEntities<Boolean>(true,true,1);
    }
}
