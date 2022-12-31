package com.google.android.gms.cloudmessaging;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class s implements com.google.android.gms.tasks.a {
    static final com.google.android.gms.tasks.a a = new s();

    private s() {
    }

    @Override // com.google.android.gms.tasks.a
    public final Object then(com.google.android.gms.tasks.g gVar) {
        return Rpc.b(gVar);
    }
}
