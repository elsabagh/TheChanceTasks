package check

fun main() {
    check(
        name = "should return true when enter valid IPv4",
        result = checkIsValidIpv4("192.168.1.1"),
        correctResult = true
    )
    check(
        name = "should return false when enter IPv4 Out of range values",
        result = checkIsValidIpv4("192.168.1.999"),
        correctResult = false
    )
    check(
        name = "should return false when enter IPv4 Leading zeros in segments",
        result = checkIsValidIpv4("192.168.01.5"),
        correctResult = false
    )
    check(
        name = "should return false when enter IPv4 Missing segments",
        result = checkIsValidIpv4("192.168.1"),
        correctResult = false
    )
    check(
        name = "should return false when enter IPv4 extra segments",
        result = checkIsValidIpv4("1.192.168.1.1"),
        correctResult = false
    )
    check(
        name = "should return false when enter IPv4 Contains comma",
        result = checkIsValidIpv4("192,168,1,1"),
        correctResult = false
    )
    check(
        name = "should return false when enter IPv4 Empty",
        result = checkIsValidIpv4(""),
        correctResult = false
    )
    check(
        name = "should return false when enter IPv4 Contains non-numeric characters",
        result = checkIsValidIpv4("192.168.a.1"),
        correctResult = false
    )
}

fun checkIsValidIpv4(ip: String): Boolean {
    val segments = ip.split(".")

    for (segment in segments) {
        when {
            segment != "0" && segment.startsWith("0") -> return false
            segment.isEmpty() || segment.length > 3 -> return false
            segment.toIntOrNull() !in 0..255 -> return false
            segments.size != 4 -> return false
        }
    }

    return true
}

fun check(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("Pass - $name ")
    } else {
        println("Fail -$name")
    }
}
