package us.pinguo.repository2020.database.sticker;

import us.pinguo.repository2020.u;
/* compiled from: StickerProgressLiveData.kt */
/* loaded from: classes6.dex */
public final class d extends u<Integer> {
    private volatile int a;

    public final int a() {
        return this.a;
    }

    public void b(int i2) {
        if (i2 <= this.a) {
            return;
        }
        this.a = i2;
        super.postValue(Integer.valueOf(i2));
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public /* bridge */ /* synthetic */ void postValue(Object obj) {
        b(((Number) obj).intValue());
    }
}
