package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class ca extends z8 {

    /* renamed from: d  reason: collision with root package name */
    private String f3764d;

    /* renamed from: e  reason: collision with root package name */
    private Set<Integer> f3765e;

    /* renamed from: f  reason: collision with root package name */
    private Map<Integer, x9> f3766f;

    /* renamed from: g  reason: collision with root package name */
    private Long f3767g;

    /* renamed from: h  reason: collision with root package name */
    private Long f3768h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(i9 i9Var) {
        super(i9Var);
    }

    private final x9 l(Integer num) {
        if (this.f3766f.containsKey(num)) {
            return this.f3766f.get(num);
        }
        x9 x9Var = new x9(this, this.f3764d, null);
        this.f3766f.put(num, x9Var);
        return x9Var;
    }

    private final boolean m(int i2, int i3) {
        x9 x9Var = this.f3766f.get(Integer.valueOf(i2));
        if (x9Var == null) {
            return false;
        }
        return x9.c(x9Var).get(i3);
    }

    @Override // com.google.android.gms.measurement.internal.z8
    protected final boolean j() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(17:(6:19|20|21|22|23|(22:(7:25|26|27|28|(1:30)(3:499|(1:501)(1:503)|502)|31|(1:34)(1:33))|(1:36)|37|38|39|40|41|42|(3:44|(1:46)|47)(4:457|(6:458|459|460|461|462|(1:465)(1:464))|(1:467)|468)|48|(5:292|(3:294|(6:296|297|298|299|300|(2:(3:302|(1:304)|305)|307)(1:351))|365)(1:456)|366|(10:369|(3:373|(4:376|(5:378|379|(1:381)(1:385)|382|383)(1:386)|384|374)|387)|388|(3:392|(4:395|(3:400|401|402)|403|393)|406)|407|(3:409|(6:412|(2:414|(3:416|417|418))(1:421)|419|420|418|410)|422)|423|(3:432|(8:435|(1:437)|438|(1:440)|441|(3:443|444|445)(1:447)|446|433)|448)|449|367)|455)|50|51|(3:182|(4:185|(9:187|(1:189)(1:289)|190|(10:192|193|194|195|196|197|198|199|(4:201|(11:202|203|204|205|206|207|208|(3:210|211|212)(1:258)|213|214|(1:217)(1:216))|(1:219)|220)(2:268|269)|221)(1:288)|222|(4:225|(3:243|244|245)(6:227|228|(2:229|(2:231|(1:233)(2:234|235))(2:241|242))|(1:237)|238|239)|240|223)|246|247|248)(1:290)|249|183)|291)|53|54|(3:81|(6:84|(7:86|87|88|89|90|(3:(9:92|93|94|95|96|(1:98)(1:157)|99|100|(1:103)(1:102))|(1:105)|106)(2:164|165)|107)(1:180)|108|(2:109|(2:111|(3:147|148|149)(6:113|(2:114|(4:116|(3:118|(1:120)(1:143)|121)(1:144)|122|(1:1)(2:126|(1:128)(2:129|130)))(2:145|146))|(2:135|134)|132|133|134))(0))|150|82)|181)|56|57|(9:60|61|62|63|64|65|(2:67|68)(1:70)|69|58)|78|79)(1:507))|41|42|(0)(0)|48|(0)|50|51|(0)|53|54|(0)|56|57|(1:58)|78|79) */
    /* JADX WARN: Can't wrap try/catch for region: R(27:1|(2:2|(2:4|(2:6|7))(2:523|524))|8|(3:10|11|12)|16|(6:19|20|21|22|23|(22:(7:25|26|27|28|(1:30)(3:499|(1:501)(1:503)|502)|31|(1:34)(1:33))|(1:36)|37|38|39|40|41|42|(3:44|(1:46)|47)(4:457|(6:458|459|460|461|462|(1:465)(1:464))|(1:467)|468)|48|(5:292|(3:294|(6:296|297|298|299|300|(2:(3:302|(1:304)|305)|307)(1:351))|365)(1:456)|366|(10:369|(3:373|(4:376|(5:378|379|(1:381)(1:385)|382|383)(1:386)|384|374)|387)|388|(3:392|(4:395|(3:400|401|402)|403|393)|406)|407|(3:409|(6:412|(2:414|(3:416|417|418))(1:421)|419|420|418|410)|422)|423|(3:432|(8:435|(1:437)|438|(1:440)|441|(3:443|444|445)(1:447)|446|433)|448)|449|367)|455)|50|51|(3:182|(4:185|(9:187|(1:189)(1:289)|190|(10:192|193|194|195|196|197|198|199|(4:201|(11:202|203|204|205|206|207|208|(3:210|211|212)(1:258)|213|214|(1:217)(1:216))|(1:219)|220)(2:268|269)|221)(1:288)|222|(4:225|(3:243|244|245)(6:227|228|(2:229|(2:231|(1:233)(2:234|235))(2:241|242))|(1:237)|238|239)|240|223)|246|247|248)(1:290)|249|183)|291)|53|54|(3:81|(6:84|(7:86|87|88|89|90|(3:(9:92|93|94|95|96|(1:98)(1:157)|99|100|(1:103)(1:102))|(1:105)|106)(2:164|165)|107)(1:180)|108|(2:109|(2:111|(3:147|148|149)(6:113|(2:114|(4:116|(3:118|(1:120)(1:143)|121)(1:144)|122|(1:1)(2:126|(1:128)(2:129|130)))(2:145|146))|(2:135|134)|132|133|134))(0))|150|82)|181)|56|57|(9:60|61|62|63|64|65|(2:67|68)(1:70)|69|58)|78|79)(1:507))|522|38|39|40|41|42|(0)(0)|48|(0)|50|51|(0)|53|54|(0)|56|57|(1:58)|78|79|(5:(0)|(0)|(0)|(0)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02df, code lost:
        if (r5 != null) goto L309;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x02e1, code lost:
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x02e9, code lost:
        if (r5 != null) goto L309;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x030e, code lost:
        if (r5 == null) goto L310;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0311, code lost:
        r1 = r13.keySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x031d, code lost:
        if (r1.hasNext() == false) goto L350;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x031f, code lost:
        r4 = ((java.lang.Integer) r1.next()).intValue();
        r5 = java.lang.Integer.valueOf(r4);
        r6 = (com.google.android.gms.internal.measurement.zzdq) r13.get(r5);
        r7 = (java.util.List) r0.get(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0339, code lost:
        if (r7 == null) goto L349;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x033f, code lost:
        if (r7.isEmpty() == false) goto L317;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0343, code lost:
        r17 = r0;
        r0 = r65.b.c0().C(r6.zzc(), r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0357, code lost:
        if (r0.isEmpty() != false) goto L319;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0359, code lost:
        r5 = r6.zzbu();
        r5.zzd();
        r5.zzc(r0);
        r20 = r1;
        r0 = r65.b.c0().C(r6.zza(), r7);
        r5.zzb();
        r5.zza(r0);
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0380, code lost:
        if (r0 >= r6.zzf()) goto L333;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0392, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r6.zzg(r0).zzb())) == false) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0394, code lost:
        r5.zzf(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0397, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x039a, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x039f, code lost:
        if (r0 >= r6.zzi()) goto L343;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x03b1, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r6.zzj(r0).zzb())) == false) goto L342;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x03b3, code lost:
        r5.zzh(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x03b6, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x03b9, code lost:
        r3.put(java.lang.Integer.valueOf(r4), r5.zzaA());
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x03c7, code lost:
        r0 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x03cb, code lost:
        r17 = r0;
        r20 = r1;
        r3.put(r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x03d2, code lost:
        r0 = r17;
        r1 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x0728, code lost:
        if (r11 != null) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x072a, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x0760, code lost:
        if (r11 != null) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x08f6, code lost:
        if (r13 != null) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x08f8, code lost:
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x091e, code lost:
        if (r13 == null) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x0a1e, code lost:
        r0 = r65.a.a().p();
        r6 = com.google.android.gms.measurement.internal.k3.v(r65.f3764d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x0a32, code lost:
        if (r7.zza() == false) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x0a34, code lost:
        r7 = java.lang.Integer.valueOf(r7.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x0a3d, code lost:
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x0a3e, code lost:
        r0.c("Invalid property filter ID. appId, id", r6, java.lang.String.valueOf(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0151, code lost:
        if (r5 != null) goto L509;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0153, code lost:
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0175, code lost:
        if (r5 == null) goto L522;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0228, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0229, code lost:
        r18 = "audience_id";
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x022e, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x022f, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0232, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0233, code lost:
        r18 = "audience_id";
        r19 = "data";
        r4 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x059f  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x082d  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x0a7b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b4 A[Catch: SQLiteException -> 0x0228, all -> 0x0b0b, TRY_LEAVE, TryCatch #12 {SQLiteException -> 0x0228, blocks: (B:61:0x01ae, B:63:0x01b4, B:67:0x01c4, B:68:0x01c9, B:69:0x01d3, B:70:0x01e3, B:72:0x01f2), top: B:450:0x01ae }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01c4 A[Catch: SQLiteException -> 0x0228, all -> 0x0b0b, TRY_ENTER, TryCatch #12 {SQLiteException -> 0x0228, blocks: (B:61:0x01ae, B:63:0x01b4, B:67:0x01c4, B:68:0x01c9, B:69:0x01d3, B:70:0x01e3, B:72:0x01f2), top: B:450:0x01ae }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0251  */
    /* JADX WARN: Type inference failed for: r5v45, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v47, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.internal.measurement.zzcx> k(java.lang.String r66, java.util.List<com.google.android.gms.internal.measurement.zzdb> r67, java.util.List<com.google.android.gms.internal.measurement.zzdu> r68, java.lang.Long r69, java.lang.Long r70) {
        /*
            Method dump skipped, instructions count: 2835
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ca.k(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }
}
