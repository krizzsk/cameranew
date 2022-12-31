package us.pinguo.inspire.module.publish;
/* loaded from: classes9.dex */
public interface VideoUploadListener {
    void onFinished(boolean z, VideoUploadResult videoUploadResult);

    void onProgress(Integer... numArr);

    void onUploadStart();
}
