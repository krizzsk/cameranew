package com.huawei.hianalytics.b;

import android.content.Context;
import android.util.Log;
/* loaded from: classes2.dex */
public final class d extends a {
    private d() {
    }

    public static f a() {
        return new d();
    }

    @Override // com.huawei.hianalytics.b.f
    public f a(Context context, String str) {
        f fVar = this.a;
        if (fVar != null) {
            fVar.a(context, str);
        }
        return this;
    }

    @Override // com.huawei.hianalytics.b.f
    public void a(String str, int i2, String str2, String str3) {
        if (str == null) {
            return;
        }
        if (i2 != 3) {
            if (i2 != 4) {
                if (i2 == 5) {
                    Log.w(str2, str);
                } else if (i2 == 6) {
                    Log.e(str2, str);
                }
            }
            Log.i(str2, str);
        } else {
            Log.d(str2, str);
        }
        f fVar = this.a;
        if (fVar != null) {
            fVar.a(str, i2, str2, str3);
        }
    }
}
