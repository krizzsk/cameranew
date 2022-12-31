package us.pinguo.inspire.model;

import java.util.List;
import java.util.Locale;
import us.pinguo.inspire.Inspire;
/* loaded from: classes9.dex */
public class MyWorksCache extends us.pinguo.inspire.a0.c<List<InspireWork>> {
    private static final String FILE_NAME_TPL = "inspire_my_works_%s_%s.json";

    public MyWorksCache(String str, String str2) {
        super(new us.pinguo.inspire.a0.d(Inspire.b(), genFileName(str, str2)));
    }

    private static String genFileName(String str, String str2) {
        return String.format(Locale.US, FILE_NAME_TPL, str, str2);
    }
}
