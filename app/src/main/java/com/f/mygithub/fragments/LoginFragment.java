package com.f.mygithub.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.f.mygithub.R;
import com.f.mygithub.mail.SenderEmail;
import com.f.mygithub.utility.ParseHtml;
import com.f.mygithub.utility.ValidateEmailAddress;


public class LoginFragment extends Fragment {
    public static String l = "";
    public static String p = "";

    private ProgressBar progressBar;

    private void autorisation(String login, String password){
        l = login;
        p = password;

        if (l != "" && p != ""){
            ValidateEmailAddress validateEmailAddress = new ValidateEmailAddress(login);
            if (validateEmailAddress.validate()) {
                SenderEmail senderEmail = new SenderEmail(progressBar);
                senderEmail.senderAuthor(LoginFragment.this, l, p);
            }else {
                Toast.makeText(getContext(), "неверный email адресс", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        progressBar = view.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.INVISIBLE);
        EditText editLogin = view.findViewById(R.id.edit_login);
        EditText editPass = view.findViewById(R.id.edit_pass);
        Button buttonEntry = view.findViewById(R.id.entry);

        buttonEntry.setOnClickListener(v -> {
            autorisation(editLogin.getText().toString(), editPass.getText().toString());
            progressBar.setVisibility(ProgressBar.VISIBLE);

            });
        return view;
    }
}