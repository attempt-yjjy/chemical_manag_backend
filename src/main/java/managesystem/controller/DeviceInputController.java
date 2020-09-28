package managesystem.controller;

import managesystem.entities.ChemicalInputRecord;
import managesystem.entities.DeviceInputRecord;
import managesystem.entities.logic.ResponseEntities;
import managesystem.service.IDeviceInputRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeviceInputController {
    
    @Autowired
    private IDeviceInputRecordService iDeviceInputRecordService;

    @ResponseBody
    @RequestMapping("/device_input_record__all_count")
    public ResponseEntities<Integer> device_input_record__all_count(){
        return iDeviceInputRecordService.findAllCount();
    }

    @ResponseBody
    @RequestMapping("/device_input_record_one_page")
    public ResponseEntities<List<DeviceInputRecord>> device_input_record_one_page(Integer preNum){
        return iDeviceInputRecordService.findOnePage(preNum);
    }

    @ResponseBody
    @RequestMapping("/device_input_record_fuzzy_count")
    public ResponseEntities<Integer> device_input_record_fuzzy_count(String pattern){
        return iDeviceInputRecordService.findFuzzyCount(pattern);
    }

    @ResponseBody
    @RequestMapping("/device_input_record_fuzzy_one_page")
    public ResponseEntities<List<DeviceInputRecord>> device_input_record_fuzzy_one_page(String pattern,Integer preNum){
        return iDeviceInputRecordService.findFuzzyOnePage(pattern,preNum);
    }

    @ResponseBody
    @RequestMapping("/device_input_record_insert")
    public ResponseEntities<Boolean> device_input_record_insert(DeviceInputRecord deviceInputRecord){
        return iDeviceInputRecordService.insertDeviceInputRecord(deviceInputRecord);
    }
}
