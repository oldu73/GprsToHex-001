package com.company.util;

import org.junit.Test;

import static com.company.util.Builder.gprsCmd;
import static org.junit.Assert.*;

public class BuilderTest {

    @Test
    public void gprsCmdTest() {

        assertEquals(gprsCmd("getinfo"), "00000000000000110C010500000009676574696E666F0D0A010000DA7E");

        assertEquals(gprsCmd("setdigout 10"), "00000000000000160C01050000000E7365746469676F75742031300D0A0100001E59");

        assertEquals(gprsCmd("setdigout 01"), "00000000000000160C01050000000E7365746469676F75742030310D0A0100002265");

//        assertTrue(gprsCmd("setdigout 01").equalsIgnoreCase("00000000000000160C01050000000E7365746469676f75742030310D0A0100002265"));

    }

}
