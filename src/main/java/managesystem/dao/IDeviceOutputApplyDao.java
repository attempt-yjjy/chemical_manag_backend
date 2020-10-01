package managesystem.dao;

import managesystem.entities.DeviceOutputApply;

import java.util.List;

public interface IDeviceOutputApplyDao {

    Integer findCount();
    List<DeviceOutputApply> findOnePage(Integer preNum);

    Boolean insertApply(DeviceOutputApply apply);
}
