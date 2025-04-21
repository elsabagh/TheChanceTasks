package check

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class CheckIpv4Test {

    @Test
    fun `should return true when enter valid IPv4`() {
        val iptv4 = "192.168.1.1"
        val result = checkIsValidIpv4(iptv4)
        assertTrue(result)
    }
    @Test
    fun `should return false when enter IPv4 Out of range values`() {
        val iptv4 = "192.168.1.999"
        val result = checkIsValidIpv4(iptv4)
        assertFalse(result)
    }
    @Test
    fun `should return false when enter IPv4 Leading zeros in segments`() {
        val iptv4 = "192.168.01.5"
        val result = checkIsValidIpv4(iptv4)
        assertFalse(result)
    }
    @Test
    fun `should return false when enter IPv4 Missing segments`() {
        val iptv4 = "192.168.1"
        val result =  checkIsValidIpv4(iptv4)
        assertFalse(result)
    }
    @Test
    fun `should return false when enter IPv4 extra segments`() {
        val iptv4 = "1.192.168.1.1"
        val result = checkIsValidIpv4(iptv4)
        assertFalse(result)
    }
    @Test
    fun `should return false when enter IPv4 Contains comma`() {
        val iptv4 = "192,168,1,1"
        val result = checkIsValidIpv4(iptv4)
        assertFalse(result)
    }
    @Test
    fun `should return false when enter IPv4 Empty`() {
        val iptv4 = ""
        val result = checkIsValidIpv4(iptv4)
        assertFalse(result)
    }
    @Test
    fun `should return false when enter IPv4 Contains non-numeric characters`() {
        val iptv4 = "192.168.a.1"
        val result = checkIsValidIpv4(iptv4)
        assertFalse(result)
    }

}