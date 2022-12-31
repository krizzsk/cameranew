package com.bytedance.sdk.openadsdk.f.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LogUploaderImplEmpty.java */
/* loaded from: classes.dex */
public class e implements a {
    private static volatile e a;

    private e() {
    }

    public static e c() {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e();
                }
            }
        }
        return a;
    }

    @Override // com.bytedance.sdk.openadsdk.f.b.a
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.f.b.a
    public void a(com.bytedance.sdk.openadsdk.f.a.a aVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.f.b.a
    public void a(com.bytedance.sdk.openadsdk.f.a.a aVar, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.f.b.a
    public void b() {
    }
}
