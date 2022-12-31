package us.pinguo.repository2020;

import android.content.Context;
import us.pinguo.repository2020.entity.ClassifyDefault;
import us.pinguo.repository2020.entity.ClassifyDefaultResponse;
import us.pinguo.repository2020.network.ApiClassifyDefault;
import us.pinguo.repository2020.network.HttpBaseResponse;
/* compiled from: ClassifyDefaultRepository.kt */
/* loaded from: classes6.dex */
public final class n {
    public static final a a = new a(null);
    private static ClassifyDefault[] b;

    /* compiled from: ClassifyDefaultRepository.kt */
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final ClassifyDefault[] a() {
            return n.b;
        }

        public final void b(ClassifyDefault[] classifyDefaultArr) {
            n.b = classifyDefaultArr;
        }
    }

    /* compiled from: ClassifyDefaultRepository.kt */
    /* loaded from: classes6.dex */
    public static final class b extends j.a.c.b.d<HttpBaseResponse<ClassifyDefaultResponse>> {
        b() {
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(HttpBaseResponse<ClassifyDefaultResponse> classifyDefaultResponse) {
            kotlin.jvm.internal.s.h(classifyDefaultResponse, "classifyDefaultResponse");
            a aVar = n.a;
            ClassifyDefaultResponse data = classifyDefaultResponse.getData();
            aVar.b(data == null ? null : data.getLists());
        }

        @Override // j.a.c.b.d
        public void onError(Exception e2) {
            kotlin.jvm.internal.s.h(e2, "e");
            us.pinguo.common.log.a.e(e2.toString(), new Object[0]);
        }
    }

    public final void c(Context ctx) {
        kotlin.jvm.internal.s.h(ctx, "ctx");
        new ApiClassifyDefault(ctx).get(new b());
    }
}
