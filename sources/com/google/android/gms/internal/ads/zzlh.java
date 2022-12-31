package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.CencSampleEncryptionInformationGroupEntry;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzlh implements zzka {
    private static final zzkb zzapk = new zzlk();
    private static final int zzaxj = zzpt.zzbh(CencSampleEncryptionInformationGroupEntry.TYPE);
    private static final byte[] zzaxk = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private final int flags;
    private long zzaip;
    private final zzpn zzapr;
    private int zzarg;
    private int zzarh;
    private zzkc zzark;
    private final zzls zzaxl;
    private final SparseArray<zzlm> zzaxm;
    private final zzpn zzaxn;
    private final zzpn zzaxo;
    private final zzpn zzaxp;
    private final zzpr zzaxq;
    private final zzpn zzaxr;
    private final byte[] zzaxs;
    private final Stack<zzkv> zzaxt;
    private final LinkedList<zzlj> zzaxu;
    private int zzaxv;
    private int zzaxw;
    private long zzaxx;
    private int zzaxy;
    private zzpn zzaxz;
    private long zzaya;
    private int zzayb;
    private long zzayc;
    private zzlm zzayd;
    private int zzaye;
    private boolean zzayf;
    private zzkh zzayg;
    private zzkh[] zzayh;
    private boolean zzayi;

    public zzlh() {
        this(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.gms.internal.ads.zzjo zzb(java.util.List<com.google.android.gms.internal.ads.zzky> r14) {
        /*
            int r0 = r14.size()
            r1 = 0
            r2 = 0
            r4 = r2
            r3 = 0
        L8:
            if (r3 >= r0) goto Lb7
            java.lang.Object r5 = r14.get(r3)
            com.google.android.gms.internal.ads.zzky r5 = (com.google.android.gms.internal.ads.zzky) r5
            int r6 = r5.type
            int r7 = com.google.android.gms.internal.ads.zzkw.zzaur
            if (r6 != r7) goto Lb3
            if (r4 != 0) goto L1d
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L1d:
            com.google.android.gms.internal.ads.zzpn r5 = r5.zzawt
            byte[] r5 = r5.data
            com.google.android.gms.internal.ads.zzpn r6 = new com.google.android.gms.internal.ads.zzpn
            r6.<init>(r5)
            int r8 = r6.limit()
            r9 = 32
            if (r8 >= r9) goto L30
        L2e:
            r6 = r2
            goto L97
        L30:
            r6.zzbi(r1)
            int r8 = r6.readInt()
            int r9 = r6.zziv()
            int r9 = r9 + 4
            if (r8 == r9) goto L40
            goto L2e
        L40:
            int r8 = r6.readInt()
            if (r8 == r7) goto L47
            goto L2e
        L47:
            int r7 = r6.readInt()
            int r7 = com.google.android.gms.internal.ads.zzkw.zzar(r7)
            r8 = 1
            if (r7 <= r8) goto L6b
            r6 = 37
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r6)
            java.lang.String r6 = "Unsupported pssh version: "
            r8.append(r6)
            r8.append(r7)
            java.lang.String r6 = r8.toString()
            java.lang.String r7 = "PsshAtomUtil"
            android.util.Log.w(r7, r6)
            goto L2e
        L6b:
            java.util.UUID r9 = new java.util.UUID
            long r10 = r6.readLong()
            long r12 = r6.readLong()
            r9.<init>(r10, r12)
            if (r7 != r8) goto L83
            int r7 = r6.zzja()
            int r7 = r7 << 4
            r6.zzbj(r7)
        L83:
            int r7 = r6.zzja()
            int r8 = r6.zziv()
            if (r7 == r8) goto L8e
            goto L2e
        L8e:
            byte[] r8 = new byte[r7]
            r6.zze(r8, r1, r7)
            android.util.Pair r6 = android.util.Pair.create(r9, r8)
        L97:
            if (r6 != 0) goto L9b
            r6 = r2
            goto L9f
        L9b:
            java.lang.Object r6 = r6.first
            java.util.UUID r6 = (java.util.UUID) r6
        L9f:
            if (r6 != 0) goto La9
            java.lang.String r5 = "FragmentedMp4Extractor"
            java.lang.String r6 = "Skipped pssh atom (failed to extract uuid)"
            android.util.Log.w(r5, r6)
            goto Lb3
        La9:
            com.google.android.gms.internal.ads.zzjo$zza r7 = new com.google.android.gms.internal.ads.zzjo$zza
            java.lang.String r8 = "video/mp4"
            r7.<init>(r6, r8, r5)
            r4.add(r7)
        Lb3:
            int r3 = r3 + 1
            goto L8
        Lb7:
            if (r4 != 0) goto Lba
            return r2
        Lba:
            com.google.android.gms.internal.ads.zzjo r14 = new com.google.android.gms.internal.ads.zzjo
            r14.<init>(r4)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlh.zzb(java.util.List):com.google.android.gms.internal.ads.zzjo");
    }

    /* JADX WARN: Removed duplicated region for block: B:164:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0647  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzeb(long r54) throws com.google.android.gms.internal.ads.zzhw {
        /*
            Method dump skipped, instructions count: 1771
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlh.zzeb(long):void");
    }

    private final void zzhb() {
        this.zzaxv = 0;
        this.zzaxy = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void release() {
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final boolean zza(zzjz zzjzVar) throws IOException, InterruptedException {
        return zzlp.zzd(zzjzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void zzc(long j2, long j3) {
        int size = this.zzaxm.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.zzaxm.valueAt(i2).reset();
        }
        this.zzaxu.clear();
        this.zzayb = 0;
        this.zzaxt.clear();
        zzhb();
    }

    private zzlh(int i2) {
        this(0, null);
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void zza(zzkc zzkcVar) {
        this.zzark = zzkcVar;
    }

    private zzlh(int i2, zzpr zzprVar) {
        this(0, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:261:0x025e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x059c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0004 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0004 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzka
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(com.google.android.gms.internal.ads.zzjz r26, com.google.android.gms.internal.ads.zzkg r27) throws java.io.IOException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 1454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlh.zza(com.google.android.gms.internal.ads.zzjz, com.google.android.gms.internal.ads.zzkg):int");
    }

    private zzlh(int i2, zzpr zzprVar, zzls zzlsVar) {
        this.flags = 0;
        this.zzaxq = null;
        this.zzaxl = null;
        this.zzaxr = new zzpn(16);
        this.zzapr = new zzpn(zzpm.zzbjt);
        this.zzaxn = new zzpn(5);
        this.zzaxo = new zzpn();
        this.zzaxp = new zzpn(1);
        this.zzaxs = new byte[16];
        this.zzaxt = new Stack<>();
        this.zzaxu = new LinkedList<>();
        this.zzaxm = new SparseArray<>();
        this.zzaip = -9223372036854775807L;
        this.zzayc = -9223372036854775807L;
        zzhb();
    }

    private static void zza(zzpn zzpnVar, int i2, zzlu zzluVar) throws zzhw {
        zzpnVar.zzbi(i2 + 8);
        int zzas = zzkw.zzas(zzpnVar.readInt());
        if ((zzas & 1) == 0) {
            boolean z = (zzas & 2) != 0;
            int zzja = zzpnVar.zzja();
            if (zzja == zzluVar.zzaxc) {
                Arrays.fill(zzluVar.zzbba, 0, zzja, z);
                zzluVar.zzau(zzpnVar.zziv());
                zzpnVar.zze(zzluVar.zzbbd.data, 0, zzluVar.zzbbc);
                zzluVar.zzbbd.zzbi(0);
                zzluVar.zzbbe = false;
                return;
            }
            int i3 = zzluVar.zzaxc;
            StringBuilder sb = new StringBuilder(41);
            sb.append("Length mismatch: ");
            sb.append(zzja);
            sb.append(", ");
            sb.append(i3);
            throw new zzhw(sb.toString());
        }
        throw new zzhw("Overriding TrackEncryptionBox parameters is unsupported.");
    }
}
