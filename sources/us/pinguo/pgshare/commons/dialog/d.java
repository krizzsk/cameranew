package us.pinguo.pgshare.commons.dialog;

import android.content.ComponentName;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
/* compiled from: ShareIntentBean.java */
/* loaded from: classes5.dex */
class d {
    public Drawable a;
    public final String b;
    public final ResolveInfo c;

    /* renamed from: d  reason: collision with root package name */
    public AsyncTask<Void, Void, Drawable> f11635d;

    public d(ResolveInfo resolveInfo, CharSequence charSequence, ComponentName componentName) {
        this.c = resolveInfo;
        this.b = charSequence.toString();
    }
}
