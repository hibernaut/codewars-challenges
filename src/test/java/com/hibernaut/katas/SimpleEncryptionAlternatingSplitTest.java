package com.hibernaut.katas;

import static org.junit.Assert.*;
import org.junit.Test;

public class SimpleEncryptionAlternatingSplitTest {
    @Test
    public void testEncrypt() {
        // assertEquals("expected", "actual");
        assertEquals("This is a test!", SimpleEncryptionAlternatingSplit.encrypt("This is a test!", 0));
        assertEquals("hsi  etTi sats!", SimpleEncryptionAlternatingSplit.encrypt("This is a test!", 1));
        assertEquals("s eT ashi tist!", SimpleEncryptionAlternatingSplit.encrypt("This is a test!", 2));
        assertEquals(" Tah itse sits!", SimpleEncryptionAlternatingSplit.encrypt("This is a test!", 3));
        assertEquals("This is a test!", SimpleEncryptionAlternatingSplit.encrypt("This is a test!", 4));
        assertEquals("This is a test!", SimpleEncryptionAlternatingSplit.encrypt("This is a test!", -1));
        assertEquals("hskt svr neetn!Ti aai eyitrsig", SimpleEncryptionAlternatingSplit.encrypt("This kata is very interesting!", 1));
    }

    @Test
    public void testDecrypt() {
        // assertEquals("expected", "actual");
        assertEquals("This is a test!", SimpleEncryptionAlternatingSplit.decrypt("This is a test!", 0));
        assertEquals("This is a test!", SimpleEncryptionAlternatingSplit.decrypt("hsi  etTi sats!", 1));
        assertEquals("This is a test!", SimpleEncryptionAlternatingSplit.decrypt("s eT ashi tist!", 2));
        assertEquals("This is a test!", SimpleEncryptionAlternatingSplit.decrypt(" Tah itse sits!", 3));
        assertEquals("This is a test!", SimpleEncryptionAlternatingSplit.decrypt("This is a test!", 4));
        assertEquals("This is a test!", SimpleEncryptionAlternatingSplit.decrypt("This is a test!", -1));
        assertEquals("This kata is very interesting!", SimpleEncryptionAlternatingSplit.decrypt("hskt svr neetn!Ti aai eyitrsig", 1));
    }

    @Test
    public void testNullOrEmpty() {
        // assertEquals("expected", "actual");
        assertEquals("", SimpleEncryptionAlternatingSplit.encrypt("", 0));
        assertEquals("", SimpleEncryptionAlternatingSplit.decrypt("", 0));
        assertEquals(null, SimpleEncryptionAlternatingSplit.encrypt(null, 0));
        assertEquals(null, SimpleEncryptionAlternatingSplit.decrypt(null, 0));
    }
}