package com.coding.challenge.marvel.utils;

import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class MarvelUtils {

    /**
     * Create hash
     * @param value
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String createHash(String value) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(value.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return myHash;
    }

}
