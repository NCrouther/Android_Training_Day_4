package com.bignerdranch.android.nerdmail.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.android.nerdmail.R;
import com.bignerdranch.android.nerdmailservice.Email;

public class EmailViewHolder extends RecyclerView.ViewHolder {

    private TextView mSenderTextView;
    private TextView mSubjectTextView;
    private TextView mBodyTextView;
    private ImageView mImportantImageView;

    public EmailViewHolder(Context context, View itemView) {
        super(itemView);
        mSenderTextView = (TextView)
                itemView.findViewById(R.id.list_item_email_sender_address);
        mSubjectTextView = (TextView)
                itemView.findViewById(R.id.list_item_email_subject);
        mBodyTextView = (TextView)
                itemView.findViewById(R.id.list_item_email_body);
        mImportantImageView = (ImageView)
                itemView.findViewById(R.id.list_item_email_important_icon);
    }

    public void bindEmail(Email email) {
        mSenderTextView.setText(email.getSenderAddress());
        mSubjectTextView.setText(email.getSubject());
        mBodyTextView.setText(email.getBody());
        if (email.isImportant()) {
            mImportantImageView.setImageResource(R.drawable.ic_important);
        } else {
            mImportantImageView.setImageResource(R.drawable.ic_unimportant);
        }
    }
}
