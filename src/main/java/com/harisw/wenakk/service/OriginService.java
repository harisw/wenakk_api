package com.harisw.wenakk.service;

import com.harisw.wenakk.dto.OriginResponse;
import com.harisw.wenakk.model.Origin;
import com.harisw.wenakk.repository.OriginRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OriginService {
    private final OriginRepository originRepository;

    public List<OriginResponse> get() {
        List<Origin> origins = originRepository.findAll();
        return origins.stream().map(this::mapToOriginResponse).toList();
    }

    public OriginResponse get(Integer id) {
        Optional<Origin> origin = originRepository.findById(id);
        return origin.map(this::mapToOriginResponse).orElse(null);
    }

    private OriginResponse mapToOriginResponse(Origin origin) {
        return OriginResponse.builder().
                id(origin.getId())
                .name(origin.getName())
                .build();
    }

}
