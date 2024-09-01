package com.a2a.commandcenter.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;

import com.a2a.commandcenter.A2aCommandCenterModel;
import com.a2a.commandcenter.IA2aOrchestrator.IA2aCCDelegates;
import com.a2a.commandcenter.model.data.UIInstruction;
import com.commandcenter.action.IAction.IDataAction.DataAction;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.TopicManagementResponse;

public class EventPollerDataDelegate extends DataAction<IA2aCCDelegates, A2aCommandCenterModel, Void, UIInstruction> {

    public EventPollerDataDelegate(A2aCommandCenterModel model) {
        super(model);
    }

    String topicName = "your-topic-name";
    String registrationToken = "your-device-registration-token";

    @Override
    public UIInstruction process(Void input) {
        try (// register for firebase events
                FileInputStream serviceAccount = new FileInputStream("path/to/serviceAccountKey.json")) {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
            TopicManagementResponse response = FirebaseMessaging.getInstance()
                    .subscribeToTopic(Collections.singletonList(registrationToken), topicName);

            System.out.println("Successfully subscribed to topic: " + topicName);
        } catch (IOException | FirebaseMessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
