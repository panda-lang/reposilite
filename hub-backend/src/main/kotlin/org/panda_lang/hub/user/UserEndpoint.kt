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

import io.ktor.application.ApplicationCall
import io.ktor.auth.jwt.JWTPrincipal
import io.ktor.http.HttpStatusCode
import org.panda_lang.hub.auth.jwt.getIdClaim
import org.panda_lang.hub.failure.ErrorResponse
import org.panda_lang.hub.utils.respondOr

internal class UserEndpoint(
    private val userFacade: UserFacade
) {

    suspend fun user(ctx: ApplicationCall, principal: JWTPrincipal) {
        userFacade.getUser(principal.getIdClaim()).respondOr(ctx) {
            ErrorResponse(HttpStatusCode.NotFound, "User not found")
        }
    }

    suspend fun user(ctx: ApplicationCall, login: String) {
        userFacade.getUserByLogin(login).respondOr(ctx) {
            ErrorResponse(HttpStatusCode.NotFound, "User not found")
        }
    }

}
