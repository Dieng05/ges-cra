package diengDev.GesCRA.endpoints;

import diengDev.GesCRA.dtos.reponse.MissionResponse;
import diengDev.GesCRA.dtos.request.CreateMissionRequest;
import diengDev.GesCRA.dtos.request.UpdateMissionRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Tag(name = "Missions", description = "Opérations liées aux missions")
@RequestMapping("/api/admin/missions")
public interface MissionEndpoints extends CrudEndpoints<
        UUID,
        CreateMissionRequest,
        UpdateMissionRequest,
        MissionResponse> {
}