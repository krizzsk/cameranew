package com.google.firebase.messaging;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.q;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.0.1 */
/* loaded from: classes2.dex */
public final class FirelogAnalyticsEvent {
    private final String eventType;
    private final Intent intent;

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.1 */
    /* loaded from: classes2.dex */
    static class FirelogAnalyticsEventEncoder implements ObjectEncoder<FirelogAnalyticsEvent> {
        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        public void encode(FirelogAnalyticsEvent firelogAnalyticsEvent, ObjectEncoderContext objectEncoderContext) throws EncodingException, IOException {
            Intent intent = firelogAnalyticsEvent.getIntent();
            objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_TTL, MessagingAnalytics.getTtl(intent));
            objectEncoderContext.add("event", firelogAnalyticsEvent.getEventType());
            objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_INSTANCE_ID, MessagingAnalytics.getInstanceId());
            objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_PRIORITY, MessagingAnalytics.getPriority(intent));
            objectEncoderContext.add("packageName", MessagingAnalytics.getPackageName());
            objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_SDK_PLATFORM, Constants.FirelogAnalytics.SDK_PLATFORM_ANDROID);
            objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, MessagingAnalytics.getMessageTypeForFirelog(intent));
            String messageId = MessagingAnalytics.getMessageId(intent);
            if (messageId != null) {
                objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_MESSAGE_ID, messageId);
            }
            String topic = MessagingAnalytics.getTopic(intent);
            if (topic != null) {
                objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_TOPIC, topic);
            }
            String collapseKey = MessagingAnalytics.getCollapseKey(intent);
            if (collapseKey != null) {
                objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_COLLAPSE_KEY, collapseKey);
            }
            if (MessagingAnalytics.getMessageLabel(intent) != null) {
                objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_ANALYTICS_LABEL, MessagingAnalytics.getMessageLabel(intent));
            }
            if (MessagingAnalytics.getComposerLabel(intent) != null) {
                objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_COMPOSER_LABEL, MessagingAnalytics.getComposerLabel(intent));
            }
            String projectNumber = MessagingAnalytics.getProjectNumber();
            if (projectNumber != null) {
                objectEncoderContext.add(Constants.FirelogAnalytics.PARAM_PROJECT_NUMBER, projectNumber);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-messaging@@21.0.1 */
    /* loaded from: classes2.dex */
    public static final class FirelogAnalyticsEventWrapper {
        private final FirelogAnalyticsEvent firelogAnalyticsEvent;

        /* JADX INFO: Access modifiers changed from: package-private */
        public FirelogAnalyticsEventWrapper(@NonNull FirelogAnalyticsEvent firelogAnalyticsEvent) {
            q.j(firelogAnalyticsEvent);
            this.firelogAnalyticsEvent = firelogAnalyticsEvent;
        }

        @NonNull
        FirelogAnalyticsEvent getFirelogAnalyticsEvent() {
            return this.firelogAnalyticsEvent;
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.1 */
    /* loaded from: classes2.dex */
    static final class FirelogAnalyticsEventWrapperEncoder implements ObjectEncoder<FirelogAnalyticsEventWrapper> {
        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        public void encode(FirelogAnalyticsEventWrapper firelogAnalyticsEventWrapper, ObjectEncoderContext objectEncoderContext) throws EncodingException, IOException {
            objectEncoderContext.add("messaging_client_event", firelogAnalyticsEventWrapper.getFirelogAnalyticsEvent());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirelogAnalyticsEvent(@NonNull String str, @NonNull Intent intent) {
        q.g(Constants.FirelogAnalytics.EventType.MESSAGE_DELIVERED, "evenType must be non-null");
        this.eventType = Constants.FirelogAnalytics.EventType.MESSAGE_DELIVERED;
        q.k(intent, "intent must be non-null");
        this.intent = intent;
    }

    @NonNull
    String getEventType() {
        return this.eventType;
    }

    @NonNull
    Intent getIntent() {
        return this.intent;
    }
}
