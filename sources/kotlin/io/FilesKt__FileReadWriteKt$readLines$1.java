package kotlin.io;

import java.util.ArrayList;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: FileReadWrite.kt */
/* loaded from: classes3.dex */
final class FilesKt__FileReadWriteKt$readLines$1 extends Lambda implements l<String, u> {
    final /* synthetic */ ArrayList<String> $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FilesKt__FileReadWriteKt$readLines$1(ArrayList<String> arrayList) {
        super(1);
        this.$result = arrayList;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(String str) {
        invoke2(str);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String it) {
        s.h(it, "it");
        this.$result.add(it);
    }
}
