package ru.alyxe.time.data.repo.impl

fun <T> T?.require(name: String): T & Any {
    if (this == null) throw MissingRequiredFieldThrowable(name)
    else return this
}

class MissingRequiredFieldThrowable(
    name: String,
    override val message: String = "Required field is null $name",
) : Throwable()
