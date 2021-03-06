/*
 * Copyright (c) 2021 Hub Team of panda-lang organization
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

package org.panda_lang.hub.packages

import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.locations.post
import io.ktor.routing.Routing

@Location("/repositories/{owner}")
internal class RepositoriesLocation(val owner: String)

@Location("/packages/{owner}")
internal class PackagesLocation(val owner: String)

@Location("/package/{owner}/{name}")
internal class PackageLocation(val owner: String, val name: String)

@Location("/package/{owner}/{name}/versions")
internal class VersionsLocation(val owner: String, val name: String)

@Location("/package/{owner}/{name}/latest")
internal class LatestLocation(val owner: String, val name: String)

internal fun Routing.routes(packageEndpoint: PackageEndpoint) {
    get <RepositoriesLocation> { repositoriesLocation ->
        packageEndpoint.repositories(this.context, repositoriesLocation.owner)
    }
    get <PackagesLocation> { packagesLocation ->
        packageEndpoint.packages(this.context, packagesLocation.owner)
    }
    get <PackageLocation> { packageLocation ->
        packageEndpoint.`package`(this.context, packageLocation.owner, packageLocation.name)
    }
    post <PackageLocation> { packageEndpoint ->

    }
}
