package com.zomob.games.tic_tac_toe;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    TextView game;
    Handler handler;
    Animation animRotate;
    private String responseServer;
    String DeviceId;
    String serial;
    TelephonyManager telephonyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        game = (TextView) findViewById(R.id.game);
        game.setShadowLayer(30, 0, 0, Color.WHITE);
        animRotate = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);

        game.startAnimation(animRotate);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
        // deviceId();
    }

}
    /*private void makeJsonObjReq() {
        RequestQueue queue = Volley.newRequestQueue(this);

        Map<String, String> postParam = new HashMap<String, String>();
        postParam.put("deviceId", DeviceId);
        postParam.put("creationSerial", serial);
        //Toast.makeText(MainActivity.this,DeviceId,Toast.LENGTH_LONG).show();
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                Const.UserTrack, new JSONObject(postParam),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("testheena", response.toString());
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("testheena", "Error: " + error.getMessage());
            }
        }) {



        /*    @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }

        };

        jsonObjReq.setTag("testheena");
        // Adding request to request queue
        queue.add(jsonObjReq);
    }
    private void deviceId() {
        telephonyManager = (TelephonyManager) getSystemService(this.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 101);

        }
        else if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            //   ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 101);


            DeviceId = telephonyManager.getDeviceId();
            serial = telephonyManager.getSimSerialNumber();
          makeJsonObjReq();
            return;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 101:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED)
                    {
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 101);
                        return;
                    }

                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
        DeviceId = telephonyManager.getDeviceId();
        serial = telephonyManager.getSimSerialNumber();

   makeJsonObjReq();
    }*/


