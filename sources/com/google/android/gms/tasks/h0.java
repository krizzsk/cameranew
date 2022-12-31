package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
public final class h0 implements a<Void, g<List<g<?>>>> {
    private final /* synthetic */ Collection a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(Collection collection) {
        this.a = collection;
    }

    @Override // com.google.android.gms.tasks.a
    public final /* synthetic */ g<List<g<?>>> then(@NonNull g<Void> gVar) throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.a);
        return j.e(arrayList);
    }
}
