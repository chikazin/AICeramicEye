/* Copyright 2017 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================*/

package com.example.android.tflitecamerademo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TextView;

/**
 * Main {@code Activity} class for the Camera app.
 */
public class CameraActivity extends Activity {
    public boolean judge = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        new Handler().postDelayed(new Runnable() {
            public void run() {

                if (null == savedInstanceState) {
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, Camera2BasicFragment.newInstance())
                            .commit();
                }
            }
        }, 2000);


//            textView1.setVisibility(View.VISIBLE);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("主测试", "youle");
        switch (requestCode) {
            case 1:
                if (requestCode == RESULT_OK) {
                    this.judge = data.getBooleanExtra("key", true);
                    Log.e("主测试", String.valueOf(judge));
                }
                break;
            default:
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
