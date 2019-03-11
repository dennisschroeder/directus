@file:Suppress("SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection")

package com.directus.jwt

import java.util.*
import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm

@Suppress("SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection")
object DirectusJWT {
    private const val secret = "aksdjw390dsfasdköasdköalsdkasöld"
    private const val validityInMs = 36_000_00 * 1 // 1 hour
    private val algorithm: Algorithm = Algorithm.HMAC256(secret)
    val verifier: JWTVerifier = JWT.require(algorithm).build()

    fun sign(name: String): String = JWT.create()
        .withClaim("name", name)
        .withExpiresAt(getExpiration())
        .sign(algorithm)

    private fun getExpiration() = Date(System.currentTimeMillis() + validityInMs)
}
