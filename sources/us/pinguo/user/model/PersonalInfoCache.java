package us.pinguo.user.model;

import java.util.Locale;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.a0.c;
import us.pinguo.inspire.a0.d;
/* loaded from: classes6.dex */
public class PersonalInfoCache extends c<ProfileEntry> {
    public static final String FILE_NAME = "profile_person_info_%s.json";

    public PersonalInfoCache(String str) {
        super(new d(Inspire.b(), getFileName(str)));
    }

    private static String getFileName(String str) {
        return String.format(Locale.US, FILE_NAME, str);
    }
}
