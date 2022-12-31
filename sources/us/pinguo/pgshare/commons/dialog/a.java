package us.pinguo.pgshare.commons.dialog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import us.pinguo.pgshare.commons.dialog.SheetContentView;
import us.pinguo.share.core.ShareSite;
/* compiled from: PGShareBottomSheetDialog.java */
/* loaded from: classes5.dex */
public class a implements us.pinguo.pgshare.commons.c {
    private BottomSheetDialog a;
    private SheetContentView b;
    private us.pinguo.pgshare.commons.f c;

    /* renamed from: d  reason: collision with root package name */
    private List<b> f11632d;

    /* renamed from: e  reason: collision with root package name */
    private us.pinguo.pgshare.commons.b f11633e;

    /* compiled from: PGShareBottomSheetDialog.java */
    /* renamed from: us.pinguo.pgshare.commons.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0427a implements SheetContentView.d {
        C0427a() {
        }

        @Override // us.pinguo.pgshare.commons.dialog.SheetContentView.d
        public void onItemClick(View view, int i2) {
            if (a.this.f11633e != null) {
                b bVar = (b) a.this.f11632d.get(i2);
                int i3 = bVar.a;
                if (i3 == 1) {
                    a.this.f11633e.c(a.this, bVar.c.c);
                } else if (i3 == 0) {
                    a.this.f11633e.b(a.this, bVar.b.c);
                } else if (i3 == 4) {
                    a.this.f11633e.a(a.this, bVar.f11634d.c);
                }
            }
        }
    }

    public a(us.pinguo.pgshare.commons.f fVar) {
        this.c = fVar;
    }

    private List<d> d(Context context) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType(this.c.c());
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
            if (!this.c.a().a(resolveInfo)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                arrayList.add(new d(resolveInfo, resolveInfo.loadLabel(packageManager), new ComponentName(activityInfo.packageName, activityInfo.name)));
            }
        }
        return arrayList;
    }

    private List<f> e() {
        ArrayList arrayList = new ArrayList();
        for (ShareSite shareSite : this.c.d()) {
            arrayList.add(new f(shareSite));
        }
        return arrayList;
    }

    private List<b> f(Context context) {
        ArrayList arrayList = new ArrayList();
        List<c> b = this.c.b();
        for (c cVar : b) {
            b bVar = new b();
            bVar.a = 4;
            bVar.f11634d = cVar;
            arrayList.add(bVar);
        }
        List<f> e2 = e();
        for (f fVar : e2) {
            b bVar2 = new b();
            bVar2.a = 1;
            bVar2.c = fVar;
            arrayList.add(bVar2);
        }
        if (!TextUtils.isEmpty(this.c.c())) {
            int size = (e2.size() + (b != null ? b.size() : 0)) % 3;
            if (size != 0) {
                for (int i2 = 0; i2 < 3 - size; i2++) {
                    b bVar3 = new b();
                    bVar3.a = 3;
                    arrayList.add(bVar3);
                }
            }
            List<d> d2 = d(context);
            if (d2 != null && d2.size() > 0) {
                if (arrayList.size() > 0) {
                    b bVar4 = new b();
                    bVar4.a = 2;
                    arrayList.add(bVar4);
                }
                for (d dVar : d2) {
                    b bVar5 = new b();
                    bVar5.a = 0;
                    bVar5.b = dVar;
                    arrayList.add(bVar5);
                }
            }
        }
        return arrayList;
    }

    private boolean g(Context context) {
        this.a = new BottomSheetDialog(context);
        this.b = new SheetContentView(context);
        return true;
    }

    public void c(Context context) {
        Objects.requireNonNull(context, "context can not be null");
        g(context);
        this.b.g(new C0427a());
        List<b> f2 = f(context);
        this.f11632d = f2;
        this.b.f(f2);
        this.a.setContentView(this.b);
    }

    @Override // us.pinguo.pgshare.commons.c
    public void dismiss() {
        BottomSheetDialog bottomSheetDialog = this.a;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.dismiss();
        }
    }

    public void h(us.pinguo.pgshare.commons.b bVar) {
        this.f11633e = bVar;
    }

    public void i() {
        BottomSheetDialog bottomSheetDialog = this.a;
        if (bottomSheetDialog == null || this.b == null) {
            return;
        }
        bottomSheetDialog.show();
        VdsAgent.showDialog(bottomSheetDialog);
    }
}
