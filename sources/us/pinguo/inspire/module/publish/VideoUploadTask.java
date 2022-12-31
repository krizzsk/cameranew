package us.pinguo.inspire.module.publish;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BaseHttpStack;
import com.android.volley.toolbox.BasicNetwork;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.foundation.m.f;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.QiniuShareToken;
/* loaded from: classes9.dex */
public class VideoUploadTask {
    private String mFilePath;
    private String mMimeType;
    private Map<String, String> mParams;
    private QiniuShareToken mToken = new QiniuShareToken("video");
    private VideoUploadListener mVideoUploadListener;

    public VideoUploadTask(Map<String, String> map, String str, String str2, VideoUploadListener videoUploadListener) {
        this.mParams = map;
        this.mMimeType = str;
        this.mFilePath = str2;
        this.mVideoUploadListener = videoUploadListener;
    }

    private void addCommonParams(Map<String, String> map) {
        Map<String, String> f2 = us.pinguo.user.s0.getInstance().f(Inspire.a());
        if (f2 == null) {
            return;
        }
        for (Map.Entry<String, String> entry : f2.entrySet()) {
            map.put("x:" + entry.getKey(), entry.getValue());
        }
        us.pinguo.common.log.a.m("zhouwei", "OfflineFileTask params:" + map.toString(), new Object[0]);
        map.put("x:sig", us.pinguo.user.s0.getInstance().i(map));
    }

    private us.pinguo.foundation.m.j<String> createVolleyRequest() {
        return new f.a<String>() { // from class: us.pinguo.inspire.module.publish.VideoUploadTask.2
        }.url("https://up.qiniu.com").method(1).put(this.mParams).put("token", this.mToken.get()).put("file", new File(this.mFilePath), this.mMimeType).build();
    }

    public VideoUploadResult upload() throws Exception {
        VideoUploadListener videoUploadListener = this.mVideoUploadListener;
        if (videoUploadListener != null) {
            videoUploadListener.onUploadStart();
        }
        VideoUploadResult uploadImpl = uploadImpl();
        VideoUploadListener videoUploadListener2 = this.mVideoUploadListener;
        if (videoUploadListener2 != null) {
            if (uploadImpl != null) {
                videoUploadListener2.onFinished(true, uploadImpl);
            } else {
                videoUploadListener2.onFinished(false, null);
            }
        }
        return uploadImpl;
    }

    protected VideoUploadResult uploadImpl() throws Exception {
        BaseResponse baseResponse;
        if (!this.mToken.exists()) {
            this.mToken.refresh();
        }
        addCommonParams(this.mParams);
        us.pinguo.foundation.m.j<String> createVolleyRequest = createVolleyRequest();
        BasicNetwork basicNetwork = new BasicNetwork((BaseHttpStack) new us.pinguo.foundation.m.c((int) createVolleyRequest.getContentLength()));
        Response d2 = us.pinguo.foundation.m.f.d(createVolleyRequest, basicNetwork);
        if (!d2.isSuccess()) {
            VolleyError volleyError = d2.error;
            if ((volleyError instanceof AuthFailureError) || (volleyError.getCause() != null && (volleyError.getCause() instanceof IOException))) {
                this.mToken.refresh();
                d2 = us.pinguo.foundation.m.f.d(createVolleyRequest(), basicNetwork);
            }
        }
        if (d2 == null || !d2.isSuccess() || (baseResponse = (BaseResponse) new com.google.gson.e().k((String) d2.result, new com.google.gson.t.a<BaseResponse<VideoUploadResult>>() { // from class: us.pinguo.inspire.module.publish.VideoUploadTask.1
        }.getType())) == null || baseResponse.status != 200) {
            return null;
        }
        return (VideoUploadResult) baseResponse.data;
    }
}
