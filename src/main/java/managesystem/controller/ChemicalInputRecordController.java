package managesystem.controller;

import managesystem.entities.ChemicalInputRecord;
import managesystem.entities.logic.ResponseEntities;
import managesystem.service.IChemicalInputRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChemicalInputRecordController {
    @Autowired
    private IChemicalInputRecordService iChemicalInputRecordService;

    @ResponseBody
    @RequestMapping("/chemical_input_record__all_count")
    public ResponseEntities<Integer> chemical_input_record__all_count(){
        return iChemicalInputRecordService.findAllCount();
    }

    @ResponseBody
    @RequestMapping("/chemical_input_record_one_page")
    public ResponseEntities<List<ChemicalInputRecord>> chemical_input_record_one_page(Integer preNum){
        return iChemicalInputRecordService.findOnePage(preNum);
    }

    @ResponseBody
    @RequestMapping("/chemical_input_record_fuzzy_count")
    public ResponseEntities<Integer> chemical_input_record_fuzzy_count(String pattern){
        return iChemicalInputRecordService.findFuzzyCount(pattern);
    }

    @ResponseBody
    @RequestMapping("/chemical_input_record_fuzzy_one_page")
    public ResponseEntities<List<ChemicalInputRecord>> chemical_input_record_fuzzy_one_page(String pattern,Integer preNum){
        return iChemicalInputRecordService.findFuzzyOnePage(pattern,preNum);
    }
}
