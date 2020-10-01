package managesystem.service;

import managesystem.entities.ChemicalOutputApply;
import managesystem.entities.logic.ResponseEntities;

import java.util.List;

public interface IChemicalOutputApplyService {
    ResponseEntities<Boolean> addApply(List<ChemicalOutputApply> applies);
}
