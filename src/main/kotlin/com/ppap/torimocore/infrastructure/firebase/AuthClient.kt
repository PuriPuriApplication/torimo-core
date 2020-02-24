package com.ppap.torimocore.infrastructure.firebase

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseToken
import com.ppap.torimocore.domain.User.ServiceId
import org.springframework.stereotype.Component


@Component
class AuthClient {

    private val options: FirebaseOptions = FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.getApplicationDefault())
            .build()

    private val client: FirebaseAuth by lazy {
        FirebaseApp.initializeApp(options)
        FirebaseAuth.getInstance()
    }

    fun verify(idToken: String): ServiceId? {
        val token: FirebaseToken? = try {
            client.verifyIdToken(idToken)
        } catch (e: FirebaseAuthException) {
            null
        }
        return token?.let { it.uid };
    }
}
