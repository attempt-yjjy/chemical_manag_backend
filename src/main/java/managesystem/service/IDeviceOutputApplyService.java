package managesystem.service;

import managesystem.entities.DeviceOutputApply;
import managesystem.entities.logic.ResponseEntities;

import java.util.List;

public interface IDeviceOutputApplyService {
    ResponseEntities<Boolean> addApply(List<DeviceOutputApply> applies);
}
