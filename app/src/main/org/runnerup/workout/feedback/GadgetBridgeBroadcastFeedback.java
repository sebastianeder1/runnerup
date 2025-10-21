package org.runnerup.workout.feedback;

import android.content.Context;
import android.content.Intent;

import org.runnerup.workout.Feedback;
import org.runnerup.workout.Workout;

public class GadgetBridgeBroadcastFeedback extends Feedback {

    private String _sender;
    private String _subject;
    private String _body;
    public GadgetBridgeBroadcastFeedback(String sender,String subject, String body){
        this._sender = sender;
        this._subject = subject;
        this._body = body;
    }
    @Override
    public boolean equals(Feedback other) {
        return other instanceof CountdownFeedback;
    }

    @Override
    public void emit(Workout s, Context ctx) {
        Intent intent = new Intent("nodomain.freeyourgadget.gadgetbridge.command.DEBUG_SEND_NOTIFICATION");
        intent.putExtra("sender", _sender);
        intent.putExtra("subject", _subject);
        intent.putExtra("body", _body);
        intent.setPackage("nodomain.freeyourgadget.gadgetbridge");
        ctx.sendBroadcast(intent);
    }
}
