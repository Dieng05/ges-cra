package diengDev.GesCRA.endpoints;

import diengDev.GesCRA.dtos.reponse.AssignmentResponse;
import diengDev.GesCRA.dtos.request.CreateAssignmentRequest;
import diengDev.GesCRA.dtos.request.UpdateAssignmentRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Tag(name = "Affectations", description = "Opérations liées aux affectations de missions")
@RequestMapping("/api/admin/assignments")
public interface AssignmentEndpoints extends CrudEndpoints<
        UUID,
        CreateAssignmentRequest,
        UpdateAssignmentRequest,
        AssignmentResponse> {
}