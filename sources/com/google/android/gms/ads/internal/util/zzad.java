package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzazk;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzad {
    private final Context a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f3468d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private String f3469e;

    /* renamed from: f  reason: collision with root package name */
    private int f3470f;

    /* renamed from: g  reason: collision with root package name */
    private int f3471g;

    /* renamed from: h  reason: collision with root package name */
    private PointF f3472h;

    /* renamed from: i  reason: collision with root package name */
    private PointF f3473i;

    /* renamed from: j  reason: collision with root package name */
    private Handler f3474j;

    /* renamed from: k  reason: collision with root package name */
    private Runnable f3475k;

    public zzad(Context context) {
        this.f3470f = 0;
        this.f3475k = new Runnable(this) { // from class: com.google.android.gms.ads.internal.util.c
            private final zzad a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.g();
            }
        };
        this.a = context;
        this.f3471g = ViewConfiguration.get(context).getScaledTouchSlop();
        com.google.android.gms.ads.internal.zzr.zzlf().zzzp();
        this.f3474j = com.google.android.gms.ads.internal.zzr.zzlf().getHandler();
    }

    private static int a(List<String> list, String str, boolean z) {
        list.add(str);
        return list.size() - 1;
    }

    private final boolean d(float f2, float f3, float f4, float f5) {
        return Math.abs(this.f3472h.x - f2) < ((float) this.f3471g) && Math.abs(this.f3472h.y - f3) < ((float) this.f3471g) && Math.abs(this.f3473i.x - f4) < ((float) this.f3471g) && Math.abs(this.f3473i.y - f5) < ((float) this.f3471g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x006e, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ void b(int r1, int r2, int r3, android.content.DialogInterface r4, int r5) {
        /*
            r0 = this;
            if (r5 != r1) goto L9e
            android.content.Context r1 = r0.a
            boolean r1 = r1 instanceof android.app.Activity
            if (r1 != 0) goto Le
            java.lang.String r1 = "Can not create dialog without Activity Context"
            com.google.android.gms.internal.ads.zzazk.zzew(r1)
            return
        Le:
            java.lang.String r1 = r0.b
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L71
            java.lang.String r2 = "\\+"
            java.lang.String r3 = "%20"
            java.lang.String r1 = r1.replaceAll(r2, r3)
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            android.net.Uri$Builder r1 = r2.encodedQuery(r1)
            android.net.Uri r1 = r1.build()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.google.android.gms.ads.internal.zzr.zzkr()
            java.util.Map r1 = com.google.android.gms.ads.internal.util.zzj.zzg(r1)
            java.util.Set r3 = r1.keySet()
            java.util.Iterator r3 = r3.iterator()
        L3f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L62
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r5 = " = "
            r2.append(r5)
            java.lang.Object r4 = r1.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r4 = "\n\n"
            r2.append(r4)
            goto L3f
        L62:
            java.lang.String r1 = r2.toString()
            java.lang.String r1 = r1.trim()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L71
            goto L73
        L71:
            java.lang.String r1 = "No debug information"
        L73:
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            android.content.Context r3 = r0.a
            r2.<init>(r3)
            r2.setMessage(r1)
            java.lang.String r3 = "Ad Information"
            r2.setTitle(r3)
            com.google.android.gms.ads.internal.util.e r3 = new com.google.android.gms.ads.internal.util.e
            r3.<init>(r0, r1)
            java.lang.String r1 = "Share"
            r2.setPositiveButton(r1, r3)
            android.content.DialogInterface$OnClickListener r1 = com.google.android.gms.ads.internal.util.d.a
            java.lang.String r3 = "Close"
            r2.setNegativeButton(r3, r1)
            android.app.AlertDialog r1 = r2.create()
            r1.show()
            com.growingio.android.sdk.autoburry.VdsAgent.showDialog(r1)
            return
        L9e:
            if (r5 != r2) goto Lb0
            java.lang.String r1 = "Debug mode [Creative Preview] selected."
            com.google.android.gms.internal.ads.zzazk.zzdy(r1)
            com.google.android.gms.internal.ads.zzdzv r1 = com.google.android.gms.internal.ads.zzazp.zzeic
            com.google.android.gms.ads.internal.util.g r2 = new com.google.android.gms.ads.internal.util.g
            r2.<init>(r0)
            r1.execute(r2)
            return
        Lb0:
            if (r5 != r3) goto Lc1
            java.lang.String r1 = "Debug mode [Troubleshooting] selected."
            com.google.android.gms.internal.ads.zzazk.zzdy(r1)
            com.google.android.gms.internal.ads.zzdzv r1 = com.google.android.gms.internal.ads.zzazp.zzeic
            com.google.android.gms.ads.internal.util.f r2 = new com.google.android.gms.ads.internal.util.f
            r2.<init>(r0)
            r1.execute(r2)
        Lc1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzad.b(int, int, int, android.content.DialogInterface, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c(String str, DialogInterface dialogInterface, int i2) {
        com.google.android.gms.ads.internal.zzr.zzkr();
        zzj.zza(this.a, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void e() {
        com.google.android.gms.ads.internal.zzr.zzlb().zza(this.a, this.c, this.f3468d, this.f3469e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void f() {
        com.google.android.gms.ads.internal.zzr.zzlb().zze(this.a, this.c, this.f3468d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void g() {
        this.f3470f = 4;
        showDialog();
    }

    public final void setAdUnitId(String str) {
        this.c = str;
    }

    public final void showDialog() {
        try {
            if (!(this.a instanceof Activity)) {
                zzazk.zzew("Can not create dialog without Activity Context");
                return;
            }
            String str = !TextUtils.isEmpty(com.google.android.gms.ads.internal.zzr.zzlb().zzzl()) ? "Creative Preview (Enabled)" : "Creative Preview";
            String str2 = com.google.android.gms.ads.internal.zzr.zzlb().zzzm() ? "Troubleshooting (Enabled)" : "Troubleshooting";
            ArrayList arrayList = new ArrayList();
            final int a = a(arrayList, "Ad Information", true);
            final int a2 = a(arrayList, str, true);
            final int a3 = a(arrayList, str2, true);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a, com.google.android.gms.ads.internal.zzr.zzkt().zzzf());
            builder.setTitle("Select a Debug Mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener(this, a, a2, a3) { // from class: com.google.android.gms.ads.internal.util.b
                private final zzad a;
                private final int b;
                private final int c;

                /* renamed from: d  reason: collision with root package name */
                private final int f3466d;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                    this.b = a;
                    this.c = a2;
                    this.f3466d = a3;
                }

                @Override // android.content.DialogInterface.OnClickListener
                @Instrumented
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    VdsAgent.onClick(this, dialogInterface, i2);
                    this.a.b(this.b, this.c, this.f3466d, dialogInterface, i2);
                }
            });
            AlertDialog create = builder.create();
            create.show();
            VdsAgent.showDialog(create);
        } catch (WindowManager.BadTokenException e2) {
            zzd.zza("", e2);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.b);
        sb.append(",DebugSignal: ");
        sb.append(this.f3469e);
        sb.append(",AFMA Version: ");
        sb.append(this.f3468d);
        sb.append(",Ad Unit ID: ");
        sb.append(this.c);
        sb.append("}");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzd(android.view.MotionEvent r11) {
        /*
            r10 = this;
            int r0 = r11.getActionMasked()
            int r1 = r11.getHistorySize()
            int r2 = r11.getPointerCount()
            r3 = 0
            if (r0 != 0) goto L21
            r10.f3470f = r3
            android.graphics.PointF r0 = new android.graphics.PointF
            float r1 = r11.getX(r3)
            float r11 = r11.getY(r3)
            r0.<init>(r1, r11)
            r10.f3472h = r0
            return
        L21:
            int r4 = r10.f3470f
            r5 = -1
            if (r4 != r5) goto L27
            return
        L27:
            r6 = 5
            r7 = 1
            if (r4 != 0) goto L56
            if (r0 != r6) goto L56
            r10.f3470f = r6
            android.graphics.PointF r0 = new android.graphics.PointF
            float r1 = r11.getX(r7)
            float r11 = r11.getY(r7)
            r0.<init>(r1, r11)
            r10.f3473i = r0
            android.os.Handler r11 = r10.f3474j
            java.lang.Runnable r0 = r10.f3475k
            com.google.android.gms.internal.ads.zzaba<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzabp.zzcuv
            com.google.android.gms.internal.ads.zzabl r2 = com.google.android.gms.internal.ads.zzwr.zzqr()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            r11.postDelayed(r0, r1)
            return
        L56:
            if (r4 != r6) goto La0
            r4 = 2
            if (r2 == r4) goto L5d
        L5b:
            r3 = 1
            goto L95
        L5d:
            if (r0 != r4) goto L95
            r0 = 0
            r2 = 0
        L61:
            if (r0 >= r1) goto L7d
            float r4 = r11.getHistoricalX(r3, r0)
            float r6 = r11.getHistoricalY(r3, r0)
            float r8 = r11.getHistoricalX(r7, r0)
            float r9 = r11.getHistoricalY(r7, r0)
            boolean r4 = r10.d(r4, r6, r8, r9)
            if (r4 != 0) goto L7a
            r2 = 1
        L7a:
            int r0 = r0 + 1
            goto L61
        L7d:
            float r0 = r11.getX()
            float r1 = r11.getY()
            float r3 = r11.getX(r7)
            float r11 = r11.getY(r7)
            boolean r11 = r10.d(r0, r1, r3, r11)
            if (r11 != 0) goto L94
            goto L5b
        L94:
            r3 = r2
        L95:
            if (r3 == 0) goto La0
            r10.f3470f = r5
            android.os.Handler r11 = r10.f3474j
            java.lang.Runnable r0 = r10.f3475k
            r11.removeCallbacks(r0)
        La0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzad.zzd(android.view.MotionEvent):void");
    }

    public final void zzem(String str) {
        this.b = str;
    }

    public final void zzen(String str) {
        this.f3469e = str;
    }

    public final void zzu(String str) {
        this.f3468d = str;
    }

    public zzad(Context context, String str) {
        this(context);
        this.b = str;
    }
}
