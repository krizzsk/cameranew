package us.pinguo.inspire.module.profile;

import java.util.Locale;
import us.pinguo.inspire.Inspire;
/* loaded from: classes4.dex */
public class LocationCodeResourceCache extends us.pinguo.inspire.a0.c<String> {
    public static final String FILE_NAME = "location_code_resource_%s.json";

    /* JADX INFO: Access modifiers changed from: protected */
    public LocationCodeResourceCache(String str) {
        super(new us.pinguo.inspire.a0.d(Inspire.b(), getFileName(str)));
    }

    private static String getFileName(String str) {
        return String.format(Locale.US, FILE_NAME, str);
    }
}
