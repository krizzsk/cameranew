package us.pinguo.webview.f;
/* compiled from: RspParamFactory.java */
/* loaded from: classes6.dex */
public final class g {

    /* compiled from: RspParamFactory.java */
    /* loaded from: classes6.dex */
    public interface b {
        String getValue();
    }

    /* compiled from: RspParamFactory.java */
    /* loaded from: classes6.dex */
    private static class c implements b {
        private String a;

        @Override // us.pinguo.webview.f.g.b
        public String getValue() {
            return "'" + this.a + "'";
        }

        private c(String str) {
            this.a = "";
            this.a = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(String str) {
        return new c(str);
    }
}
