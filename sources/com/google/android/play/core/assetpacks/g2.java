package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.play.core.common.LocalTestingException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.common.network.common.header.PGTransHeader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class g2 implements x3 {

    /* renamed from: h  reason: collision with root package name */
    private static final com.google.android.play.core.internal.j f4738h = new com.google.android.play.core.internal.j("FakeAssetPackService");

    /* renamed from: i  reason: collision with root package name */
    private static final AtomicInteger f4739i = new AtomicInteger(1);
    private final String a;
    private final e0 b;
    private final f1 c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f4740d;

    /* renamed from: e  reason: collision with root package name */
    private final t2 f4741e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.play.core.internal.k1<Executor> f4742f;

    /* renamed from: g  reason: collision with root package name */
    private final Handler f4743g = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    public g2(File file, e0 e0Var, f1 f1Var, Context context, t2 t2Var, com.google.android.play.core.internal.k1<Executor> k1Var) {
        this.a = file.getAbsolutePath();
        this.b = e0Var;
        this.c = f1Var;
        this.f4740d = context;
        this.f4741e = t2Var;
        this.f4742f = k1Var;
    }

    static long e(int i2, long j2) {
        if (i2 != 2) {
            if (i2 == 3 || i2 == 4) {
                return j2;
            }
            return 0L;
        }
        return j2 / 2;
    }

    private final AssetPackState f(String str, int i2) throws LocalTestingException {
        long j2 = 0;
        for (File file : m(str)) {
            j2 += file.length();
        }
        return AssetPackState.b(str, i2, 0, e(i2, j2), j2, this.c.c(str));
    }

    private static String g(File file) throws LocalTestingException {
        try {
            return j2.b(Arrays.asList(file));
        } catch (IOException e2) {
            throw new LocalTestingException(String.format("Could not digest file: %s.", file), e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new LocalTestingException("SHA256 algorithm not supported.", e3);
        }
    }

    private final void h(int i2, String str, int i3) throws LocalTestingException {
        Bundle bundle = new Bundle();
        bundle.putInt("app_version_code", this.f4741e.a());
        bundle.putInt(TapjoyConstants.TJC_SESSION_ID, i2);
        File[] m = m(str);
        ArrayList<String> arrayList = new ArrayList<>();
        long j2 = 0;
        for (File file : m) {
            j2 += file.length();
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
            arrayList2.add(i3 == 3 ? new Intent().setData(Uri.EMPTY) : null);
            String b = com.google.android.play.core.internal.y.b(file);
            bundle.putParcelableArrayList(com.google.android.play.core.internal.p1.g("chunk_intents", str, b), arrayList2);
            bundle.putString(com.google.android.play.core.internal.p1.g("uncompressed_hash_sha256", str, b), g(file));
            bundle.putLong(com.google.android.play.core.internal.p1.g("uncompressed_size", str, b), file.length());
            arrayList.add(b);
        }
        bundle.putStringArrayList(com.google.android.play.core.internal.p1.f("slice_ids", str), arrayList);
        bundle.putLong(com.google.android.play.core.internal.p1.f("pack_version", str), this.f4741e.a());
        bundle.putInt(com.google.android.play.core.internal.p1.f("status", str), i3);
        bundle.putInt(com.google.android.play.core.internal.p1.f("error_code", str), 0);
        bundle.putLong(com.google.android.play.core.internal.p1.f("bytes_downloaded", str), e(i3, j2));
        bundle.putLong(com.google.android.play.core.internal.p1.f("total_bytes_to_download", str), j2);
        bundle.putStringArrayList("pack_names", new ArrayList<>(Arrays.asList(str)));
        bundle.putLong("bytes_downloaded", e(i3, j2));
        bundle.putLong("total_bytes_to_download", j2);
        final Intent putExtra = new Intent("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE").putExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE", bundle);
        this.f4743g.post(new Runnable(this, putExtra) { // from class: com.google.android.play.core.assetpacks.f2
            private final g2 a;
            private final Intent b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = putExtra;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.i(this.b);
            }
        });
    }

    private final File[] m(final String str) throws LocalTestingException {
        File file = new File(this.a);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles(new FilenameFilter(str) { // from class: com.google.android.play.core.assetpacks.e2
                private final String a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = str;
                }

                @Override // java.io.FilenameFilter
                public final boolean accept(File file2, String str2) {
                    return str2.startsWith(String.valueOf(this.a).concat(PGTransHeader.CONNECTOR)) && str2.endsWith(".apk");
                }
            });
            if (listFiles != null) {
                if (listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        if (com.google.android.play.core.internal.y.b(file2).equals(str)) {
                            return listFiles;
                        }
                    }
                    throw new LocalTestingException(String.format("No master slice available for pack '%s'.", str));
                }
                throw new LocalTestingException(String.format("No APKs available for pack '%s'.", str));
            }
            throw new LocalTestingException(String.format("Failed fetching APKs for pack '%s'.", str));
        }
        throw new LocalTestingException(String.format("Local testing directory '%s' not found.", file));
    }

    @Override // com.google.android.play.core.assetpacks.x3
    public final com.google.android.play.core.tasks.d<e> a(final List<String> list, final List<String> list2, Map<String, Long> map) {
        f4738h.f("startDownload(%s)", list2);
        final com.google.android.play.core.tasks.p pVar = new com.google.android.play.core.tasks.p();
        this.f4742f.a().execute(new Runnable(this, list2, pVar, list) { // from class: com.google.android.play.core.assetpacks.b2
            private final g2 a;
            private final List b;
            private final com.google.android.play.core.tasks.p c;

            /* renamed from: d  reason: collision with root package name */
            private final List f4701d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = list2;
                this.c = pVar;
                this.f4701d = list;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.k(this.b, this.c, this.f4701d);
            }
        });
        return pVar.a();
    }

    @Override // com.google.android.play.core.assetpacks.x3
    public final com.google.android.play.core.tasks.d<List<String>> a(Map<String, Long> map) {
        f4738h.f("syncPacks()", new Object[0]);
        return com.google.android.play.core.tasks.f.b(new ArrayList());
    }

    @Override // com.google.android.play.core.assetpacks.x3
    public final void a() {
        f4738h.f("keepAlive", new Object[0]);
    }

    @Override // com.google.android.play.core.assetpacks.x3
    public final void a(int i2) {
        f4738h.f("notifySessionFailed", new Object[0]);
    }

    @Override // com.google.android.play.core.assetpacks.x3
    public final void a(final int i2, final String str) {
        f4738h.f("notifyModuleCompleted", new Object[0]);
        this.f4742f.a().execute(new Runnable(this, i2, str) { // from class: com.google.android.play.core.assetpacks.d2
            private final g2 a;
            private final int b;
            private final String c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = i2;
                this.c = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.l(this.b, this.c);
            }
        });
    }

    @Override // com.google.android.play.core.assetpacks.x3
    public final void a(String str) {
        f4738h.f("removePack(%s)", str);
    }

    @Override // com.google.android.play.core.assetpacks.x3
    public final void a(List<String> list) {
        f4738h.f("cancelDownload(%s)", list);
    }

    @Override // com.google.android.play.core.assetpacks.x3
    public final com.google.android.play.core.tasks.d<ParcelFileDescriptor> b(int i2, String str, String str2, int i3) {
        File[] m;
        int i4;
        f4738h.f("getChunkFileDescriptor(session=%d, %s, %s, %d)", Integer.valueOf(i2), str, str2, Integer.valueOf(i3));
        com.google.android.play.core.tasks.p pVar = new com.google.android.play.core.tasks.p();
        try {
        } catch (LocalTestingException e2) {
            f4738h.g("getChunkFileDescriptor failed", e2);
            pVar.b(e2);
        } catch (FileNotFoundException e3) {
            f4738h.g("getChunkFileDescriptor failed", e3);
            pVar.b(new LocalTestingException("Asset Slice file not found.", e3));
        }
        for (File file : m(str)) {
            if (com.google.android.play.core.internal.y.b(file).equals(str2)) {
                pVar.c(ParcelFileDescriptor.open(file, PGImageSDK.SDK_STATUS_CREATE));
                return pVar.a();
            }
        }
        throw new LocalTestingException(String.format("Local testing slice for '%s' not found.", str2));
    }

    @Override // com.google.android.play.core.assetpacks.x3
    public final void c(int i2, String str, String str2, int i3) {
        f4738h.f("notifyChunkTransferred", new Object[0]);
    }

    @Override // com.google.android.play.core.assetpacks.x3
    public final com.google.android.play.core.tasks.d<e> d(final List<String> list, final h0 h0Var, Map<String, Long> map) {
        f4738h.f("getPackStates(%s)", list);
        final com.google.android.play.core.tasks.p pVar = new com.google.android.play.core.tasks.p();
        this.f4742f.a().execute(new Runnable(this, list, h0Var, pVar) { // from class: com.google.android.play.core.assetpacks.c2
            private final g2 a;
            private final List b;
            private final h0 c;

            /* renamed from: d  reason: collision with root package name */
            private final com.google.android.play.core.tasks.p f4709d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = list;
                this.c = h0Var;
                this.f4709d = pVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.j(this.b, this.c, this.f4709d);
            }
        });
        return pVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void i(Intent intent) {
        this.b.a(this.f4740d, intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void j(List list, h0 h0Var, com.google.android.play.core.tasks.p pVar) {
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        long j2 = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                AssetPackState f2 = f(str, h0Var.a(8, str));
                j2 += f2.g();
                hashMap.put(str, f2);
            } catch (LocalTestingException e2) {
                pVar.b(e2);
                return;
            }
        }
        pVar.c(e.a(j2, hashMap));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void k(List list, com.google.android.play.core.tasks.p pVar, List list2) {
        HashMap hashMap = new HashMap();
        int size = list.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            String str = (String) list.get(i2);
            try {
                AssetPackState f2 = f(str, 1);
                j2 += f2.g();
                hashMap.put(str, f2);
            } catch (LocalTestingException e2) {
                pVar.b(e2);
                return;
            }
        }
        int size2 = list.size();
        for (int i3 = 0; i3 < size2; i3++) {
            String str2 = (String) list.get(i3);
            try {
                int andIncrement = f4739i.getAndIncrement();
                h(andIncrement, str2, 1);
                h(andIncrement, str2, 2);
                h(andIncrement, str2, 3);
            } catch (LocalTestingException e3) {
                pVar.b(e3);
                return;
            }
        }
        int size3 = list2.size();
        for (int i4 = 0; i4 < size3; i4++) {
            String str3 = (String) list2.get(i4);
            hashMap.put(str3, AssetPackState.b(str3, 4, 0, 0L, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        }
        pVar.c(e.a(j2, hashMap));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void l(int i2, String str) {
        try {
            h(i2, str, 4);
        } catch (LocalTestingException e2) {
            f4738h.g("notifyModuleCompleted failed", e2);
        }
    }
}
