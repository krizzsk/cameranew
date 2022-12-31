package us.pinguo.advsdk.a;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import us.pinguo.advsdk.a.b;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: AbsNativeRequest.java */
/* loaded from: classes3.dex */
public abstract class a<T extends b> {
    protected ArrayList<T> a;
    protected k c;

    /* renamed from: d  reason: collision with root package name */
    protected WeakReference<Context> f9033d;

    /* renamed from: e  reason: collision with root package name */
    protected AdsItem f9034e;
    protected boolean b = false;

    /* renamed from: f  reason: collision with root package name */
    protected HashMap<String, Object> f9035f = new HashMap<>();

    public Object g(String str) {
        return this.f9035f.get(str);
    }

    public abstract int h();

    public abstract boolean i();

    public void j(String str, Object obj) {
        this.f9035f.put(str, obj);
    }

    public abstract void k(Context context, k kVar, us.pinguo.advsdk.bean.b bVar, AdsItem adsItem);
}
