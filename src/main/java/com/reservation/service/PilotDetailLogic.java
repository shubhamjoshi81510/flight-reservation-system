package com.reservation.service;

import com.reservation.entity.PilotDetail;
import com.reservation.model.PilotDetailReq;
import com.reservation.repository.PilotDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public class PilotDetailLogic {

    @Autowired
    private PilotDetailRepository pilotDetailRepository;

    public PilotDetail createNewPilot (PilotDetailReq pilotDetailReq){
        UUID uniqueId = UUID.randomUUID();
        PilotDetail pilotDetail = new PilotDetail();
        pilotDetail.setPilotName(pilotDetailReq.getPilotName());
        pilotDetail.setPilotId(uniqueId.toString());
        pilotDetail.setActive(true);
        pilotDetailRepository.save(pilotDetail);
        return pilotDetail;

    }
}
