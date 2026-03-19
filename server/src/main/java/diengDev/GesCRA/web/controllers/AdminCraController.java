package diengDev.GesCRA.web.controllers;

import diengDev.GesCRA.domain.services.CraService;
import diengDev.GesCRA.dtos.request.DecisionCraRequest;
import diengDev.GesCRA.dtos.reponse.CraResponse;
import diengDev.GesCRA.endpoints.AdminCraEndpoints;
import diengDev.GesCRA.web.mappers.CraWebMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AdminCraController implements AdminCraEndpoints {

    private final CraService craService;
    private final CraWebMapper craWebMapper;

    @Override
    public List<CraResponse> findAll() {
        return craService.listerCra()
                .stream()
                .map(craWebMapper::toResponse)
                .toList();
    }

    @Override
    public CraResponse approve(UUID id) {
        return craWebMapper.toResponse(
                craService.validerCra(id)
        );
    }

    @Override
    public CraResponse reject(UUID id, @Valid DecisionCraRequest request) {
        return craWebMapper.toResponse(
                craService.rejeterCra(id, request.motif())
        );
    }

    @Override
    public CraResponse invalidate(UUID id, @Valid DecisionCraRequest request) {
        return craWebMapper.toResponse(
                craService.invaliderCra(id, request.motif())
        );
    }
}