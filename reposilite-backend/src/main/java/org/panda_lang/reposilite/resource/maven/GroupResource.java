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

package org.panda_lang.reposilite.resource.maven;

import org.panda_lang.reposilite.resource.AbstractResource;
import org.springframework.lang.Nullable;

import java.io.File;

final class GroupResource extends AbstractResource {

    GroupResource(File root, String name) {
        super(root, name);
    }

    public @Nullable
    ArtifactResource getArtifact(String artifactName) {
        return super.getMappedChildrenOfType(ArtifactResource.class).get(artifactName);
    }

}