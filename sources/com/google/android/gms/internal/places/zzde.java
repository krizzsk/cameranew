package com.google.android.gms.internal.places;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzde extends zzdb<FieldDescriptorType, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzde(int i2) {
        super(i2, null);
    }

    @Override // com.google.android.gms.internal.places.zzdb
    public final void zzab() {
        if (!isImmutable()) {
            for (int i2 = 0; i2 < zzcu(); i2++) {
                Map.Entry<FieldDescriptorType, Object> zzam = zzam(i2);
                if (((zzax) zzam.getKey()).zzaz()) {
                    zzam.setValue(Collections.unmodifiableList((List) zzam.getValue()));
                }
            }
            Iterator it = zzcv().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (((zzax) entry.getKey()).zzaz()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzab();
    }
}
