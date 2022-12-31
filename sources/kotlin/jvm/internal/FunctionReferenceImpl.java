package kotlin.jvm.internal;
/* loaded from: classes3.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i2, kotlin.reflect.e eVar, String str, String str2) {
        super(i2, CallableReference.NO_RECEIVER, ((l) eVar).a(), str, str2, !(eVar instanceof kotlin.reflect.c) ? 1 : 0);
    }

    public FunctionReferenceImpl(int i2, Class cls, String str, String str2, int i3) {
        super(i2, CallableReference.NO_RECEIVER, cls, str, str2, i3);
    }

    public FunctionReferenceImpl(int i2, Object obj, Class cls, String str, String str2, int i3) {
        super(i2, obj, cls, str, str2, i3);
    }
}
