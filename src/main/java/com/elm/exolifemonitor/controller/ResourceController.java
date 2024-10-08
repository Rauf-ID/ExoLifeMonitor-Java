/*
 * This file is part of ExoLifeMonitor-Java.
 *
 * ExoLifeMonitor-Java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ExoLifeMonitor-Java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with ExoLifeMonitor-Java.  If not, see <https://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2024 Rauf Agaguliev
 */

package com.elm.exolifemonitor.controller;

import com.elm.exolifemonitor.dto.ResourcesDTO;
import com.elm.exolifemonitor.mapper.ResourceMapper;
import com.elm.exolifemonitor.model.Resources;
import com.elm.exolifemonitor.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ResourceMapper resourcesMapper;

    @GetMapping
    public List<ResourcesDTO> getAllResources() {
        List<Resources> resources = resourceService.getAllResources();
        return resources.stream()
                .map(resourcesMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/station/{stationId}")
    public List<ResourcesDTO> getResourcesByStation(@PathVariable Long stationId) {
        List<Resources> resources = resourceService.getResourcesByStation(stationId);
        return resources.stream()
                .map(resourcesMapper::toDTO)
                .collect(Collectors.toList());
    }

}
