package us.pinguo.advsdk.utils;

import android.text.TextUtils;
import android.util.Log;
import us.pinguo.advsdk.PgAdvConstants$Mode;
import us.pinguo.advsdk.manager.PgAdvManager;
/* compiled from: AdvLog.java */
/* loaded from: classes3.dex */
public class b {
    public static void a(String str) {
        PgAdvConstants$Mode j2 = PgAdvManager.getInstance().j();
        PgAdvConstants$Mode pgAdvConstants$Mode = PgAdvConstants$Mode.MODE_RELEASE;
        if ((j2 == pgAdvConstants$Mode && PgAdvManager.getInstance().o() == pgAdvConstants$Mode) || TextUtils.isEmpty(str)) {
            return;
        }
        Log.e("PGadv", str);
    }

    public static void b(String str, String str2) {
        PgAdvConstants$Mode j2 = PgAdvManager.getInstance().j();
        PgAdvConstants$Mode pgAdvConstants$Mode = PgAdvConstants$Mode.MODE_RELEASE;
        if ((j2 == pgAdvConstants$Mode && PgAdvManager.getInstance().o() == pgAdvConstants$Mode) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        Log.e(str, str2);
    }
}
