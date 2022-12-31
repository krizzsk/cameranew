package us.pinguo.common.pgdownloader.statistics;
/* loaded from: classes4.dex */
public interface DownloaderStat {
    public static final int BD_GIO = 5;

    void network_health_tracking_cost(String str, String str2, String str3, String str4, String str5);

    void network_health_tracking_error(String str, String str2, String str3, String str4, String str5);
}
