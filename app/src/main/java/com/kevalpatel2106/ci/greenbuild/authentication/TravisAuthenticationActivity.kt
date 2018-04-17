/*
 * Copyright 2018 Keval Patel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kevalpatel2106.ci.greenbuild.authentication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kevalpatel2106.ci.greenbuild.R
import com.kevalpatel2106.ci.greenbuild.base.account.Account
import com.kevalpatel2106.ci.greenbuild.base.account.AccountsManager
import com.kevalpatel2106.ci.greenbuild.base.application.BaseApplication
import com.kevalpatel2106.ci.greenbuild.base.ciInterface.ServerInterface
import com.kevalpatel2106.ci.greenbuild.di.DaggerDiComponent
import kotlinx.android.synthetic.main.activity_authentication.*
import javax.inject.Inject

/**
 * This [AppCompatActivity] will take the API access token and validate the token by calling for the
 * user profile. If the token is valid, application will redirect the user to display the list of
 * travis repository.
 *
 * @author <a href="https://github.com/kevalpatel2106">kevalpatel2106</a>
 */
class TravisAuthenticationActivity : AppCompatActivity() {

    @Inject
    lateinit var accountManager: AccountsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerDiComponent.builder()
                .applicationComponent(BaseApplication.get(this).getApplicationComponent())
                .build()
                .inject(this@TravisAuthenticationActivity)

        setContentView(R.layout.activity_authentication)

        authentication_btn.setOnClickListener {
            accountManager.saveAccount(Account(
                    userId = "2837",
                    username = "kevalpatel2106",
                    serverUrl = ServerInterface.TRAVIS_CI_ORG,
                    avatarUrl = null,
                    accessToken = "7286594356783645789",
                    name = "Keval Patel"
            ))
        }
    }
}
