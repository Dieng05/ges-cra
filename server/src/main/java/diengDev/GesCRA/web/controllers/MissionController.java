package diengDev.GesCRA.web.controllers;

import diengDev.GesCRA.domain.services.MissionService;
import diengDev.GesCRA.dtos.request.CreateMissionRequest;
import diengDev.GesCRA.dtos.request.UpdateMissionRequest;
import diengDev.GesCRA.dtos.reponse.MissionResponse;
import diengDev.GesCRA.endpoints.MissionEndpoints;
import diengDev.GesCRA.web.mappers.MissionWebMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MissionController implements MissionEndpoints {

    private final MissionService missionService;
    private final MissionWebMapper missionWebMapper;

    @Override
    public MissionResponse create(@Valid CreateMissionRequest request) {
        return missionWebMapper.toResponse(
                missionService.creerMission(
                        missionWebMapper.toModel(request)
                )
        );
    }

    @Override
    public List<MissionResponse> findAll() {
        return missionService.listerMissions()
                .stream()
                .map(missionWebMapper::toResponse)
                .toList();
    }

    @Override
    public MissionResponse findById(UUID id) {
        return missionWebMapper.toResponse(
                missionService.getMission(id)
        );
    }

    @Override
    public MissionResponse update(UUID id, @Valid UpdateMissionRequest request) {
        return missionWebMapper.toResponse(
                missionService.modifierMission(id, missionWebMapper.toModel(request))
        );
    }

    @Override
    public void delete(UUID id) {
        missionService.supprimerMission(id);
    }
}