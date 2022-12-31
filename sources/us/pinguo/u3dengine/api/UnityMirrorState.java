package us.pinguo.u3dengine.api;
/* compiled from: UnityDataObject.kt */
/* loaded from: classes6.dex */
public final class UnityMirrorState {
    private static final int TRUE = 0;
    public static final UnityMirrorState INSTANCE = new UnityMirrorState();
    private static final int FALSE = 1;

    private UnityMirrorState() {
    }

    public final int getFALSE() {
        return FALSE;
    }

    public final int getTRUE() {
        return TRUE;
    }
}
