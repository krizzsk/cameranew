package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzby;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzck;
import com.google.android.gms.internal.measurement.zzcx;
import com.google.android.gms.internal.measurement.zzcz;
import com.google.android.gms.internal.measurement.zzda;
import com.google.android.gms.internal.measurement.zzdb;
import com.google.android.gms.internal.measurement.zzde;
import com.google.android.gms.internal.measurement.zzdf;
import com.google.android.gms.internal.measurement.zzdh;
import com.google.android.gms.internal.measurement.zzdi;
import com.google.android.gms.internal.measurement.zzdj;
import com.google.android.gms.internal.measurement.zzdq;
import com.google.android.gms.internal.measurement.zzds;
import com.google.android.gms.internal.measurement.zzdt;
import com.google.android.gms.internal.measurement.zzdu;
import com.google.android.gms.internal.measurement.zzhe;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zziw;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class j9 extends z8 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j9(i9 i9Var) {
        super(i9Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean A(List<Long> list, int i2) {
        if (i2 < list.size() * 64) {
            return ((1 << (i2 % 64)) & list.get(i2 / 64).longValue()) != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Long> B(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            long j2 = 0;
            for (int i3 = 0; i3 < 64; i3++) {
                int i4 = (i2 * 64) + i3;
                if (i4 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i4)) {
                    j2 |= 1 << i3;
                }
            }
            arrayList.add(Long.valueOf(j2));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <Builder extends zziw> Builder G(Builder builder, byte[] bArr) throws zzic {
        zzhe zzb = zzhe.zzb();
        if (zzb != null) {
            return (Builder) builder.zzav(bArr, zzb);
        }
        return (Builder) builder.zzaw(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int H(zzdi zzdiVar, String str) {
        for (int i2 = 0; i2 < zzdiVar.zzk(); i2++) {
            if (str.equals(zzdiVar.zzl(i2).zzc())) {
                return i2;
            }
        }
        return -1;
    }

    static List<zzdf> I(Bundle[] bundleArr) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : bundleArr) {
            if (bundle != null) {
                zzde zzn = zzdf.zzn();
                for (String str : bundle.keySet()) {
                    zzde zzn2 = zzdf.zzn();
                    zzn2.zza(str);
                    Object obj = bundle.get(str);
                    if (obj instanceof Long) {
                        zzn2.zzd(((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        zzn2.zzb((String) obj);
                    } else if (obj instanceof Double) {
                        zzn2.zzf(((Double) obj).doubleValue());
                    }
                    zzn.zzi(zzn2);
                }
                if (zzn.zzh() > 0) {
                    arrayList.add(zzn.zzaA());
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void J(zzda zzdaVar, String str, Object obj) {
        List<zzdf> zza = zzdaVar.zza();
        int i2 = 0;
        while (true) {
            if (i2 >= zza.size()) {
                i2 = -1;
                break;
            } else if (str.equals(zza.get(i2).zzb())) {
                break;
            } else {
                i2++;
            }
        }
        zzde zzn = zzdf.zzn();
        zzn.zza(str);
        if (obj instanceof Long) {
            zzn.zzd(((Long) obj).longValue());
        } else if (obj instanceof String) {
            zzn.zzb((String) obj);
        } else if (obj instanceof Double) {
            zzn.zzf(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            zzn.zzj(I((Bundle[]) obj));
        }
        if (i2 >= 0) {
            zzdaVar.zze(i2, zzn);
        } else {
            zzdaVar.zzg(zzn);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public static final boolean K(zzas zzasVar, zzp zzpVar) {
        com.google.android.gms.common.internal.q.j(zzasVar);
        com.google.android.gms.common.internal.q.j(zzpVar);
        return (TextUtils.isEmpty(zzpVar.zzb) && TextUtils.isEmpty(zzpVar.zzq)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final zzdf L(zzdb zzdbVar, String str) {
        for (zzdf zzdfVar : zzdbVar.zza()) {
            if (zzdfVar.zzb().equals(str)) {
                return zzdfVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object k(zzdb zzdbVar, String str) {
        zzdf L = L(zzdbVar, str);
        if (L != null) {
            if (L.zzc()) {
                return L.zzd();
            }
            if (L.zze()) {
                return Long.valueOf(L.zzf());
            }
            if (L.zzi()) {
                return Double.valueOf(L.zzj());
            }
            if (L.zzm() > 0) {
                List<zzdf> zzk = L.zzk();
                ArrayList arrayList = new ArrayList();
                for (zzdf zzdfVar : zzk) {
                    if (zzdfVar != null) {
                        Bundle bundle = new Bundle();
                        for (zzdf zzdfVar2 : zzdfVar.zzk()) {
                            if (zzdfVar2.zzc()) {
                                bundle.putString(zzdfVar2.zzb(), zzdfVar2.zzd());
                            } else if (zzdfVar2.zze()) {
                                bundle.putLong(zzdfVar2.zzb(), zzdfVar2.zzf());
                            } else if (zzdfVar2.zzi()) {
                                bundle.putDouble(zzdfVar2.zzb(), zzdfVar2.zzj());
                            }
                        }
                        if (!bundle.isEmpty()) {
                            arrayList.add(bundle);
                        }
                    }
                }
                return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
            }
            return null;
        }
        return null;
    }

    private final void l(StringBuilder sb, int i2, List<zzdf> list) {
        if (list == null) {
            return;
        }
        int i3 = i2 + 1;
        for (zzdf zzdfVar : list) {
            if (zzdfVar != null) {
                n(sb, i3);
                sb.append("param {\n");
                q(sb, i3, "name", zzdfVar.zza() ? this.a.F().o(zzdfVar.zzb()) : null);
                q(sb, i3, "string_value", zzdfVar.zzc() ? zzdfVar.zzd() : null);
                q(sb, i3, "int_value", zzdfVar.zze() ? Long.valueOf(zzdfVar.zzf()) : null);
                q(sb, i3, "double_value", zzdfVar.zzi() ? Double.valueOf(zzdfVar.zzj()) : null);
                if (zzdfVar.zzm() > 0) {
                    l(sb, i3, zzdfVar.zzk());
                }
                n(sb, i3);
                sb.append("}\n");
            }
        }
    }

    private final void m(StringBuilder sb, int i2, zzby zzbyVar) {
        if (zzbyVar == null) {
            return;
        }
        n(sb, i2);
        sb.append("filter {\n");
        if (zzbyVar.zze()) {
            q(sb, i2, "complement", Boolean.valueOf(zzbyVar.zzf()));
        }
        if (zzbyVar.zzg()) {
            q(sb, i2, "param_name", this.a.F().o(zzbyVar.zzh()));
        }
        if (zzbyVar.zza()) {
            int i3 = i2 + 1;
            zzck zzb = zzbyVar.zzb();
            if (zzb != null) {
                n(sb, i3);
                sb.append("string_filter {\n");
                if (zzb.zza()) {
                    q(sb, i3, "match_type", zzb.zzb().name());
                }
                if (zzb.zzc()) {
                    q(sb, i3, "expression", zzb.zzd());
                }
                if (zzb.zze()) {
                    q(sb, i3, "case_sensitive", Boolean.valueOf(zzb.zzf()));
                }
                if (zzb.zzh() > 0) {
                    n(sb, i3 + 1);
                    sb.append("expression_list {\n");
                    for (String str : zzb.zzg()) {
                        n(sb, i3 + 2);
                        sb.append(str);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                n(sb, i3);
                sb.append("}\n");
            }
        }
        if (zzbyVar.zzc()) {
            r(sb, i2 + 1, "number_filter", zzbyVar.zzd());
        }
        n(sb, i2);
        sb.append("}\n");
    }

    private static final void n(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("  ");
        }
    }

    private static final String o(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private static final void p(StringBuilder sb, int i2, String str, zzdq zzdqVar, String str2) {
        if (zzdqVar == null) {
            return;
        }
        n(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zzdqVar.zzd() != 0) {
            n(sb, 4);
            sb.append("results: ");
            int i3 = 0;
            for (Long l2 : zzdqVar.zzc()) {
                int i4 = i3 + 1;
                if (i3 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i3 = i4;
            }
            sb.append('\n');
        }
        if (zzdqVar.zzb() != 0) {
            n(sb, 4);
            sb.append("status: ");
            int i5 = 0;
            for (Long l3 : zzdqVar.zza()) {
                int i6 = i5 + 1;
                if (i5 != 0) {
                    sb.append(", ");
                }
                sb.append(l3);
                i5 = i6;
            }
            sb.append('\n');
        }
        if (zzdqVar.zzf() != 0) {
            n(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i7 = 0;
            for (zzcz zzczVar : zzdqVar.zze()) {
                int i8 = i7 + 1;
                if (i7 != 0) {
                    sb.append(", ");
                }
                sb.append(zzczVar.zza() ? Integer.valueOf(zzczVar.zzb()) : null);
                sb.append(":");
                sb.append(zzczVar.zzc() ? Long.valueOf(zzczVar.zzd()) : null);
                i7 = i8;
            }
            sb.append("}\n");
        }
        if (zzdqVar.zzi() != 0) {
            n(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i9 = 0;
            for (zzds zzdsVar : zzdqVar.zzh()) {
                int i10 = i9 + 1;
                if (i9 != 0) {
                    sb.append(", ");
                }
                sb.append(zzdsVar.zza() ? Integer.valueOf(zzdsVar.zzb()) : null);
                sb.append(": [");
                int i11 = 0;
                for (Long l4 : zzdsVar.zzc()) {
                    long longValue = l4.longValue();
                    int i12 = i11 + 1;
                    if (i11 != 0) {
                        sb.append(", ");
                    }
                    sb.append(longValue);
                    i11 = i12;
                }
                sb.append("]");
                i9 = i10;
            }
            sb.append("}\n");
        }
        n(sb, 3);
        sb.append("}\n");
    }

    private static final void q(StringBuilder sb, int i2, String str, Object obj) {
        if (obj == null) {
            return;
        }
        n(sb, i2 + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    private static final void r(StringBuilder sb, int i2, String str, zzcd zzcdVar) {
        if (zzcdVar == null) {
            return;
        }
        n(sb, i2);
        sb.append(str);
        sb.append(" {\n");
        if (zzcdVar.zza()) {
            q(sb, i2, "comparison_type", zzcdVar.zzb().name());
        }
        if (zzcdVar.zzc()) {
            q(sb, i2, "match_as_float", Boolean.valueOf(zzcdVar.zzd()));
        }
        if (zzcdVar.zze()) {
            q(sb, i2, "comparison_value", zzcdVar.zzf());
        }
        if (zzcdVar.zzg()) {
            q(sb, i2, "min_comparison_value", zzcdVar.zzh());
        }
        if (zzcdVar.zzi()) {
            q(sb, i2, "max_comparison_value", zzcdVar.zzj());
        }
        n(sb, i2);
        sb.append("}\n");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean z(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<Long> C(List<Long> list, List<Integer> list2) {
        int i2;
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                this.a.a().p().b("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    this.a.a().p().c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i3 = size2;
            i2 = size;
            size = i3;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean D(long j2, long j3) {
        return j2 == 0 || j3 <= 0 || Math.abs(this.a.zzax().currentTimeMillis() - j2) > j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final long E(byte[] bArr) {
        com.google.android.gms.common.internal.q.j(bArr);
        this.a.E().f();
        MessageDigest z = n9.z();
        if (z == null) {
            this.a.a().m().a("Failed to get MD5");
            return 0L;
        }
        return n9.A(z.digest(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] F(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            this.a.a().m().b("Failed to gzip content", e2);
            throw e2;
        }
    }

    @Override // com.google.android.gms.measurement.internal.z8
    protected final boolean j() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void s(zzdt zzdtVar, Object obj) {
        com.google.android.gms.common.internal.q.j(obj);
        zzdtVar.zzd();
        zzdtVar.zzf();
        zzdtVar.zzh();
        if (obj instanceof String) {
            zzdtVar.zzc((String) obj);
        } else if (obj instanceof Long) {
            zzdtVar.zze(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzdtVar.zzg(((Double) obj).doubleValue());
        } else {
            this.a.a().m().b("Ignoring invalid (type) user attribute value", obj);
        }
    }

    final void t(zzde zzdeVar, Object obj) {
        com.google.android.gms.common.internal.q.j(obj);
        zzdeVar.zzc();
        zzdeVar.zze();
        zzdeVar.zzg();
        zzdeVar.zzk();
        if (obj instanceof String) {
            zzdeVar.zzb((String) obj);
        } else if (obj instanceof Long) {
            zzdeVar.zzd(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzdeVar.zzf(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            zzdeVar.zzj(I((Bundle[]) obj));
        } else {
            this.a.a().m().b("Ignoring invalid (type) event param value", obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzdb u(n nVar) {
        zzda zzk = zzdb.zzk();
        zzk.zzq(nVar.f3878e);
        p pVar = new p(nVar.f3879f);
        while (pVar.hasNext()) {
            String next = pVar.next();
            zzde zzn = zzdf.zzn();
            zzn.zza(next);
            Object h2 = nVar.f3879f.h(next);
            com.google.android.gms.common.internal.q.j(h2);
            t(zzn, h2);
            zzk.zzg(zzn);
        }
        return zzk.zzaA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String v(zzdh zzdhVar) {
        if (zzdhVar == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (zzdj zzdjVar : zzdhVar.zza()) {
            if (zzdjVar != null) {
                n(sb, 1);
                sb.append("bundle {\n");
                if (zzdjVar.zza()) {
                    q(sb, 1, "protocol_version", Integer.valueOf(zzdjVar.zzb()));
                }
                q(sb, 1, "platform", zzdjVar.zzt());
                if (zzdjVar.zzC()) {
                    q(sb, 1, "gmp_version", Long.valueOf(zzdjVar.zzD()));
                }
                if (zzdjVar.zzE()) {
                    q(sb, 1, "uploading_gmp_version", Long.valueOf(zzdjVar.zzF()));
                }
                if (zzdjVar.zzae()) {
                    q(sb, 1, "dynamite_version", Long.valueOf(zzdjVar.zzaf()));
                }
                if (zzdjVar.zzW()) {
                    q(sb, 1, "config_version", Long.valueOf(zzdjVar.zzX()));
                }
                q(sb, 1, "gmp_app_id", zzdjVar.zzP());
                q(sb, 1, "admob_app_id", zzdjVar.zzad());
                q(sb, 1, TapjoyConstants.TJC_APP_ID, zzdjVar.zzA());
                q(sb, 1, TapjoyConstants.TJC_APP_VERSION_NAME, zzdjVar.zzB());
                if (zzdjVar.zzU()) {
                    q(sb, 1, "app_version_major", Integer.valueOf(zzdjVar.zzV()));
                }
                q(sb, 1, "firebase_instance_id", zzdjVar.zzT());
                if (zzdjVar.zzK()) {
                    q(sb, 1, "dev_cert_hash", Long.valueOf(zzdjVar.zzL()));
                }
                q(sb, 1, "app_store", zzdjVar.zzz());
                if (zzdjVar.zzi()) {
                    q(sb, 1, "upload_timestamp_millis", Long.valueOf(zzdjVar.zzj()));
                }
                if (zzdjVar.zzk()) {
                    q(sb, 1, "start_timestamp_millis", Long.valueOf(zzdjVar.zzm()));
                }
                if (zzdjVar.zzn()) {
                    q(sb, 1, "end_timestamp_millis", Long.valueOf(zzdjVar.zzo()));
                }
                if (zzdjVar.zzp()) {
                    q(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzdjVar.zzq()));
                }
                if (zzdjVar.zzr()) {
                    q(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzdjVar.zzs()));
                }
                q(sb, 1, "app_instance_id", zzdjVar.zzJ());
                q(sb, 1, "resettable_device_id", zzdjVar.zzG());
                q(sb, 1, "ds_id", zzdjVar.zzaa());
                if (zzdjVar.zzH()) {
                    q(sb, 1, "limited_ad_tracking", Boolean.valueOf(zzdjVar.zzI()));
                }
                q(sb, 1, TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, zzdjVar.zzu());
                q(sb, 1, "device_model", zzdjVar.zzv());
                q(sb, 1, "user_default_language", zzdjVar.zzw());
                if (zzdjVar.zzx()) {
                    q(sb, 1, "time_zone_offset_minutes", Integer.valueOf(zzdjVar.zzy()));
                }
                if (zzdjVar.zzM()) {
                    q(sb, 1, "bundle_sequential_index", Integer.valueOf(zzdjVar.zzN()));
                }
                if (zzdjVar.zzQ()) {
                    q(sb, 1, "service_upload", Boolean.valueOf(zzdjVar.zzR()));
                }
                q(sb, 1, "health_monitor", zzdjVar.zzO());
                if (!this.a.x().u(null, x2.v0) && zzdjVar.zzY() && zzdjVar.zzZ() != 0) {
                    q(sb, 1, TapjoyConstants.TJC_ANDROID_ID, Long.valueOf(zzdjVar.zzZ()));
                }
                if (zzdjVar.zzab()) {
                    q(sb, 1, IjkMediaPlayer.OnNativeInvokeListener.ARG_RETRY_COUNTER, Integer.valueOf(zzdjVar.zzac()));
                }
                if (zzdjVar.zzah()) {
                    q(sb, 1, "consent_signals", zzdjVar.zzai());
                }
                List<zzdu> zzf = zzdjVar.zzf();
                if (zzf != null) {
                    for (zzdu zzduVar : zzf) {
                        if (zzduVar != null) {
                            n(sb, 2);
                            sb.append("user_property {\n");
                            q(sb, 2, "set_timestamp_millis", zzduVar.zza() ? Long.valueOf(zzduVar.zzb()) : null);
                            q(sb, 2, "name", this.a.F().p(zzduVar.zzc()));
                            q(sb, 2, "string_value", zzduVar.zze());
                            q(sb, 2, "int_value", zzduVar.zzf() ? Long.valueOf(zzduVar.zzg()) : null);
                            q(sb, 2, "double_value", zzduVar.zzh() ? Double.valueOf(zzduVar.zzi()) : null);
                            n(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzcx> zzS = zzdjVar.zzS();
                String zzA = zzdjVar.zzA();
                if (zzS != null) {
                    for (zzcx zzcxVar : zzS) {
                        if (zzcxVar != null) {
                            n(sb, 2);
                            sb.append("audience_membership {\n");
                            if (zzcxVar.zza()) {
                                q(sb, 2, "audience_id", Integer.valueOf(zzcxVar.zzb()));
                            }
                            if (zzcxVar.zzf()) {
                                q(sb, 2, "new_audience", Boolean.valueOf(zzcxVar.zzg()));
                            }
                            p(sb, 2, "current_data", zzcxVar.zzc(), zzA);
                            if (zzcxVar.zzd()) {
                                p(sb, 2, "previous_data", zzcxVar.zze(), zzA);
                            }
                            n(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzdb> zzc = zzdjVar.zzc();
                if (zzc != null) {
                    for (zzdb zzdbVar : zzc) {
                        if (zzdbVar != null) {
                            n(sb, 2);
                            sb.append("event {\n");
                            q(sb, 2, "name", this.a.F().n(zzdbVar.zzd()));
                            if (zzdbVar.zze()) {
                                q(sb, 2, "timestamp_millis", Long.valueOf(zzdbVar.zzf()));
                            }
                            if (zzdbVar.zzg()) {
                                q(sb, 2, "previous_timestamp_millis", Long.valueOf(zzdbVar.zzh()));
                            }
                            if (zzdbVar.zzi()) {
                                q(sb, 2, "count", Integer.valueOf(zzdbVar.zzj()));
                            }
                            if (zzdbVar.zzb() != 0) {
                                l(sb, 2, zzdbVar.zza());
                            }
                            n(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                n(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String w(zzbw zzbwVar) {
        if (zzbwVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzbwVar.zza()) {
            q(sb, 0, "filter_id", Integer.valueOf(zzbwVar.zzb()));
        }
        q(sb, 0, TJAdUnitConstants.PARAM_PLACEMENT_NAME, this.a.F().n(zzbwVar.zzc()));
        String o = o(zzbwVar.zzi(), zzbwVar.zzj(), zzbwVar.zzm());
        if (!o.isEmpty()) {
            q(sb, 0, "filter_type", o);
        }
        if (zzbwVar.zzg()) {
            r(sb, 1, "event_count_filter", zzbwVar.zzh());
        }
        if (zzbwVar.zze() > 0) {
            sb.append("  filters {\n");
            for (zzby zzbyVar : zzbwVar.zzd()) {
                m(sb, 2, zzbyVar);
            }
        }
        n(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String x(zzcf zzcfVar) {
        if (zzcfVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zzcfVar.zza()) {
            q(sb, 0, "filter_id", Integer.valueOf(zzcfVar.zzb()));
        }
        q(sb, 0, "property_name", this.a.F().p(zzcfVar.zzc()));
        String o = o(zzcfVar.zze(), zzcfVar.zzf(), zzcfVar.zzh());
        if (!o.isEmpty()) {
            q(sb, 0, "filter_type", o);
        }
        m(sb, 1, zzcfVar.zzd());
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T extends Parcelable> T y(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return creator.createFromParcel(obtain);
        } catch (SafeParcelReader.ParseException unused) {
            this.a.a().m().a("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
    }
}
