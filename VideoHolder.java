package com.example.cat201try2;

import android.annotation.SuppressLint;
import android.view.View;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VideoHolder extends RecyclerView.ViewHolder {
    WebView webView;
    Button button;

    @SuppressLint("SetJavaScriptEnabled")
    public VideoHolder(@NonNull View itemView) {
        super(itemView);
        webView = itemView.findViewById(R.id.video_view);
        button = itemView.findViewById(R.id.fullscreen);
        webView.setWebViewClient(new WebViewClient());

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onPermissionRequest(PermissionRequest request) {

                        String[] PERMISSIONS = {
                                PermissionRequest.RESOURCE_AUDIO_CAPTURE,
                                PermissionRequest.RESOURCE_VIDEO_CAPTURE
                        };
                        request.grant(PERMISSIONS);
                    }


        });
        webView.getSettings().setJavaScriptEnabled(true);
    }
}


