package com.f.mygithub.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.f.mygithub.R;
import com.f.mygithub.mail.SenderEmail;
import com.f.mygithub.utility.ValidateEmailAddress;

public class LetterFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_letter, container, false);

        WebView webView = view.findViewById(R.id.letter_web);
        EditText editText = view.findViewById(R.id.to_email_edit);
        ProgressBar progressBar = view.findViewById(R.id.progress_bar_letter);
        progressBar.setVisibility(View.INVISIBLE);
        Button button = view.findViewById(R.id.button_letter);

        assert getArguments() != null;
        String html = getArguments().getString("email");
        webView.loadDataWithBaseURL(null,html, "text/html", "UTF-8", null);
        button.setOnClickListener(v -> {
            ValidateEmailAddress validateEmailAddress = new
                    ValidateEmailAddress(editText.getText().toString());
            if (validateEmailAddress.validate()) {
                progressBar.setVisibility(View.VISIBLE);
                SenderEmail senderEmail = new SenderEmail(progressBar,editText.getText().toString());
                senderEmail.sender(html.getBytes());
            }else {
                Toast.makeText(getContext(), "неверный email адресс", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}