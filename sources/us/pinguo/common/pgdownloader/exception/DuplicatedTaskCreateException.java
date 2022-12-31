package us.pinguo.common.pgdownloader.exception;

import kotlin.jvm.internal.s;
/* compiled from: DuplicatedTaskCreateException.kt */
/* loaded from: classes4.dex */
public final class DuplicatedTaskCreateException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DuplicatedTaskCreateException(String remoteUrl, String path, boolean z) {
        super("You have the same download task with remoteUrl:" + remoteUrl + ", path:" + path + ", pathAsDir:" + z);
        s.h(remoteUrl, "remoteUrl");
        s.h(path, "path");
    }
}
