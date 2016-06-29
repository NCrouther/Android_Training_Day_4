package com.bignerdranch.android.nerdmail.controller;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.bignerdranch.android.nerdmail.model.DataManager;
import com.bignerdranch.android.nerdmail.model.EmailNotifier;
import com.bignerdranch.android.nerdmailservice.Email;

public class EmailService extends IntentService {
    private static final String TAG
            = "com.bignerdranch.android.nerdmail.EmailService";
    public static final String EXTRA_EMAIL
            = "com.bignerdranch.android.nerdmail.EMAIL_EXTRA";
    public static final String EXTRA_CLEAR
            = "com.bignerdranch.android.nerdmail.CLEAR_EXTRA";

    private DataManager mDataManager;

    public static Intent getNotifyIntent(Context context, Email email) {
        Intent intent = new Intent(context, EmailService.class);
        intent.putExtra(EXTRA_EMAIL, email);
        return intent;
    }

    public static Intent getClearIntent(Context context) {
        Intent intent = new Intent(context, EmailService.class);
        intent.putExtra(EXTRA_CLEAR, true);
        return intent;
    }

    public EmailService() {
        super(TAG);
        mDataManager = DataManager.get(this);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        boolean shouldClear = intent.getBooleanExtra(EXTRA_CLEAR, false);
        if (shouldClear) {
            clearEmails();
        } else {
            Email email = (Email) intent.getSerializableExtra(EXTRA_EMAIL);
            mDataManager.insertEmail(email);

            mDataManager.getNotificationEmails().doOnNext(emails -> {
                // notify user about emails
                EmailNotifier notifier = EmailNotifier.get(EmailService.this);
                notifier.notifyOfEmails(emails);
            }).subscribe();
        }
    }

    private void clearEmails() {
        mDataManager.markEmailsAsNotified();
    }
}
