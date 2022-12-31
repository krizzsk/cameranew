package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class z implements x3 {

    /* renamed from: f  reason: collision with root package name */
    private static final com.google.android.play.core.internal.j f4837f = new com.google.android.play.core.internal.j("AssetPackServiceImpl");

    /* renamed from: g  reason: collision with root package name */
    private static final Intent f4838g = new Intent("com.google.android.play.core.assetmoduleservice.BIND_ASSET_MODULE_SERVICE").setPackage("com.android.vending");
    private final String a;
    private final f1 b;
    @Nullable
    private com.google.android.play.core.internal.t<com.google.android.play.core.internal.v1> c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private com.google.android.play.core.internal.t<com.google.android.play.core.internal.v1> f4839d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f4840e = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Context context, f1 f1Var) {
        this.a = context.getPackageName();
        this.b = f1Var;
        if (com.google.android.play.core.internal.z0.a(context)) {
            Context a = com.google.android.play.core.splitcompat.q.a(context);
            com.google.android.play.core.internal.j jVar = f4837f;
            Intent intent = f4838g;
            this.c = new com.google.android.play.core.internal.t<>(a, jVar, "AssetPackService", intent, y3.a);
            this.f4839d = new com.google.android.play.core.internal.t<>(com.google.android.play.core.splitcompat.q.a(context), jVar, "AssetPackService-keepAlive", intent, z3.a);
        }
        f4837f.c("AssetPackService initiated.", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ArrayList f(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", (String) it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List g(z zVar, List list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            AssetPackState next = e.b((Bundle) list.get(i2), zVar.b).f().values().iterator().next();
            if (next == null) {
                f4837f.e("onGetSessionStates: Bundle contained no pack.", new Object[0]);
            }
            if (j2.c(next.f())) {
                arrayList.add(next.e());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(int i2, String str, int i3) {
        if (this.c == null) {
            throw new bv("The Play Store app is not installed or is an unofficial version.", i2);
        }
        f4837f.f("notifyModuleCompleted", new Object[0]);
        com.google.android.play.core.tasks.p pVar = new com.google.android.play.core.tasks.p();
        this.c.c(new o(this, pVar, i2, str, pVar, i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Bundle l(Map map) {
        Bundle v = v();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            Bundle bundle = new Bundle();
            bundle.putString("installed_asset_module_name", (String) entry.getKey());
            bundle.putLong("installed_asset_module_version", ((Long) entry.getValue()).longValue());
            arrayList.add(bundle);
        }
        v.putParcelableArrayList("installed_asset_module", arrayList);
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle p(int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt(TapjoyConstants.TJC_SESSION_ID, i2);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle q(int i2, String str) {
        Bundle p = p(i2);
        p.putString("module_name", str);
        return p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Bundle r(int i2, String str, String str2, int i3) {
        Bundle q = q(i2, str);
        q.putString("slice_id", str2);
        q.putInt("chunk_number", i3);
        return q;
    }

    private static <T> com.google.android.play.core.tasks.d<T> u() {
        f4837f.e("onError(%d)", -11);
        return com.google.android.play.core.tasks.f.a(new AssetPackException(-11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle v() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10800);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        bundle.putIntegerArrayList("supported_compression_formats", arrayList);
        bundle.putIntegerArrayList("supported_patch_formats", new ArrayList<>());
        return bundle;
    }

    @Override // com.google.android.play.core.assetpacks.x3
    public final com.google.android.play.core.tasks.d<e> a(List<String> list, List<String> list2, Map<String, Long> map) {
        if (this.c == null) {
            return u();
        }
        f4837f.f("startDownload(%s)", list2);
        com.google.android.play.core.tasks.p pVar = new com.google.android.play.core.tasks.p();
        this.c.c(new h(this, pVar, list2, map, pVar, list));
        pVar.a().d(new com.google.android.play.core.tasks.c(this) { // from class: com.google.android.play.core.assetpacks.a4
            private final z a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // com.google.android.play.core.tasks.c
            public final void onSuccess(Object obj) {
                e eVar = (e) obj;
                this.a.a();
            }
        });
        return pVar.a();
    }

    @Override // com.google.android.play.core.assetpacks.x3
    public final com.google.android.play.core.tasks.d<List<String>> a(Map<String, Long> map) {
        if (this.c == null) {
            return u();
        }
        f4837f.f("syncPacks", new Object[0]);
        com.google.android.play.core.tasks.p pVar = new com.google.android.play.core.tasks.p();
        this.c.c(new k(this, pVar, map, pVar));
        return pVar.a();
    }

    @Override // com.google.android.play.core.assetpacks.x3
    public final synchronized void a() {
        if (this.f4839d == null) {
            f4837f.g("Keep alive connection manager is not initialized.", new Object[0]);
            return;
        }
        com.google.android.play.core.internal.j jVar = f4837f;
        jVar.f("keepAlive", new Object[0]);
        if (!this.f4840e.compareAndSet(false, true)) {
            jVar.f("Service is already kept alive.", new Object[0]);
            return;
        }
        com.google.android.play.core.tasks.p pVar = new com.google.android.play.core.tasks.p();
        this.f4839d.c(new r(this, pVar, pVar));
    }

    @Override // com.google.android.play.core.assetpacks.x3
    public final void a(int i2) {
        if (this.c == null) {
            throw new bv("The Play Store app is not installed or is an unofficial version.", i2);
        }
        f4837f.f("notifySessionFailed", new Object[0]);
        com.google.android.play.core.tasks.p pVar = new com.google.android.play.core.tasks.p();
        this.c.c(new p(this, pVar, i2, pVar));
    }

    @Override // com.google.android.play.core.assetpacks.x3
    public final void a(int i2, String str) {
        h(i2, str, 10);
    }

    @Override // com.google.android.play.core.assetpacks.x3
    public final void a(String str) {
        if (this.c == null) {
            return;
        }
        f4837f.f("removePack(%s)", str);
        com.google.android.play.core.tasks.p pVar = new com.google.android.play.core.tasks.p();
        this.c.c(new g(this, pVar, str, pVar));
    }

    @Override // com.google.android.play.core.assetpacks.x3
    public final void a(List<String> list) {
        if (this.c == null) {
            return;
        }
        f4837f.f("cancelDownloads(%s)", list);
        com.google.android.play.core.tasks.p pVar = new com.google.android.play.core.tasks.p();
        this.c.c(new j(this, pVar, list, pVar));
    }

    @Override // com.google.android.play.core.assetpacks.x3
    public final com.google.android.play.core.tasks.d<ParcelFileDescriptor> b(int i2, String str, String str2, int i3) {
        if (this.c == null) {
            return u();
        }
        f4837f.f("getChunkFileDescriptor(%s, %s, %d, session=%d)", str, str2, Integer.valueOf(i3), Integer.valueOf(i2));
        com.google.android.play.core.tasks.p pVar = new com.google.android.play.core.tasks.p();
        this.c.c(new q(this, pVar, i2, str, str2, i3, pVar));
        return pVar.a();
    }

    @Override // com.google.android.play.core.assetpacks.x3
    public final void c(int i2, String str, String str2, int i3) {
        if (this.c == null) {
            throw new bv("The Play Store app is not installed or is an unofficial version.", i2);
        }
        f4837f.f("notifyChunkTransferred", new Object[0]);
        com.google.android.play.core.tasks.p pVar = new com.google.android.play.core.tasks.p();
        this.c.c(new m(this, pVar, i2, str, str2, i3, pVar));
    }

    @Override // com.google.android.play.core.assetpacks.x3
    public final com.google.android.play.core.tasks.d<e> d(List<String> list, h0 h0Var, Map<String, Long> map) {
        if (this.c == null) {
            return u();
        }
        f4837f.f("getPackStates(%s)", list);
        com.google.android.play.core.tasks.p pVar = new com.google.android.play.core.tasks.p();
        this.c.c(new l(this, pVar, list, map, pVar, h0Var));
        return pVar.a();
    }
}
