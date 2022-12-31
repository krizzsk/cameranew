package us.pinguo.inspire.module.profile;

import java.util.Locale;
import us.pinguo.inspire.Inspire;
/* loaded from: classes4.dex */
public class ProfileLocationResourceCache extends us.pinguo.inspire.a0.c<String> {
    public static final String FILE_NAME = "profile_location_resourse_%s.json";

    /* JADX INFO: Access modifiers changed from: protected */
    public ProfileLocationResourceCache(String str) {
        super(new us.pinguo.inspire.a0.d(Inspire.b(), getFileName(str)));
    }

    private static String getFileName(String str) {
        return String.format(Locale.US, FILE_NAME, str);
    }
}
