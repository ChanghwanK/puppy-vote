package kr.puppy.vote.auth.domain
import at.favre.lib.crypto.bcrypt.BCrypt

data class Authentication(
    val principal: String,
    private var _credential: String,
) {
    init {
        _credential = hash(_credential)
    }

    val credential: String
        get() =  _credential

    private fun hash(password: String) =
        BCrypt.withDefaults().hashToString(12, password.toCharArray())

    fun verify(password: String) =
        BCrypt.verifyer().verify(password.toCharArray(), _credential).verified
}