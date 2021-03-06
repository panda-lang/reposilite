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

package org.panda_lang.hub.user

import io.ktor.application.call
import io.ktor.auth.authenticate
import io.ktor.auth.authentication
import io.ktor.auth.jwt.JWTPrincipal
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.routing.Routing

@Location("/user")
internal class UserLocation

@Location("/profile/{name}")
internal class ProfileLocation(val name: String)

internal fun Routing.routes(userEndpoint: UserEndpoint) {
    authenticate("jwt") {
        get <UserLocation> {
            call.authentication.principal<JWTPrincipal>()?.let {
                userEndpoint.user(this.context, it)
            }
        }
    }
    get <ProfileLocation> { profile ->
        userEndpoint.user(this.context, profile.name)
    }
}
