package com.tizioincognito.appExample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tizioIncognito.bottomsinglechoicemenu.SingleChoiceBottomSheetMenu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickHere.setOnClickListener {
            SingleChoiceBottomSheetMenu
                    .create()
                    .setMenuTitle("Title single choice")
                    .setMenuSubTitle("Subtitle single choice")
                    .addMenuItem(R.drawable.camera, "Take a picture",
                            "Take a picture description") {
                        //OnClick
                    }
                    .addMenuItem(R.drawable.qrcode_scan, "Read qrCode",
                            "Read qrCore description") {
                        //OnClick
                    }
                    .addMenuItem(R.drawable.pencil, "Modify",
                            "Modify description") {
                        //OnClick
                    }
                    .show(this)
        }
    }
}
