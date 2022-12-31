package cn.sharesdk.framework.authorize;

import cn.sharesdk.framework.Platform;
/* loaded from: classes.dex */
public interface AuthorizeHelper {
    AuthorizeListener getAuthorizeListener();

    String getAuthorizeUrl();

    c getAuthorizeWebviewClient(g gVar);

    Platform getPlatform();

    String getRedirectUri();

    SSOListener getSSOListener();

    e getSSOProcessor(d dVar);
}
