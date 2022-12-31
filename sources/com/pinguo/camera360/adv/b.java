package com.pinguo.camera360.adv;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.adv.e.a;
import com.pinguo.camera360.gallery.RootActivity;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import vStudio.Android.Camera360.R;
/* compiled from: AlbumBottomAdControler.java */
/* loaded from: classes3.dex */
public class b {
    private Activity a;
    private ViewGroup b;

    /* renamed from: d  reason: collision with root package name */
    private PopupWindow f6147d;
    private boolean c = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6148e = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumBottomAdControler.java */
    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC0236a {
        a() {
        }

        @Override // com.pinguo.camera360.adv.e.a.InterfaceC0236a
        public void a(int i2, String str) {
            b.this.c = false;
        }

        @Override // com.pinguo.camera360.adv.e.a.InterfaceC0236a
        public void onSuccess() {
            b.this.c = true;
            b.this.e();
        }
    }

    public b(Activity activity) {
        this.a = activity;
        this.b = new LinearLayout(activity);
        this.b.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void b() {
        if (this.f6147d == null || this.a.isFinishing()) {
            return;
        }
        this.f6147d.dismiss();
    }

    public void c() {
        com.pinguo.camera360.adv.e.a aVar = new com.pinguo.camera360.adv.e.a(this.a, IADStatisticBase.UNIT_ID_ALBUM_BOTTOM_BANNER, this.b);
        aVar.e(new a());
        aVar.g(this.a);
    }

    public void d(Boolean bool) {
        this.f6148e = bool.booleanValue();
    }

    public void e() {
        if (this.c && this.f6148e && !this.a.isFinishing()) {
            Activity activity = this.a;
            if ((activity instanceof RootActivity) && ((RootActivity) activity).I0()) {
                return;
            }
            if (this.f6147d == null) {
                PopupWindow popupWindow = new PopupWindow(this.b, -1, -2);
                this.f6147d = popupWindow;
                popupWindow.setAnimationStyle(R.style.PopupAnimation);
                this.f6147d.setBackgroundDrawable(new BitmapDrawable());
                this.f6147d.setFocusable(false);
                this.f6147d.setOutsideTouchable(true);
            }
            View findViewById = this.a.findViewById(R.id.content_res_0x7f0901de);
            PopupWindow popupWindow2 = this.f6147d;
            popupWindow2.showAtLocation(findViewById, 80, 0, 0);
            VdsAgent.showAtLocation(popupWindow2, findViewById, 80, 0, 0);
        }
    }
}
