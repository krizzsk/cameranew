package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
final class e implements DynamiteModule.a {
    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.C0141a a(Context context, String str, DynamiteModule.a.b bVar) throws DynamiteModule.LoadingException {
        DynamiteModule.a.C0141a c0141a = new DynamiteModule.a.C0141a();
        c0141a.a = bVar.b(context, str);
        int a = bVar.a(context, str, true);
        c0141a.b = a;
        int i2 = c0141a.a;
        if (i2 == 0 && a == 0) {
            c0141a.c = 0;
        } else if (a >= i2) {
            c0141a.c = 1;
        } else {
            c0141a.c = -1;
        }
        return c0141a;
    }
}
