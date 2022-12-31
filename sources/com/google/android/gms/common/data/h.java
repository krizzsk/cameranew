package com.google.android.gms.common.data;

import android.content.ContentValues;
import com.google.android.gms.common.data.DataHolder;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class h extends DataHolder.a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String[] strArr, String str) {
        super(strArr, null, null);
    }

    @Override // com.google.android.gms.common.data.DataHolder.a
    public final DataHolder.a a(ContentValues contentValues) {
        throw new UnsupportedOperationException("Cannot add data to empty builder");
    }

    @Override // com.google.android.gms.common.data.DataHolder.a
    public final DataHolder.a b(HashMap<String, Object> hashMap) {
        throw new UnsupportedOperationException("Cannot add data to empty builder");
    }
}
