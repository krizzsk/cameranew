package com.pinguo.camera360.adv.e.c;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import vStudio.Android.Camera360.R;
/* compiled from: BaseResultBanner.java */
/* loaded from: classes3.dex */
public abstract class c<T> extends us.pinguo.admobvista.d.a {

    /* renamed from: e  reason: collision with root package name */
    protected SimpleDraweeView f6157e;

    /* renamed from: f  reason: collision with root package name */
    protected TextView f6158f;

    /* renamed from: g  reason: collision with root package name */
    protected TextView f6159g;

    /* renamed from: h  reason: collision with root package name */
    protected TextView f6160h;

    /* renamed from: i  reason: collision with root package name */
    protected SimpleDraweeView f6161i;

    /* renamed from: j  reason: collision with root package name */
    protected ViewGroup f6162j;

    /* renamed from: k  reason: collision with root package name */
    protected ViewGroup f6163k;

    /* renamed from: l  reason: collision with root package name */
    protected T f6164l;
    protected ViewGroup m;

    public c(Activity activity, T t, ViewGroup viewGroup) {
        super(activity, viewGroup);
        this.f6164l = t;
        i();
    }

    private void i() {
        ViewGroup h2 = h();
        this.f6163k = h2;
        if (h2 != null && this.f6164l != null) {
            this.f6157e = (SimpleDraweeView) h2.findViewById(R.id.adv_banner);
            this.f6161i = (SimpleDraweeView) this.f6163k.findViewById(R.id.adv_icon);
            this.f6158f = (TextView) this.f6163k.findViewById(R.id.adv_title);
            this.f6159g = (TextView) this.f6163k.findViewById(R.id.adv_subtitle);
            this.f6160h = (TextView) this.f6163k.findViewById(R.id.adv_btn);
            this.f6162j = (ViewGroup) this.f6163k.findViewById(R.id.adv_choice_parent);
            this.m = (ViewGroup) this.f6163k.findViewById(R.id.layout_video);
            RelativeLayout relativeLayout = (RelativeLayout) this.f6163k.findViewById(R.id.adv_icon_container);
            return;
        }
        this.f6163k = null;
    }

    @Override // us.pinguo.admobvista.d.a
    public void a() {
        if (this.f6163k == null) {
            return;
        }
        l();
        o();
        k();
        n();
        m();
        e();
        j();
    }

    public abstract void e();

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList<View> f() {
        ArrayList<View> arrayList = new ArrayList<>();
        SimpleDraweeView simpleDraweeView = this.f6161i;
        if (simpleDraweeView != null) {
            arrayList.add(simpleDraweeView);
        }
        TextView textView = this.f6160h;
        if (textView != null) {
            arrayList.add(textView);
        }
        TextView textView2 = this.f6158f;
        if (textView2 != null) {
            arrayList.add(textView2);
        }
        TextView textView3 = this.f6159g;
        if (textView3 != null) {
            arrayList.add(textView3);
        }
        SimpleDraweeView simpleDraweeView2 = this.f6157e;
        if (simpleDraweeView2 != null) {
            arrayList.add(simpleDraweeView2);
        }
        return arrayList;
    }

    public abstract int g();

    public ViewGroup h() {
        T t;
        if (this.b == null || (t = this.f6164l) == null || t == null) {
            return null;
        }
        ViewGroup viewGroup = this.f6163k;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (g() == 0) {
            return null;
        }
        return (ViewGroup) LayoutInflater.from(this.b).inflate(g(), (ViewGroup) null);
    }

    public abstract void j();

    public abstract void k();

    public abstract void l();

    public abstract void m();

    public abstract void n();

    public abstract void o();
}
