package d.c.a.c.a;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.a;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
final class d extends a.AbstractC0134a<com.google.android.gms.signin.internal.a, a> {
    @Override // com.google.android.gms.common.api.a.AbstractC0134a
    public final /* synthetic */ com.google.android.gms.signin.internal.a a(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, a aVar, GoogleApiClient.a aVar2, GoogleApiClient.b bVar) {
        a aVar3 = aVar;
        if (aVar3 == null) {
            aVar3 = a.f8500j;
        }
        return new com.google.android.gms.signin.internal.a(context, looper, true, dVar, aVar3, aVar2, bVar);
    }
}
