package us.pinguo.user.util;
/* compiled from: VerificationUtil.kt */
/* loaded from: classes6.dex */
public interface g {

    /* compiled from: VerificationUtil.kt */
    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ void a(g gVar, BaseInfoResult baseInfoResult, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFetchBaseInfo");
            }
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            gVar.onFetchBaseInfo(baseInfoResult, i2);
        }
    }

    void onFetchBaseInfo(BaseInfoResult baseInfoResult, int i2);
}
