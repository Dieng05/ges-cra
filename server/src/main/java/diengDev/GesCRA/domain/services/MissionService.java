package diengDev.GesCRA.domain.services;

import diengDev.GesCRA.domain.dataports.MissionDataPort;
import diengDev.GesCRA.domain.models.MissionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionDataPort missionDataPort;

    public MissionModel creerMission(MissionModel mission) {
        return missionDataPort.save(mission);
    }

    public MissionModel modifierMission(UUID id, MissionModel mission) {

        MissionModel existing = missionDataPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Mission introuvable"));

        mission.setId(existing.getId());

        return missionDataPort.save(mission);
    }

    public List<MissionModel> listerMissions() {
        return missionDataPort.findAll();
    }

    public MissionModel getMission(UUID id) {
        return missionDataPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Mission introuvable"));
    }

    public void supprimerMission(UUID id) {
        missionDataPort.deleteById(id);
    }
}