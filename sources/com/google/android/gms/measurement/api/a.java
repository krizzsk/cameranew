package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.measurement.internal.q5;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes2.dex */
public class a {
    private final zzbr a;

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
    /* renamed from: com.google.android.gms.measurement.api.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0166a extends q5 {
        @Override // com.google.android.gms.measurement.internal.q5
        @WorkerThread
        void onEvent(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Bundle bundle, long j2);
    }

    public a(zzbr zzbrVar) {
        this.a = zzbrVar;
    }

    @RecentlyNonNull
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    public static a k(@RecentlyNonNull Context context, @RecentlyNonNull String str, @RecentlyNonNull String str2, @Nullable String str3, @RecentlyNonNull Bundle bundle) {
        return zzbr.zza(context, str, str2, str3, bundle).zzb();
    }

    public void a(@RecentlyNonNull @Size(min = 1) String str) {
        this.a.zzu(str);
    }

    public void b(@RecentlyNonNull @Size(max = 24, min = 1) String str, @Nullable String str2, @Nullable Bundle bundle) {
        this.a.zzl(str, str2, bundle);
    }

    public void c(@RecentlyNonNull @Size(min = 1) String str) {
        this.a.zzv(str);
    }

    public long d() {
        return this.a.zzy();
    }

    @RecentlyNonNull
    public String e() {
        return this.a.zzG();
    }

    @RecentlyNullable
    public String f() {
        return this.a.zzx();
    }

    @RecentlyNonNull
    @WorkerThread
    public List<Bundle> g(@Nullable String str, @Nullable @Size(max = 23, min = 1) String str2) {
        return this.a.zzm(str, str2);
    }

    @RecentlyNullable
    public String h() {
        return this.a.zzA();
    }

    @RecentlyNullable
    public String i() {
        return this.a.zzz();
    }

    @RecentlyNullable
    public String j() {
        return this.a.zzw();
    }

    @WorkerThread
    public int l(@RecentlyNonNull @Size(min = 1) String str) {
        return this.a.zzE(str);
    }

    @RecentlyNonNull
    @WorkerThread
    public Map<String, Object> m(@Nullable String str, @Nullable @Size(max = 24, min = 1) String str2, boolean z) {
        return this.a.zzB(str, str2, z);
    }

    public void n(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Bundle bundle) {
        this.a.zzh(str, str2, bundle);
    }

    public void o(@RecentlyNonNull Bundle bundle) {
        this.a.zzD(bundle, false);
    }

    @RecentlyNonNull
    public Bundle p(@RecentlyNonNull Bundle bundle) {
        return this.a.zzD(bundle, true);
    }

    public void q(@RecentlyNonNull InterfaceC0166a interfaceC0166a) {
        this.a.zze(interfaceC0166a);
    }

    public void r(@RecentlyNonNull Bundle bundle) {
        this.a.zzk(bundle);
    }

    public void s(@RecentlyNonNull Bundle bundle) {
        this.a.zzq(bundle);
    }

    public void t(@RecentlyNonNull Activity activity, @Nullable @Size(max = 36, min = 1) String str, @Nullable @Size(max = 36, min = 1) String str2) {
        this.a.zzo(activity, str, str2);
    }

    public void u(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Object obj) {
        this.a.zzj(str, str2, obj, true);
    }

    public final void v(boolean z) {
        this.a.zzI(z);
    }
}
