package com.bytedance.sdk.a.b.a.e;

import java.io.IOException;
import java.util.List;
/* compiled from: PushObserver.java */
/* loaded from: classes.dex */
public interface m {
    public static final m a = new m() { // from class: com.bytedance.sdk.a.b.a.e.m.1
        @Override // com.bytedance.sdk.a.b.a.e.m
        public void a(int i2, b bVar) {
        }

        @Override // com.bytedance.sdk.a.b.a.e.m
        public boolean a(int i2, com.bytedance.sdk.a.a.e eVar, int i3, boolean z) throws IOException {
            eVar.h(i3);
            return true;
        }

        @Override // com.bytedance.sdk.a.b.a.e.m
        public boolean a(int i2, List<c> list) {
            return true;
        }

        @Override // com.bytedance.sdk.a.b.a.e.m
        public boolean a(int i2, List<c> list, boolean z) {
            return true;
        }
    };

    void a(int i2, b bVar);

    boolean a(int i2, com.bytedance.sdk.a.a.e eVar, int i3, boolean z) throws IOException;

    boolean a(int i2, List<c> list);

    boolean a(int i2, List<c> list, boolean z);
}
