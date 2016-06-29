package com.bignerdranch.android.nerdmail.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.android.nerdmail.R;
import com.bignerdranch.android.nerdmailservice.Email;

import java.util.List;

public class EmailAdapter extends RecyclerView.Adapter<EmailViewHolder> {

    private List<Email> mEmails;
    private Context mContext;

    public EmailAdapter(Context context, List<Email> emails) {
        mContext = context;
        mEmails = emails;
    }

    @Override
    public EmailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.list_item_email, parent, false);
        return new EmailViewHolder(mContext, view);
    }

    @Override
    public void onBindViewHolder(EmailViewHolder holder, int position) {
        Email email = mEmails.get(position);
        holder.bindEmail(email);
    }

    @Override
    public int getItemCount() {
        return mEmails.size();
    }
}
