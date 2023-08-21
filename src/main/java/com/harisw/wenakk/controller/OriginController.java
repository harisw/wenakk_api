package com.harisw.wenakk.controller;

import com.harisw.wenakk.dto.OriginResponse;
import com.harisw.wenakk.dto.RecipeResponse;
import com.harisw.wenakk.model.Origin;
import com.harisw.wenakk.model.Recipe;
import com.harisw.wenakk.service.OriginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Origin", description = "Origin/nation endpoints")
@RestController
@RequestMapping("/origin")
@RequiredArgsConstructor
public class OriginController {
    private final OriginService originService;

    @Operation(summary = "Retrieve all origins",
            description = "Get all origins collections in pagination",
            tags = {"Origin"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Origin.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<OriginResponse> getOrigins() {
        return originService.get();
    }

}
