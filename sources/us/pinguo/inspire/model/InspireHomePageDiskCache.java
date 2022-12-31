package us.pinguo.inspire.model;

import java.util.Locale;
import us.pinguo.inspire.Inspire;
/* loaded from: classes9.dex */
public class InspireHomePageDiskCache extends us.pinguo.inspire.a0.c<InspirePersonalCenterInfo> {
    public static final String FILE_NAME = "inspire_home_page_%s.json";

    public InspireHomePageDiskCache(String str) {
        super(new us.pinguo.inspire.a0.d(Inspire.b(), getFileName(str)));
    }

    private static String getFileName(String str) {
        return String.format(Locale.US, FILE_NAME, str);
    }
}
