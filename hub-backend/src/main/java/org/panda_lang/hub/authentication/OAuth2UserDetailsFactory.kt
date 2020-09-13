/*
 * Copyright (c) 2020 Hub Team of panda-lang organization
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
package org.panda_lang.hub.authentication

object OAuth2UserDetailsFactory {

    fun obtainOAuth2UserDetails(providerName: String?, attributes: Map<String, Any>): OAuth2UserDetails {
        return if ("github".equals(providerName, ignoreCase = true)) {
            GithubOAuth2UserDetails(attributes)
        } else {
            throw UnsupportedOperationException()
        }
    }

}