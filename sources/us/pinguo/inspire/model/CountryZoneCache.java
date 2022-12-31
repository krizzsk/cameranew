package us.pinguo.inspire.model;

import us.pinguo.inspire.Inspire;
/* loaded from: classes9.dex */
public class CountryZoneCache extends us.pinguo.inspire.a0.c<String> {
    public static final String FILE_NAME = "country_zone_cache.json";
    public static final String FILE_PATH_SUFFIX = "/zoneCache";

    public CountryZoneCache() {
        super(new us.pinguo.inspire.a0.d(Inspire.a().getFilesDir() + FILE_PATH_SUFFIX, FILE_NAME));
    }
}
