package diengDev.GesCRA.web.controllers;

import diengDev.GesCRA.domain.services.AssignmentService;
import diengDev.GesCRA.dtos.request.CreateAssignmentRequest;
import diengDev.GesCRA.dtos.request.UpdateAssignmentRequest;
import diengDev.GesCRA.dtos.reponse.AssignmentResponse;
import diengDev.GesCRA.endpoints.AssignmentEndpoints;
import diengDev.GesCRA.web.mappers.AssignmentWebMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AssignmentController implements AssignmentEndpoints {

    private final AssignmentService assignmentService;
    private final AssignmentWebMapper assignmentWebMapper;

    @Override
    public AssignmentResponse create(@Valid CreateAssignmentRequest request) {
        return assignmentWebMapper.toResponse(
                assignmentService.affecterMission(
                        assignmentWebMapper.toModel(request)
                )
        );
    }

    @Override
    public List<AssignmentResponse> findAll() {
        return assignmentService.listerAffectations()
                .stream()
                .map(assignmentWebMapper::toResponse)
                .toList();
    }

    @Override
    public AssignmentResponse findById(UUID id) {
        return assignmentWebMapper.toResponse(
                assignmentService.getAssignment(id)
        );
    }

    @Override
    public AssignmentResponse update(UUID id, @Valid UpdateAssignmentRequest request) {
        return assignmentWebMapper.toResponse(
                assignmentService.modifierAssignment(id, assignmentWebMapper.toModel(request))
        );
    }

    @Override
    public void delete(UUID id) {
        assignmentService.supprimerAssignment(id);
    }


}