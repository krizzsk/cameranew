package com.growingio.android.sdk.monitor.event.helper;

import com.growingio.android.sdk.monitor.MonitorClient;
import com.growingio.android.sdk.monitor.context.Context;
import com.growingio.android.sdk.monitor.event.Breadcrumb;
import com.growingio.android.sdk.monitor.event.EventBuilder;
import com.growingio.android.sdk.monitor.event.User;
import com.growingio.android.sdk.monitor.event.interfaces.UserInterface;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class ContextBuilderHelper implements EventBuilderHelper {
    private MonitorClient mMonitorClient;

    public ContextBuilderHelper(MonitorClient monitorClient) {
        this.mMonitorClient = monitorClient;
    }

    private UserInterface fromUser(User user) {
        return new UserInterface(user.getId(), user.getUsername(), user.getData());
    }

    @Override // com.growingio.android.sdk.monitor.event.helper.EventBuilderHelper
    public void helpBuildingEvent(EventBuilder eventBuilder) {
        Context context = this.mMonitorClient.getContext();
        List<Breadcrumb> breadcrumbs = context.getBreadcrumbs();
        if (!breadcrumbs.isEmpty()) {
            eventBuilder.withBreadcrumbs(breadcrumbs);
        }
        if (context.getUser() != null) {
            eventBuilder.withMonitorInterface(fromUser(context.getUser()));
        }
        Map<String, String> tags = context.getTags();
        if (!tags.isEmpty()) {
            for (Map.Entry<String, String> entry : tags.entrySet()) {
                eventBuilder.withTag(entry.getKey(), entry.getValue());
            }
        }
        Map<String, Object> extra = context.getExtra();
        if (extra.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry2 : extra.entrySet()) {
            eventBuilder.withExtra(entry2.getKey(), entry2.getValue());
        }
    }
}
