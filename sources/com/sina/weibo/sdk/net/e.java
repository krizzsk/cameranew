package com.sina.weibo.sdk.net;

import android.os.Bundle;
import com.tencent.bugly.BuglyStrategy;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public final class e implements d {

    /* renamed from: k  reason: collision with root package name */
    private Bundle f7175k = new Bundle();

    /* renamed from: l  reason: collision with root package name */
    private Bundle f7176l = new Bundle();
    private Map<String, Object<File>> m = new HashMap();
    private Map<String, byte[]> n = new HashMap();
    private int o;
    private int p;
    private String url;

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: k  reason: collision with root package name */
        Bundle f7177k = new Bundle();

        /* renamed from: l  reason: collision with root package name */
        Bundle f7178l = new Bundle();
        Map<String, Object<File>> m = new HashMap();
        Map<String, byte[]> n = new HashMap();
        int o = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        int p = 60000;
        public String url;

        public final a a(String str, Object obj) {
            a(this.f7177k, str, obj);
            return this;
        }

        public final a b(String str, Object obj) {
            a(this.f7178l, str, obj);
            return this;
        }

        public final e i() {
            return new e(this);
        }

        private void a(Bundle bundle, String str, Object obj) {
            if (obj != null) {
                if (obj instanceof String) {
                    bundle.putString(str, String.valueOf(obj));
                } else if (obj instanceof Integer) {
                    bundle.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Short) {
                    bundle.putShort(str, ((Short) obj).shortValue());
                } else if (obj instanceof Character) {
                    bundle.putChar(str, ((Character) obj).charValue());
                } else if (obj instanceof Byte) {
                    bundle.putByte(str, ((Byte) obj).byteValue());
                } else if (obj instanceof Long) {
                    bundle.putLong(str, ((Long) obj).longValue());
                } else if (obj instanceof Float) {
                    bundle.putFloat(str, ((Float) obj).floatValue());
                } else if (obj instanceof Double) {
                    bundle.putDouble(str, ((Double) obj).doubleValue());
                } else if (obj instanceof Boolean) {
                    bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof byte[]) {
                    this.n.put(str, (byte[]) obj);
                } else if (obj instanceof Serializable) {
                    bundle.putSerializable(str, (Serializable) obj);
                } else {
                    throw new IllegalArgumentException("Unsupported params type!");
                }
            }
        }
    }

    public e(a aVar) {
        this.url = aVar.url;
        this.f7175k.putAll(aVar.f7177k);
        this.f7176l.putAll(aVar.f7178l);
        this.m.putAll(aVar.m);
        this.n.putAll(aVar.n);
        this.o = aVar.o;
        this.p = aVar.p;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final int getConnectTimeout() {
        return this.o;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final Bundle getParams() {
        return this.f7175k;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final int getReadTimeout() {
        return this.p;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final String getUrl() {
        return this.url;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final Bundle h() {
        return this.f7176l;
    }
}
