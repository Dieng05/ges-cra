package diengDev.GesCRA.domain.services;

import diengDev.GesCRA.domain.dataports.AssignmentDataPort;
import diengDev.GesCRA.domain.models.AssignmentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentDataPort assignmentDataPort;

    public AssignmentModel affecterMission(AssignmentModel assignment) {
        return assignmentDataPort.save(assignment);
    }

    public List<AssignmentModel> listerAffectations() {
        return assignmentDataPort.findAll();
    }

    public AssignmentModel getAssignment(UUID id) {
        return assignmentDataPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Affectation introuvable"));
    }

    public void supprimerAssignment(UUID id) {
        assignmentDataPort.deleteById(id);
    }

    public AssignmentModel modifierAssignment(UUID id, AssignmentModel assignment) {
        AssignmentModel existing = assignmentDataPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Affectation introuvable"));

        assignment.setId(existing.getId());
        return assignmentDataPort.save(assignment);
    }
}