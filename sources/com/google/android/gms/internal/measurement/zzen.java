package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzen implements zzer {
    private final ContentResolver zzc;
    private final Uri zzd;
    private final ContentObserver zze;
    private final Object zzf;
    private volatile Map<String, String> zzg;
    @GuardedBy("this")
    private final List<zzeo> zzh;
    @GuardedBy("ConfigurationContentLoader.class")
    private static final Map<Uri, zzen> zzb = new ArrayMap();
    public static final String[] zza = {"key", FirebaseAnalytics.Param.VALUE};

    private zzen(ContentResolver contentResolver, Uri uri) {
        zzem zzemVar = new zzem(this, null);
        this.zze = zzemVar;
        this.zzf = new Object();
        this.zzh = new ArrayList();
        Objects.requireNonNull(contentResolver);
        Objects.requireNonNull(uri);
        this.zzc = contentResolver;
        this.zzd = uri;
        contentResolver.registerContentObserver(uri, false, zzemVar);
    }

    public static zzen zza(ContentResolver contentResolver, Uri uri) {
        zzen zzenVar;
        synchronized (zzen.class) {
            Map<Uri, zzen> map = zzb;
            zzenVar = map.get(uri);
            if (zzenVar == null) {
                try {
                    zzen zzenVar2 = new zzen(contentResolver, uri);
                    try {
                        map.put(uri, zzenVar2);
                    } catch (SecurityException unused) {
                    }
                    zzenVar = zzenVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzenVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zzd() {
        synchronized (zzen.class) {
            for (zzen zzenVar : zzb.values()) {
                zzenVar.zzc.unregisterContentObserver(zzenVar.zze);
            }
            zzb.clear();
        }
    }

    public final Map<String, String> zzb() {
        Map<String, String> map;
        Map<String, String> map2 = this.zzg;
        if (map2 == null) {
            synchronized (this.zzf) {
                map2 = this.zzg;
                if (map2 == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        map = (Map) zzep.zza(new zzeq(this) { // from class: com.google.android.gms.internal.measurement.zzel
                            private final zzen zza;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.zza = this;
                            }

                            @Override // com.google.android.gms.internal.measurement.zzeq
                            public final Object zza() {
                                return this.zza.zzf();
                            }
                        });
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                    } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                        Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = null;
                    }
                    this.zzg = map;
                    map2 = map;
                }
            }
        }
        return map2 != null ? map2 : Collections.emptyMap();
    }

    public final void zzc() {
        synchronized (this.zzf) {
            this.zzg = null;
            zzfg.zzc();
        }
        synchronized (this) {
            for (zzeo zzeoVar : this.zzh) {
                zzeoVar.zza();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final /* bridge */ /* synthetic */ Object zze(String str) {
        return zzb().get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Map zzf() {
        Cursor query = this.zzc.query(this.zzd, zza, null, null, null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            Map arrayMap = count <= 256 ? new ArrayMap(count) : new HashMap(count, 1.0f);
            while (query.moveToNext()) {
                arrayMap.put(query.getString(0), query.getString(1));
            }
            return arrayMap;
        } finally {
            query.close();
        }
    }
}
