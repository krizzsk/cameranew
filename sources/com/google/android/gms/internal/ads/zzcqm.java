package com.google.android.gms.internal.ads;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzug;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcqm {
    public static int zza(SQLiteDatabase sQLiteDatabase, int i2) {
        int i3 = 0;
        if (i2 == 2) {
            return 0;
        }
        Cursor zzc = zzc(sQLiteDatabase, i2);
        if (zzc.getCount() > 0) {
            zzc.moveToNext();
            i3 = 0 + zzc.getInt(zzc.getColumnIndexOrThrow(FirebaseAnalytics.Param.VALUE));
        }
        zzc.close();
        return i3;
    }

    public static ArrayList<zzug.zzo.zza> zzb(SQLiteDatabase sQLiteDatabase) {
        ArrayList<zzug.zzo.zza> arrayList = new ArrayList<>();
        Cursor query = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, null, null, null, null, null);
        while (query.moveToNext()) {
            try {
                arrayList.add(zzug.zzo.zza.zzg(query.getBlob(query.getColumnIndexOrThrow("serialized_proto_data"))));
            } catch (zzelo e2) {
                zzazk.zzev("Unable to deserialize proto from offline signals database:");
                zzazk.zzev(e2.getMessage());
            }
        }
        query.close();
        return arrayList;
    }

    private static Cursor zzc(SQLiteDatabase sQLiteDatabase, int i2) {
        String[] strArr = {FirebaseAnalytics.Param.VALUE};
        String[] strArr2 = new String[1];
        if (i2 == 0) {
            strArr2[0] = "failed_requests";
        } else if (i2 == 1) {
            strArr2[0] = "total_requests";
        } else if (i2 == 2) {
            strArr2[0] = "last_successful_request_time";
        }
        return sQLiteDatabase.query("offline_signal_statistics", strArr, "statistic_name = ?", strArr2, null, null, null);
    }

    public static long zzb(SQLiteDatabase sQLiteDatabase, int i2) {
        Cursor zzc = zzc(sQLiteDatabase, 2);
        long j2 = 0;
        if (zzc.getCount() > 0) {
            zzc.moveToNext();
            j2 = 0 + zzc.getLong(zzc.getColumnIndexOrThrow(FirebaseAnalytics.Param.VALUE));
        }
        zzc.close();
        return j2;
    }
}
