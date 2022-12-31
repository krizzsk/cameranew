package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.k;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.cache.r;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.core.h;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class PipelineDraweeControllerBuilderSupplier implements k<e> {
    private final Context a;
    private final h b;
    private final f c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<com.facebook.drawee.controller.c> f2451d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<com.facebook.fresco.ui.common.b> f2452e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final com.facebook.drawee.backends.pipeline.h.f f2453f;

    public PipelineDraweeControllerBuilderSupplier(Context context) {
        this(context, null);
    }

    @Override // com.facebook.common.internal.k
    /* renamed from: a */
    public e get() {
        return new e(this.a, this.c, this.b, this.f2451d, this.f2452e).J(this.f2453f);
    }

    public PipelineDraweeControllerBuilderSupplier(Context context, @Nullable b bVar) {
        this(context, ImagePipelineFactory.getInstance(), bVar);
    }

    public PipelineDraweeControllerBuilderSupplier(Context context, ImagePipelineFactory imagePipelineFactory, @Nullable b bVar) {
        this(context, imagePipelineFactory, null, null, bVar);
    }

    public PipelineDraweeControllerBuilderSupplier(Context context, ImagePipelineFactory imagePipelineFactory, Set<com.facebook.drawee.controller.c> set, Set<com.facebook.fresco.ui.common.b> set2, @Nullable b bVar) {
        this.a = context;
        h j2 = imagePipelineFactory.j();
        this.b = j2;
        if (bVar == null) {
            f fVar = new f();
            this.c = fVar;
            Resources resources = context.getResources();
            DeferredReleaser deferredReleaser = DeferredReleaser.getInstance();
            com.facebook.imagepipeline.c.a b = imagePipelineFactory.b(context);
            UiThreadImmediateExecutorService uiThreadImmediateExecutorService = UiThreadImmediateExecutorService.getInstance();
            r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> g2 = j2.g();
            if (bVar != null) {
                bVar.a();
                throw null;
            } else if (bVar == null) {
                fVar.a(resources, deferredReleaser, b, uiThreadImmediateExecutorService, g2, null, null);
                this.f2451d = set;
                this.f2452e = set2;
                if (bVar == null) {
                    this.f2453f = null;
                    return;
                } else {
                    bVar.c();
                    throw null;
                }
            } else {
                bVar.b();
                throw null;
            }
        }
        bVar.d();
        throw null;
    }
}
