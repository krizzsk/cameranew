package com.pinguo.camera360.gallery.util;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.bigalbum.BigAlbumManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GalleryDeleteUtil.kt */
@DebugMetadata(c = "com.pinguo.camera360.gallery.util.GalleryDeleteUtil$deleteLocalDB$1", f = "GalleryDeleteUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class GalleryDeleteUtil$deleteLocalDB$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GalleryDeleteUtil$deleteLocalDB$1(Continuation<? super GalleryDeleteUtil$deleteLocalDB$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new GalleryDeleteUtil$deleteLocalDB$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((GalleryDeleteUtil$deleteLocalDB$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ArrayList arrayList;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            j.b(obj);
            arrayList = GalleryDeleteUtil.f6718d;
            if (arrayList == null) {
                return u.a;
            }
            Iterator it = arrayList.iterator();
            s.g(it, "deletes.iterator()");
            while (it.hasNext()) {
                Object next = it.next();
                s.g(next, "iterator.next()");
                b bVar = (b) next;
                if (!bVar.b()) {
                    BigAlbumManager.instance().deletePhotoBySystemDbId(bVar.a());
                }
            }
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
