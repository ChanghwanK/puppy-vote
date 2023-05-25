package kr.puppy.vote.auth.entity

import kr.puppy.vote.BaseEntity
import javax.persistence.*

@Entity
@Table(
    name = "authentications",
    indexes = [Index(name = "uq_email", columnList = "email", unique = true)]
)
class AuthenticationJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    @Column(name = "email", nullable = false)
    val principal: String,
    @Column(name = "password", nullable = false)
    val credential: String,
) : BaseEntity()