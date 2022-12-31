package us.pinguo.inspire.module.profile;

import java.util.Locale;
import us.pinguo.inspire.Inspire;
/* loaded from: classes9.dex */
public class ProfileDiskCache extends us.pinguo.inspire.a0.c<ProfileEntry> {
    public static final String FILE_NAME = "profile_my_work_%s.json";

    /* JADX INFO: Access modifiers changed from: protected */
    public ProfileDiskCache(String str) {
        super(new us.pinguo.inspire.a0.d(Inspire.b(), getFileName(str)));
    }

    private static String getFileName(String str) {
        return String.format(Locale.US, FILE_NAME, str);
    }
}
