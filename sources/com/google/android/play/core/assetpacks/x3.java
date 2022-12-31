package com.google.android.play.core.assetpacks;

import android.os.ParcelFileDescriptor;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public interface x3 {
    com.google.android.play.core.tasks.d<e> a(List<String> list, List<String> list2, Map<String, Long> map);

    com.google.android.play.core.tasks.d<List<String>> a(Map<String, Long> map);

    void a();

    void a(int i2);

    void a(int i2, String str);

    void a(String str);

    void a(List<String> list);

    com.google.android.play.core.tasks.d<ParcelFileDescriptor> b(int i2, String str, String str2, int i3);

    void c(int i2, String str, String str2, int i3);

    com.google.android.play.core.tasks.d<e> d(List<String> list, h0 h0Var, Map<String, Long> map);
}
