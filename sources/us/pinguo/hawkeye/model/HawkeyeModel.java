package us.pinguo.hawkeye.model;

import com.tapjoy.TapjoyConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.f;
import kotlin.g;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.v;
import kotlin.reflect.k;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: HawkeyeModel.kt */
/* loaded from: classes4.dex */
public final class HawkeyeModel {

    /* renamed from: e  reason: collision with root package name */
    static final /* synthetic */ k[] f11161e;
    private a c;
    private final String a = "0.7.3";
    private final f b = g.b(HawkeyeModel$device$2.INSTANCE);

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, b> f11162d = new LinkedHashMap();

    static {
        PropertyReference1Impl propertyReference1Impl = new PropertyReference1Impl(v.b(HawkeyeModel.class), TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, "getDevice()Lus/pinguo/hawkeye/data/DeviceInfo;");
        v.h(propertyReference1Impl);
        f11161e = new k[]{propertyReference1Impl};
    }

    public final us.pinguo.hawkeye.d.a a() {
        f fVar = this.b;
        k kVar = f11161e[0];
        return (us.pinguo.hawkeye.d.a) fVar.getValue();
    }

    public final Map<String, b> b() {
        return this.f11162d;
    }

    public String toString() {
        Iterator<T> it;
        CharSequence I0;
        String str = "";
        while (this.f11162d.values().iterator().hasNext()) {
            str = str + ((b) it.next()).toString() + "\n";
        }
        if (str != null) {
            I0 = StringsKt__StringsKt.I0(str);
            return ("<SDK> Hawkeye-" + this.a) + "\n" + a().toString() + "\n" + this.c + "\n" + I0.toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
}
