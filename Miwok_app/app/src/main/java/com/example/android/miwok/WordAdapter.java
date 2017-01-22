package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class WordAdapter extends ArrayAdapter<Word> {

    private TextView miwokTextView;
    private TextView defaultTextView;

    WordAdapter(Context context, ArrayList<Word> words) {
        super(context, 0, words);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(parent.getContext()).inflate(R.layout.two_text_layout, parent, false);
        }
        Word currentWord = getItem(position);

        miwokTextView = (TextView) listView.findViewById(R.id.ttl_miwok_text);
        defaultTextView = (TextView) listView.findViewById(R.id.ttl_english_text);
        miwokTextView.setText(currentWord.getMiwokTranslation());
        defaultTextView.setText(currentWord.getDefaultTranslation());

        return listView;
    }
}
