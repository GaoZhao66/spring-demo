package com.cmb.updatefile.util;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public abstract class UUIDUtils {
    public UUIDUtils() {
    }

    public static String generator() {
        UUID uuid = UUID.randomUUID();
        String strUUID = uuid.toString().replace("-", "").toUpperCase();
        int lenStrUUID = strUUID.length();
        StringBuffer sb = new StringBuffer(strUUID);
        int halfStrUUID = lenStrUUID / 2;

        for(int i = 0; i < halfStrUUID; ++i) {
            int intX = ThreadLocalRandom.current().nextInt(lenStrUUID - 1);
            char cha = strUUID.charAt(intX);
            String low = null;
            if (!Character.isDigit(cha)) {
                low = (cha + "").toLowerCase();
                sb.replace(intX, intX + 1, low);
            }
        }

        return sb.toString();
    }
}
