package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.EncodedImageOrigin;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* compiled from: ProducerContext.java */
/* loaded from: classes.dex */
public interface o0 {
    Object a();

    <E> void b(String str, @Nullable E e2);

    void c(p0 p0Var);

    com.facebook.imagepipeline.core.j d();

    void e(@Nullable String str, @Nullable String str2);

    @Nullable
    String f();

    void g(@Nullable String str);

    Map<String, Object> getExtras();

    String getId();

    Priority getPriority();

    q0 h();

    boolean i();

    ImageRequest j();

    void k(EncodedImageOrigin encodedImageOrigin);

    void l(@Nullable Map<String, ?> map);

    boolean m();

    @Nullable
    <E> E n(String str);

    ImageRequest.RequestLevel o();
}
