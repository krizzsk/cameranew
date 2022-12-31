package us.pinguo.share.core;
/* loaded from: classes6.dex */
public class PGShareConfiguration {
    private static String SITE = "Camera360";
    private static String SITE_URL = "http://www.camera360.com/production/?production=camera360&platform=android";

    public static String getSite() {
        return SITE;
    }

    public static String getSiteUrl() {
        return SITE_URL;
    }

    public static void setSite(String str) {
        SITE = str;
    }

    public static void setSiteUrl(String str) {
        SITE_URL = str;
    }
}
