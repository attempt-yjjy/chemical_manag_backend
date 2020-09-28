package managesystem.service;

import managesystem.entities.DeviceInputRecord;
import managesystem.entities.logic.ResponseEntities;

import java.util.List;

public interface IDeviceInputRecordService {
    ResponseEntities<Integer> findAllCount();
    ResponseEntities<List<DeviceInputRecord>> findOnePage(Integer preNum);

    ResponseEntities<Integer> findFuzzyCount(String pattern);
    ResponseEntities<List<DeviceInputRecord>> findFuzzyOnePage(String pattern,Integer preNum);

    ResponseEntities<Boolean> insertDeviceInputRecord(DeviceInputRecord deviceInputRecord);
}
