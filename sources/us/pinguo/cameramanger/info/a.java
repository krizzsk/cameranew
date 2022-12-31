package us.pinguo.cameramanger.info;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kotlin.jvm.internal.s;
/* compiled from: CameraInfo.kt */
/* loaded from: classes4.dex */
public final class a {
    private final int a;
    private final int b;
    private final MutableLiveData<b> c;

    /* renamed from: d  reason: collision with root package name */
    private final LiveData<b> f9774d;

    public a(int i2, int i3) {
        this.a = i2;
        this.b = i3;
        MutableLiveData<b> mutableLiveData = new MutableLiveData<>();
        this.c = mutableLiveData;
        this.f9774d = mutableLiveData;
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final LiveData<b> c() {
        return this.f9774d;
    }

    public final void d(b info) {
        s.h(info, "info");
        us.pinguo.common.log.a.c(s.q("setResolutionInfo", info), new Object[0]);
        this.c.postValue(info);
    }
}
