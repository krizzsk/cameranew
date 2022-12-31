package us.pinguo.advsdk.network;

import us.pinguo.advsdk.bean.BaseBean;
/* compiled from: AbsVolleyCallback.java */
/* loaded from: classes3.dex */
public abstract class a<T> {
    protected Class<? extends BaseBean> a;

    public a(Class<? extends BaseBean> cls) {
        this.a = cls;
    }

    public Class<? extends BaseBean> a() {
        return this.a;
    }

    public abstract void b(int i2, String str);

    public abstract void c(T t);
}
