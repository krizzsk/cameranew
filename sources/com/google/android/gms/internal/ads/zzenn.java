package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzenn extends zzeno<FieldDescriptorType, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzenn(int i2) {
        super(i2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzeno
    public final void zzbgf() {
        if (!isImmutable()) {
            for (int i2 = 0; i2 < zzbkq(); i2++) {
                Map.Entry<FieldDescriptorType, Object> zzhu = zzhu(i2);
                if (((zzekw) zzhu.getKey()).zzbif()) {
                    zzhu.setValue(Collections.unmodifiableList((List) zzhu.getValue()));
                }
            }
            Iterator it = zzbkr().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (((zzekw) entry.getKey()).zzbif()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzbgf();
    }
}
