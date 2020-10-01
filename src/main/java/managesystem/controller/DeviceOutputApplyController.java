package managesystem.controller;

import managesystem.entities.DeviceOutputApply;
import managesystem.entities.logic.ResponseEntities;
import managesystem.service.IDeviceOutputApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/device_apply")
public class DeviceOutputApplyController {
    @Autowired
    private IDeviceOutputApplyService iDeviceOutputApplyService;

    @RequestMapping("/submit_apply")
    @ResponseBody
    public ResponseEntities<Boolean> submit_apply(List<DeviceOutputApply> applies){

        return iDeviceOutputApplyService.addApply(applies);
    }
}
