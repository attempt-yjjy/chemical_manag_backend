package managesystem.dao;

import managesystem.entities.DeviceInputRecord;

import java.util.List;

public interface IDeviceInputRecordDao {
    List<DeviceInputRecord> findAll();

    Integer findCount();
    List<DeviceInputRecord> findByPage(Integer preNum);

    Integer findFuzzyCount(String pattern);
    List<DeviceInputRecord> findFuzzyByPage(String pattern,Integer preNum);

    Boolean insertDeviceInputRecord(DeviceInputRecord deviceInputRecord);

    Boolean updateDeviceInputRecord(DeviceInputRecord deviceInputRecord);

    Boolean deleteDeviceInputRecord(Integer id);
}

