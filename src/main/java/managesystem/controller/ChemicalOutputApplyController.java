package managesystem.controller;

import managesystem.entities.ChemicalOutputApply;
import managesystem.entities.logic.ResponseEntities;
import managesystem.service.IChemicalOutputApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/chemical_apply")
public class ChemicalOutputApplyController {

    @Autowired
    private IChemicalOutputApplyService iChemicalOutputApplyService;

    @ResponseBody
    @RequestMapping("/submit_apply")
    public ResponseEntities<Boolean> submit_apply(@RequestBody List<ChemicalOutputApply> applies){
        return iChemicalOutputApplyService.addApply(applies);
    }
}
