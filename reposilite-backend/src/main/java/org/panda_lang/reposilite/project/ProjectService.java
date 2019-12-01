/*
 * Copyright (c) 2018-2019 Reposilite Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.reposilite.project;

import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.entity.AbstractCrudOperationService;
import org.panda_lang.reposilite.utils.entity.CrudOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ProjectService extends AbstractCrudOperationService<ProjectRepository, Project, ObjectId> implements CrudOperationsService<Project, ObjectId> {

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        super(projectRepository);
    }

    public List<Project> findAllByOwnerName(String name) {
        return super.getRepository().findAllByOwnerName(name);
    }

    public Page<Project> findAll(Pageable pageable) {
        return super.getRepository().findAll(pageable);
    }

    public long count() {
        return super.getRepository().count();
    }

}
