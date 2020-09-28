package managesystem.service.impl;

import managesystem.dao.IDeviceInputRecordDao;
import managesystem.entities.DeviceInputRecord;
import managesystem.entities.logic.ResponseEntities;
import managesystem.service.IDeviceInputRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iDeviceInputRecordService")
public class IDeviceInputRecordServiceImpl implements IDeviceInputRecordService {

    @Autowired
    private IDeviceInputRecordDao iDeviceInputRecordDao;

    @Override
    public ResponseEntities<Integer> findAllCount() {
        return new ResponseEntities<Integer>(true,iDeviceInputRecordDao.findCount(),1);
    }

    @Override
    public ResponseEntities<List<DeviceInputRecord>> findOnePage(Integer preNum) {
        List<DeviceInputRecord> records = iDeviceInputRecordDao.findByPage(preNum);
        return new ResponseEntities<List<DeviceInputRecord>>(true,records,1);
    }

    @Override
    public ResponseEntities<Integer> findFuzzyCount(String pattern) {
        return new ResponseEntities<Integer>(true,iDeviceInputRecordDao.findFuzzyCount(pattern),1);
    }

    @Override
    public ResponseEntities<List<DeviceInputRecord>> findFuzzyOnePage(String pattern, Integer preNum) {
        List<DeviceInputRecord> records = iDeviceInputRecordDao.findFuzzyByPage(pattern,preNum);
        return new ResponseEntities<List<DeviceInputRecord>>(true,records,1);
    }
}
